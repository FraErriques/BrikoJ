/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testconsole;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JAutoDialogo extends JFrame
{
    private JTextField t1;
    private JTextField t2;
    
    public static void main (String argv[])
    {
        JAutoDialogo ist = new JAutoDialogo();
    }// main

    public JAutoDialogo() throws HeadlessException 
    {
        JPanel pannelloTesto = new JPanel( new GridLayout(0,2,3,3));
        JPanel pannelloBottoni = new JPanel();
        setTitle( getClass().getName() );
        pannelloTesto.add( new JLabel("Testo 1", JLabel.LEFT) );
        pannelloTesto.add( t1 = new JTextField("") );
        pannelloTesto.add( new JLabel("Testo 2", JLabel.LEFT) );
        pannelloTesto.add( t2 = new JTextField(""));
        pannelloBottoni.setLayout( new FlowLayout() );
        ((JButton)pannelloBottoni.add( new JButton("Scambia")) ).addActionListener(
          new ActionListener()     {
              public void actionPerformed( ActionEvent e)  {
                  String scambio = t1.getText();
                  t1.setText( t2.getText());
                  t2.setText(scambio);
              }// end actionPerformed
          } // end new ActionListener 
        );// end addActionListener
        ((JButton)pannelloBottoni.add(new JButton("Esci"))).addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e) {
                System.exit(0);
            }
        } );
        
        getContentPane().add( pannelloTesto, "Center");
        getContentPane().add( pannelloBottoni, "South");
        pack();
        setVisible( true);
}// end Ctor JAutoDialogo    
    
    
               
} // end class JAutoDialogo
