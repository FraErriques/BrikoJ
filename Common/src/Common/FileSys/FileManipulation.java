
package Common.FileSys;



public class FileManipulation 
{

    public boolean txtFileWriter(String fullPath )
    {
        boolean hasWrittenSuccessfully = false;
        java.io.FileWriter wr = null;
        StringBuilder sb = new StringBuilder(1000);
String firstPrefix = "<table width=100% border=1 bgcolor=\"#AA0000\"><tr><td>";
String threadName = "Thread Name";
//"</td>
//</tr>
//</table>
//<table width=100% border=1 bgcolor="""";
////"#AA0000
String closeFirstTable = "\">";
//<tr>
//<td>indent 1</td>
//<td>indent 2</td>
//<td>indent 3</td>
//<td>indent 4</td>
//<td>indent 5</td>
//<td>indent 6</td>
//<td>indent 7</td>
//<td>indent 8</td>
//<td>content : The Maxwell equations are derived in chapter 15 using the properties of two fundamental groups 
//in Physics: the Lorentz group SO(1,3) and the Poincaré group. Although it may appear that this 
//chapter is disconnected from the rest, it actually has been placed in the right place. On one 
//hand, the Maxwell equations are connected to the most important physical groups,.and further, 
//these are closely related to the conformal group previously introduced, being a natural link 
//to justify the importance of symmetries of differential equations.
//The last chapter connects with the first in the sense that Lie groups are used to determine 
//whether a differential equation can be solved by quadratures or not. Since this is a large 
//and complicated theory, only the basic elements that show how Lie groups are used to simplify 
//the integration of differential equations are presented.
//
//This book constitutes a very comprehensive introduction to Lie theory in physics, dealing 
//with the most important features that students will encounter. The problems help not only 
//to understand the material presented, but also exhibit real physical situations where Lie 
//groups are used This book further solves some difficulties encountered by beginners in 
//other books, usually written at a more specialized level. </td>
//</tr>
//</table>        
        sb.append("some html");
        try 
        {
                wr = new java.io.FileWriter( fullPath, false);// the bool par stand for "append".
                for (int c = 0; c < 9; c++) 
                {
                        wr.write("Stringa di testo di prova.\n");
                        
                        
                        
                        
                }
                wr.flush();
                wr.close();
                hasWrittenSuccessfully = true;
        }// end try-write
        catch( java.io.IOException e)//NB. the kind of exception
        {
                System.out.println("error while trying manipulate filestream : " + e.getMessage());
                hasWrittenSuccessfully = false;
        }
        finally 
        {
                // ?
        }		
        return hasWrittenSuccessfully;
    }// end txtFileWriter
			

    public boolean txtFileReader(String fullPath )
    {
        boolean hasReadSuccessfully = false;
        java.io.FileReader rr = null;
        try
        {
                rr = new java.io.FileReader( fullPath);
                for (int ch = 0; -1 != ch;)
                {
                        ch = rr.read();
                        if( -1 == ch)// means reached EOF.
                        {
                                break;
                        }// else still has to read.
                        System.out.print( (char)ch );// print out char-by-char the read content.
                }// end for "each char in stream".
                rr.close();
                hasReadSuccessfully = true;
        }// end try-read
        catch( java.io.IOException e)//NB. the kind of exception
        {
                System.out.println("error while trying manipulate filestream : " + e.getMessage());
                hasReadSuccessfully = false;
        }
        finally 
        {
                // ?
        }
        return hasReadSuccessfully;
    }// end txtFileReader
	
}// end class
