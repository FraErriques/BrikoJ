/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB_thread;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 * NB. the tag <anyInstance> means that the constructor receives an open connection,
 * which can refer to any PostgreSql instance, provided that it has the DB_Numerics, with the appropriate procedures.
 */
public class PostgreSql_anyInstance_Prime_LOAD_AtMaxOrdinal implements Runnable
{
    public javax.swing.JTextArea local_txtClipboard;
    Connection con;
    
    //Ctor
    public PostgreSql_anyInstance_Prime_LOAD_AtMaxOrdinal(javax.swing.JTextArea txtClipboard, Connection con)
    {
        this.local_txtClipboard = txtClipboard;
        this.con = con;
    }//Ctor
    
    // NB. do NOT call this method directly, since it would be executed within the caller thread. 
    // To guarantee that the VM lets the OS fork a new thread, the "start()" method of the Thread class must be called instead. 
    // Such method is implemented to spawn a new thread and let it execute the code of the overridden "run()" method.
    // NB. ***** an instance of the Thread class is required, in the caller code, like the following:
    // Thread t = new Thread( theForker, Common.MonteCarlo.MonteCarloGenerator.UID() );
    // **** the first parameter is the instance of the class that implements Runnable;
    // **** the second parameter is the thread name. No unicity is required for the name, but it's very useful
    // to implement the unicity, for being able to recognize which thread is coming in action. As an example
    // I want to check-in every thread that comes to write in a Logging application, for the purpose of recognizing 
    // its stack, and so be able to know which functions such thread owns and deduce its indentment level.
    // TODO:
    //Create a class that implements Runnable .
    //Provide a run method in the Runnable class.
    //Create an instance of the Thread class and pass your Runnable object to its constructor as a parameter.
    //Call the Thread object's start method.  <------NB
    @Override
    public void run()
    {// forked thread
        java.util.ArrayList<Entity.Proxy.PrimedataRiga> res = null;
        try {
            res = Entity.Proxy.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_.usp_PrimeData_LOAD_atMaxOrdinal_Postgres_SERVICE_(con);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSql_anyInstance_Prime_LOAD_AtMaxOrdinal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// run    
    
}// class
