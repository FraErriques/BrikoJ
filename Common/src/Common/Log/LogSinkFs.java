
package Common.Log;

import java.util.Set;

/************************************************************
A Logging class, on the Sink File System.
*/
public class LogSinkFs
{
    
    /******************* notebook method, for the technique of storing ThreadPrivateCallStack ************************/
    public void ThreadPrivateCallStack( )
    {
        for(int c=0; c<50; c++)
        {            
            System.out.println( Common.MonteCarlo.MonteCarloGenerator.nextInteger(5, 16) );
        }
        
        
        java.util.Hashtable< String, java.util.Stack<String> > threadLoggingStack =
            new java.util.Hashtable< String, java.util.Stack<String> >();
        
        for(int c=0; c<50; c++)
        {
            ThreadForker theForker = new ThreadForker();
            String threadName = Common.MonteCarlo.MonteCarloGenerator.UID();
            Thread t = new Thread( theForker, threadName );            
            threadLoggingStack.putIfAbsent( threadName, new java.util.Stack<String>() );
            //
            t.start();// run asynchronously.
            //
            if( threadLoggingStack.containsKey( threadName) )
            {
                System.out.println("key representing thread named : "+threadName+" found.");
                long cardThreadStack = 0;
                cardThreadStack = Common.MonteCarlo.MonteCarloGenerator.nextInteger(1, 16);
                for(int d=0; d<cardThreadStack; d++)
                {
                    threadLoggingStack.get( threadName).addElement("stack level "+d+" on "+ threadName);
                }
            }
            else
            {
                System.out.println("key representing thread named : "+threadName+" NOT found.");
                threadLoggingStack.putIfAbsent( threadName, new java.util.Stack<String>() );
            }
            
        }// for 50 forks
        
        Set<String> theKeys = threadLoggingStack.keySet();
        Object[] theKeysArray = theKeys.toArray();
        for( int c=0; c<theKeysArray.length; c++)
        {
            System.out.println( (String)(theKeysArray[c]) );
            int cardCurThreadStack = threadLoggingStack.get( (String)(theKeysArray[c]) ).size();
            for( int d=0; d<cardCurThreadStack; d++)
            {
                System.out.println( threadLoggingStack.get( (String)(theKeysArray[c]) ).get(d) );
            }// for cardCurThreadStack
            System.out.println( );
        }// for each thread.
        // done
    }// ThreadPrivateCallStack

    
}// class
