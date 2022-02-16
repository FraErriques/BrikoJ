/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fra
 * Created: Dec 30, 2021
 */


systemctl status mssql-server --no-pager

default mssql-server instance on Eulero
sqlcmd -U sa
sa
Riemann0

USE [dotazioni2022]
GO
/****** Object:  Table [dbo].[Panda_FR937FT]    Script Date: 02/16/2022 17:37:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[ge135zj]
(
    [ge135zj_id]  [int] IDENTITY(1,1) NOT NULL,
    [data] [date] NULL,
    [km] [float] NULL,
    rifornimento_luogo [varchar](255) NOT NULL,
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
 CONSTRAINT [PK_dotazioni2022_ge135zjID_] PRIMARY KEY CLUSTERED
(
	[ge135zj_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO



CREATE TABLE dbo.NumDump2021 (
  id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
  abscissa float,
  ordinate float   )
GO

CREATE PROCEDURE usp_NumDump2021_INSERT
        @abscissa float,
	@ordinate float  
   AS  
   BEGIN  
      -- data is nullable, both in abscissa and in ordinate
	INSERT INTO NumDump2021 (
	  --id
	  abscissa,
  	  ordinate   
			 ) values(
	     --id 
	     @abscissa,
	     @ordinate   );  
   END
GO

 

CREATE TABLE dbo.Products  (
    ProductID int PRIMARY KEY NOT NULL,  
    ProductName varchar(25) NOT NULL,  
    Price money NULL,  
    ProductDescription varchar(max) NULL)  
GO

-- Changing the order of the columns  
INSERT dbo.Products (ProductName, ProductID, Price, ProductDescription)  
    VALUES ('Screwdriver', 50, 3.17, 'Flat head')  
GO

-- Dropping the optional dbo and dropping the ProductDescription column  
INSERT Products (ProductID, ProductName, Price)  
    VALUES (3000, '3 mm Bracket', 0.52)  
GO

CREATE PROCEDURE pr_Names @VarPrice money  
   AS  
   BEGIN  
      -- The print statement returns text to the user  
      PRINT 'Products less than ' + CAST(@VarPrice AS varchar(10));  
      -- A second statement starts here  
      SELECT ProductName, Price FROM vw_Names  
            WHERE Price < @varPrice;  
   END  
GO
