/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common.Dictionary;

/**
 *
 * @author fra
 */
public class TheNode {
    private String name;
    private String email;
    public TheNode( String name, String email)
    {
        this.name = name;
        this.email = email;
    }// Ctor
    public void internalPrint()
    {
        System.out.println("\n------------Recapiti:\n");
        System.out.println("\n\t"+this.name);
        System.out.println("\n\t"+this.email);
    }//internalPrint
}// class
