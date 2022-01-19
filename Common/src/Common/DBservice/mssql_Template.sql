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
