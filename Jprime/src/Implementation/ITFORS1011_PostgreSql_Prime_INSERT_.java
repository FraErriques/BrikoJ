/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementation;

/**
 *
 * @author admin
 */
public class ITFORS1011_PostgreSql_Prime_INSERT_ implements Runnable
{
    
    
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
    {
        //do something
        System.out.println("from inside a Forked Thread" );
        System.out.println("current Thread : " + Thread.currentThread() );
        System.out.println( );
    }// run    
    
}// class
