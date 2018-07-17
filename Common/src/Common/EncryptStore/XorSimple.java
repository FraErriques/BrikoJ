/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common.EncryptStore;

/**
 *
 * @author itfraerr
 */
public class XorSimple
{
    
    public int getEncryptedIntByXorSimple( int key)
    {
        int primoOperando = 56;
        int secondoOperando = 3;
        int result = primoOperando^key;// bitwise XOR operator.
        int back = result^key;// ont the second step, we're back where we started.        
        boolean testSucceded = (back==primoOperando);
        //
        return result;
    }// end method getEncryptedIntByXorSimple
    
}// end class
