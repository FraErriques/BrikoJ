
package testgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public
class Jwin  extends JFrame // NB. cruciale ereditare da JFrame
{
    private JTextField t1;
    private JTextField t2;
    
    public Jwin() throws HeadlessException 
    {
        JPanel pannelloTesto = new JPanel( new GridLayout( 1,5,3,3) );
        JPanel pannelloBottoni = new JPanel();
        setTitle( getClass().getName() + " a GUI test." );
        pannelloTesto.add( new JLabel("Label Uno", JLabel.LEFT) );
        pannelloTesto.add( t1 = new JTextField("") );
        pannelloTesto.add( new JLabel("Label Due", JLabel.LEFT) );
        pannelloTesto.add( t2 = new JTextField(""));
  
        pannelloBottoni.setLayout( new FlowLayout() );

        ((JButton)pannelloBottoni.add( new JButton("DoTheAction")) ).addActionListener(
          new ActionListener()     
          {
              public void actionPerformed( ActionEvent e)  
              {
                  String scambio = t1.getText();
                  t1.setText( t2.getText());
                  t2.setText(scambio);
              }// end actionPerformed
          } // end new ActionListener 
        );// end addActionListener

        ((JButton)pannelloBottoni.add( new JButton("Esci")) ).addActionListener(
          new ActionListener()
          {
            public void actionPerformed( ActionEvent e) 
            {
                System.exit(0);
            }// end actionPerformed
          } // end new ActionListener 
        );// end addActionListener
        
        getContentPane().add( pannelloTesto, "Center");
        getContentPane().add( pannelloBottoni, "South");
        pack();
        setVisible( true);        
    }// Ctor
    
}// class Jwin
