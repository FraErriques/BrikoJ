package Common.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Common.DBservice.ConnectionProviderPostgres;




/************************************************************
A Logging class, on the Sink DataBase.
* follow the db-scripts, to be executed prior to use the application layer:
* 
* -- Connect to 'postgres' or 'template1' first, then:
--DROP DATABASE IF EXISTS logging WITH (FORCE);

-- =========================================================================
-- DBA SETUP SCRIPT FOR LOGGING INFRASTRUCTURE
-- Run this script as a superuser (e.g., postgres) prior to application startup.
-- =========================================================================

-- 1. Create the dedicated schema (and optional database if creating from scratch)
-- CREATE DATABASE logging; -- Uncomment if a brand-new database is desired
CREATE SCHEMA IF NOT EXISTS logging;

-- 2. Create the dedicated least-privilege user
DO $$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = 'app_user') THEN
      CREATE ROLE app_user LOGIN PASSWORD 'application-user';
   END IF;
END
$$;

-- 3. Revoke default public schema access and grant strict isolation to logging schema
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT USAGE, CREATE ON SCHEMA logging TO app_user;

-- Ensure app_user cannot traverse or access other schemas (like public)
REVOKE ALL ON SCHEMA public FROM app_user;


-- =========================================================================
-- 4. FUNCTION: logging.create_log_table(text)
-- =========================================================================
CREATE OR REPLACE FUNCTION logging.create_log_table(logname text)
    RETURNS void
    LANGUAGE 'plpgsql'
    SECURITY DEFINER -- Ensures DDL executes with owner privileges safely
    SET search_path = logging, pg_temp
AS $BODY$
DECLARE
    table_exists text;
    cmd text;
BEGIN
    -- Strong check using format('%I', ...) to prevent SQL injection
    SELECT TO_REGCLASS(format('%I', logname)) INTO table_exists;

    IF table_exists IS NULL THEN
        -- Construct the dynamic SQL statement to create the table in 'logging' schema
        cmd := format(
            'CREATE TABLE logging.%I ('
            '    id SERIAL PRIMARY KEY, '
            '    when_time TIMESTAMPTZ NOT NULL, '
            '    row_nature CHAR(3) NOT NULL, '
            '    stack_depth VARCHAR(5) NOT NULL, '
            '    function_name VARCHAR(50) NOT NULL, '
            '    log_content VARCHAR(7919) NOT NULL'
            ')',
            logname
        );

        -- Execute the dynamic command
        EXECUTE cmd;
    END IF;
END;
$BODY$;

ALTER FUNCTION logging.create_log_table(text) OWNER TO postgres;


-- =========================================================================
-- 5. FUNCTION: logging.trace(text, text, text, text, text, text)
-- =========================================================================
CREATE OR REPLACE FUNCTION logging.trace(
    logname text,
    when_time text,
    row_nature text,
    stack_depth text,
    function_name text,
    log_content text)
    RETURNS void
    LANGUAGE 'plpgsql'
    SECURITY DEFINER
    SET search_path = logging, pg_temp
AS $BODY$
DECLARE
    table_exists text;
    cmd text;
BEGIN
    -- Strong check using format('%I', ...) to verify table existence safely
    SELECT TO_REGCLASS(format('%I', logname)) INTO table_exists;

    IF table_exists IS NOT NULL THEN
        -- Construct the dynamic INSERT statement safely using %I for table name 
        -- and %L for string literals / timestamp formatting
        cmd := format(
            'INSERT INTO logging.%I (when_time, row_nature, stack_depth, function_name, log_content) '
            'VALUES (%L::TIMESTAMPTZ, %L, %L, %L, %L)',
            logname,
            when_time,
            row_nature,
            stack_depth,
            function_name,
            log_content
        );

        -- Execute the dynamic insert command
        EXECUTE cmd;
    ELSE
        -- Required table not found -> do nothing
        NULL;
    END IF;
END;
$BODY$;

ALTER FUNCTION logging.trace(text, text, text, text, text, text) OWNER TO postgres;
GRANT EXECUTE ON FUNCTION logging.trace(text, text, text, text, text, text) TO app_user;


-- =========================================================================
-- 6. PERMISSIONS ASSIGNMENT
-- =========================================================================
REVOKE EXECUTE ON FUNCTION logging.create_log_table(text) FROM PUBLIC;
GRANT EXECUTE ON FUNCTION logging.create_log_table(text) TO app_user;
GRANT EXECUTE ON FUNCTION logging.create_log_table(text) TO postgres;

REVOKE EXECUTE ON FUNCTION logging.trace(text, text, text, text, text, text) FROM PUBLIC;
GRANT EXECUTE ON FUNCTION logging.trace(text, text, text, text, text, text) TO app_user;
GRANT EXECUTE ON FUNCTION logging.trace(text, text, text, text, text, text) TO postgres;

*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogSinkDb {
    private final ConnectionProviderPostgres provider;
    private final String logTableName;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogSinkDb(String tableName, String serverName, String dbUrl, String user, String password) {
        this.provider = new ConnectionProviderPostgres(serverName, dbUrl, user, password);
        this.logTableName = tableName;

        System.out.println("Database connection initialized for table: " + logTableName);

        // Call logging.create_log_table(?) once upon initialization
        String createTableSql = "SELECT logging.create_log_table(?)";
        Connection conn = provider.getConnection();
        
        if (conn == null) {
            throw new RuntimeException("Failed to obtain active connection for table creation.");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(createTableSql)) {
            pstmt.setString(1, logTableName);
            pstmt.execute();
            System.out.println("-> Checked/Created log table: " + logTableName);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create log table: " + e.getMessage(), e);
        }
    }

    // Trace method optimized for numerical analysis loops
    public void trace(String rowNature, String stackDepth, String functionName, String logContent) {
        String traceSql = "SELECT logging.trace(?, ?, ?, ?, ?, ?)";
        String currentFormattedDate = LocalDateTime.now().format(DATE_FORMATTER);

        Connection conn = provider.getConnection();
        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("Failed to write trace log: Connection is closed or unavailable.");
                return;
            }

            try (PreparedStatement pstmt = conn.prepareStatement(traceSql)) {
                pstmt.setString(1, logTableName);
                pstmt.setString(2, currentFormattedDate);
                pstmt.setString(3, rowNature);
                pstmt.setString(4, stackDepth);
                pstmt.setString(5, functionName);
                pstmt.setString(6, logContent);
                pstmt.execute();
            }
        } catch (SQLException e) {
            System.err.println("Error writing trace: " + e.getMessage());
        }
    }

    // Explicit dispose method
    public void dispose() {
        provider.closeConnection();
    }
}