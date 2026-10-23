package Common.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;





/************************************************************
A Logging class, on the Sink DataBase.
*/
public class LogSinkDb
{



/*  TODO
1) create database logging NB. lowercase
2) FUNCTION public.create_log_table(text)
3) :
ALTER FUNCTION public.create_log_table(text)
    OWNER TO postgres;
--  NB. Grant USAGE and CREATE permissions on the public schema
GRANT USAGE, CREATE ON SCHEMA public TO app_user;
GRANT ALL ON SCHEMA public TO app_user;
GRANT EXECUTE ON FUNCTION public.create_log_table(text) TO PUBLIC;
GRANT EXECUTE ON FUNCTION public.create_log_table(text) TO app_user;
GRANT EXECUTE ON FUNCTION public.create_log_table(text) TO postgres;
4) :
ALTER FUNCTION public.trace(text, text, text, text, text, text)
    OWNER TO postgres;
GRANT EXECUTE ON FUNCTION public.trace(text, text, text, text, text, text) TO PUBLIC;
GRANT EXECUTE ON FUNCTION public.trace(text, text, text, text, text, text) TO app_user;
GRANT EXECUTE ON FUNCTION public.trace(text, text, text, text, text, text) TO postgres;
*/

/*
-- FUNCTION: public.create_log_table(text)

-- DROP FUNCTION IF EXISTS public.create_log_table(text); NB. lowercase

CREATE OR REPLACE FUNCTION public.create_log_table(
logname text)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
DECLARE
    cmd text;
    table_exists text;
BEGIN
    -- Check if the table already exists in the current schema
    -- (equivalent to checking OBJECT_ID(@logname) IS NULL)
    SELECT TO_REGCLASS(logname) INTO table_exists;

    IF table_exists IS NULL THEN
        -- Construct the dynamic SQL statement to create the table
        cmd := format(
            'CREATE TABLE %I ('
            '    id SERIAL PRIMARY KEY, '
            '    when_time VARCHAR(50) NOT NULL, '
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
*/

/*
-- FUNCTION: public.trace(text, text, text, text, text, text)

-- DROP FUNCTION IF EXISTS public.trace(text, text, text, text, text, text);

CREATE OR REPLACE FUNCTION public.trace(
logname text,
when_time text,
row_nature text,
stack_depth text,
function_name text,
log_content text)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
DECLARE
    table_exists text;
    cmd text;
BEGIN
    -- Check if the table exists in the database
    -- (equivalent to checking OBJECT_ID('Logging..' + @logname) IS NOT NULL)
    SELECT TO_REGCLASS(logname) INTO table_exists;

    IF table_exists IS NOT NULL THEN
        -- Construct the dynamic INSERT statement safely using %I for table name
        -- and %L for string literals (escaping quotes automatically)
        cmd := format(
            'INSERT INTO %I (when_time, row_nature, stack_depth, function_name, log_content) '
            'VALUES (%L, %L, %L, %L, %L)',
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
        -- Required table not found -> do nothing (matches your T-SQL logic)
        NULL;
    END IF;
END;
$BODY$;
*/




    // entry point
    public static void LogSinkDb_test(String[] args) {
        // Update connection string, user, and password to match your PostgreSQL instance
        String url = "jdbc:postgresql://localhost:5432/logging";
        String user = "app_user";
        String password = "application-user";
        String logTableName = "app_activity_log";
        // SQL statements calling the PostgreSQL functions we ported
        String createTableSql = "SELECT create_log_table(?)";
        String traceSql = "SELECT trace(?, ?, ?, ?, ?, ?)";
        // -- logging tools:
        // Define your pattern for date-time : // Output looks like: 2026-10-20 13:15:00        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = LocalDateTime.now().format(formatter);
       
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to PostgreSQL database successfully.");

            // 1. Call create_log_table() once
            try (PreparedStatement pstmt = conn.prepareStatement(createTableSql)) {
                pstmt.setString(1, logTableName);
                pstmt.execute();
                System.out.println("-> Checked/Created log table: " + logTableName);
            }

            for (int c=1; c<= 100; c++)
            {
            // 2. First call to trace()
            try (PreparedStatement pstmt = conn.prepareStatement(traceSql)) {
                pstmt.setString(1, logTableName);
                pstmt.setString(2, LocalDateTime.now().format(formatter) );
                pstmt.setString(3, "INF");
                pstmt.setString(4, "1");
                pstmt.setString(5, "Main");
                pstmt.setString(6, "Application initialized successfully.");
                pstmt.execute();
                System.out.println("-> Inserted first trace log.");
            }

            // 3. Second call to trace()
            try (PreparedStatement pstmt = conn.prepareStatement(traceSql)) {
                pstmt.setString(1, logTableName);
                pstmt.setString(2, LocalDateTime.now().format(formatter) );
                pstmt.setString(3, "DBG");
                pstmt.setString(4, "2");
                pstmt.setString(5, "ConnectModule");
                pstmt.setString(6, "Sub-system modules loaded and verified.");
                pstmt.execute();
                System.out.println("-> Inserted second trace log.");
            }
           
            }// for

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }//main
   
}// class
