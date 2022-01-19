SELECT * FROM cantiere.Dump2021Dez31;

CREATE TABLE `Dump2021Dez31` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Abscissa` float DEFAULT NULL,
  `Ordinate` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `cantiere`.`Dump2021Dez31`(
--`id`,
`Abscissa`,
`Ordinate`) VALUES(
--<{id: }>,
<{Abscissa: }>,
<{Ordinate: }>
);

--##
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
