/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Table;

/**
 *
 * @author itfraerr
 */
public class ReportAuto 
{
    // all data fields are common to both MsSql-server and PostgreSql
    //....
    /* 

    *** Object:  Table [dbo].[ge135zj]    Script Date: 02/23/2022 10:54:57 ***

    CREATE TABLE [dbo].[ge135zj](
    [ge135zj_id] [int] IDENTITY(1,1) NOT NULL,
    String targaVettura, NB. deve essere utilizzata solo quando  la tabella e' multivettura. Altrimenti scegliere la tabella e non passare il parametro.
    [data] [date] NULL,
    [km] [float] NULL,
    [rifornimento_luogo] [varchar](255) NOT NULL,
    [litri] [float] NULL,
    [gasolio_euro_litro] [float] NULL,
    [gasolio_euro] [float] NULL,
    [accessori_descr] [varchar](255) NULL,
    [accessori_euro] [float] NULL,
    [lavaggio_descr] [varchar](255) NULL,
    [lavaggio_euro] [float] NULL,
    [manutenzione_descr] [varchar](255) NULL,
    [data_ingresso_officina] [date] NULL,
    [data_uscita_officina] [date] NULL,
    [manutenzione_euro real] [float] NULL,
    [altro_descriz] [varchar](255) NULL,
    [altro_euro] [float] NULL,
    [sinistro_descriz] [varchar](255) NULL,
    [conducente] [varchar](255) NULL,
    [descrizione_riga] [varchar](255) NOT NULL,
    [costo_totale_riga] [float] NOT NULL,
    [franchigia_assicurazione] [float] NULL,

    -----end data ------------- */

    
    // Ctor
    public ReportAuto()//params.....
    {}
    
    public void Postgres_ProxyWrapper_()
    {}//params will let understandable if the insertion has to be on a named table xor in the "all-car" one.
    
    public void MsSql_ProxyWrapper_()
    {}//params will let understandable if the insertion has to be on a named table xor in the "all-car" one.    
    
    private String wrapSqlStrings( String par)// both dates and actual strings
    {
        String res = "'" + par + "'";
        return res;
    }// wrapSqlStrings
    
}// class ReportAuto
