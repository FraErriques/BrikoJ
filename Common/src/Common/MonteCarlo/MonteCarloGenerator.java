/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package Common.MonteCarlo;


public class MonteCarloGenerator
{
	public static long nextInteger( int min, int max)
	{
            int omothetia = max - min;
            int traslazione = min;            
            return java.lang.Math.round( java.lang.Math.random() * omothetia + traslazione );
	}// nextInteger
    
        public static double nextProbabilityMeasure()
        {
            return java.lang.Math.random();
        }// nextProbabilityMeasure
        
        public static String UID()
        {
            StringBuilder sb = new StringBuilder(17);
            int omothetia = 127-48;
            int traslazione = 48;
            for(int c=0; c<16; c++)
            {
                double tmp = nextProbabilityMeasure();
                int designatedChar =  (int) (tmp*omothetia + traslazione);
                sb.append((char)designatedChar );
            }
            return sb.toString();
        }// UID        
        
}// end class
