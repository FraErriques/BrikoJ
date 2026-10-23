/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fra
 * Created: Dec 31, 2021
 */



  CREATE TABLE `cantiere`.`Dump2021Dez31`(
  `id`  int(11) NOT NULL AUTO_INCREMENT,
  `Abscissa` float,
  `Ordinate` float,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



DELIMITER $$
CREATE DEFINER=`mysql.cantiere`@`localhost` PROCEDURE `usp_cantiere_Dump2021Dez31_INSERT`(
 /*  --id  */
 IN in_Abscissa float,
 IN in_Ordinate float
)
    MODIFIES SQL DATA
    SQL SECURITY INVOKER
    COMMENT '\n Description\n \n Inserts a couple, {x,f(x)} at the first free id.\n '
BEGIN
insert into  `cantiere`.`Dump2021Dez31`
(
   /*  --id  */
   Abscissa,
   Ordinate
		  )values(
    /*  --id  */
    in_Abscissa,
    in_Ordinate
);
END$$
DELIMITER ;
