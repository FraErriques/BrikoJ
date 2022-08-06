/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Table;

/**
 *
 * @author itfraerr
 */
public class ZetaDump extends TxtParser
{
    //----------- data--------------
    public double s_real;
    public double s_immaginary;
    public double z_real;
    public double z_immaginary;
    public double image_real;
    public double image_immaginary;
    //----------- data--------------
    
    //Ctor
    public ZetaDump(
        String par_s_real,
        String par_s_immaginary,
        String par_z_real,
        String par_z_immaginary,
        String par_image_real,
        String par_image_immaginary
    )
    {
        this.s_real =           tryParseDouble(       par_s_real);
        this.s_immaginary =     tryParseDouble( par_s_immaginary);
        this.z_real =           tryParseDouble(       par_z_real);
        this.z_immaginary =     tryParseDouble( par_z_immaginary);
        this.image_real =       tryParseDouble(       par_image_real);
        this.image_immaginary = tryParseDouble( par_image_immaginary);
    }// Ctor
    
    public void Postgres_ProxyWrapper_(
        Common.DBservice.PostgreSql postgreSql    
    )
    {
        Entity.Proxy.PostgreSql_ZetaDump.usp_Numerics_ZetaDump(
            // first an open connection, which allows to iterate in bulk insertions.
            postgreSql.connection,
            // [id] IDENTITY
            this.s_real,
            this.s_immaginary ,
            this.z_real,
            this.z_immaginary,
            this.image_real,
            this.image_immaginary
        );
    }// Postgres_ProxyWrapper_    
    
}// class ZetaDump
