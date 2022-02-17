/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Table;

/**
 *
 * @author itfraerr
 */
public class ReportAuto 
{
    // all data fields are common to both MsSql-server and PostgreSql
    //....
    //
    
    // Ctor
    public ReportAuto()//params.....
    {}
    
    public void Postgres_ProxyWrapper_()
    {}//params will let understandable if the insertion has to be on a named table cor in the "all-car" one.
    
    public void MsSql_ProxyWrapper_()
    {}//params will let understandable if the insertion has to be on a named table cor in the "all-car" one.    
    
    private String wrapSqlStrings( String par)// both dates and actual strings
    {
        String res = "'" + par + "'";
        return res;
    }// wrapSqlStrings
    
}// class ReportAuto
