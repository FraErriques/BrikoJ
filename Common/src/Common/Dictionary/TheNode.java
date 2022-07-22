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
    private String internal;
    private String cellPhone;
    public TheNode( 
            String name, 
            String email,
            String internal,
            String cellPhone
        )// Ctor
    {
        this.name = new String(name);
        this.email = new String (email);
        this.internal = new String(internal);
        this.cellPhone = new String (cellPhone);        
    }// Ctor
    public void internalPrint()
    {
        System.out.print("\n-----------------------Recapiti: ");
        System.out.print("\n\t"+this.name);
        System.out.print("\n\t"+this.email);
        System.out.print("\n\t"+this.internal);
        System.out.print("\n\t"+this.cellPhone);
        System.out.println("\n----------------------------------");
    }//internalPrint
    public void prepareGarbageCollection()
    {
        this.name = null;
        this.email = null;
        this.internal = null;
        this.cellPhone = null;
    }// prepareGarbageCollection
}// class
