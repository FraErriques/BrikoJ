package Common.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;





/************************************************************
A Logging class, on the Sink DataBase.
* follow the db-scripts, to be executed prior to use the application layer:
* 
* 
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

public class LogSinkDb {
    private Common.DBservice.ConnectionProviderPostgreSqlITFORS1011 _ITFORS1011 = null;
    private PreparedStatement pstmt = null; // Stored as an instance field
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private String logTableName = null;

    public LogSinkDb(String table_name) {
        try {
            this._ITFORS1011 = new Common.DBservice.ConnectionProviderPostgreSqlITFORS1011("Cantor");
            this.logTableName = table_name;
            
            // 1. Create table check
            String createTableSql = "SELECT create_log_table(?)";
            try (PreparedStatement initStmt = _ITFORS1011.getConnection().prepareStatement(createTableSql)) {
                initStmt.setString(1, logTableName);
                initStmt.execute();
            }

            // 2. PREPARE THE TRACE STATEMENT ONCE AND KEEP IT STICKY
            String traceSql = "SELECT trace(?, ?, ?, ?, ?, ?)";
            this.pstmt = _ITFORS1011.getConnection().prepareStatement(traceSql);

        } catch (Exception ex) {
            System.out.println("Error initializing LogSinkDb: " + ex.getMessage());
        }
    }

    public void trace(String row_nature, String stack_depth, String function_name, String log_content) {
        try {
            // Re-using the pre-compiled statement (Zero preparation overhead inside the loop!)
            pstmt.setString(1, this.logTableName);
            pstmt.setString(2, LocalDateTime.now().format(formatter));
            pstmt.setString(3, row_nature);
            pstmt.setString(4, stack_depth);
            pstmt.setString(5, function_name);
            pstmt.setString(6, log_content);
            
            pstmt.execute();
        } catch (Exception ex) {
            System.out.println("Failed to write trace log: " + ex.getMessage());
        }
    }

    public void dispose() {
        try {
            // Close the reusable statement first
            if (this.pstmt != null) {
                this.pstmt.close();
            }
            // Then close the underlying connection
            if (this._ITFORS1011 != null) {
                _ITFORS1011.closeConnection();
            }
        } catch (Exception ex) {
            System.out.println("Error during dispose: " + ex.getMessage());
        }
    }
}
