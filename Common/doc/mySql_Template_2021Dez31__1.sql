-- create database cantiere

-- NB. pwd for 'root' Riemann0
-- NB. Auto_INCREMENT reports the level_reached+1.

fra@Eulero:~$ service mysql  stop
fra@Eulero:~$ service mysql  status
fra@Eulero:~$ service mysql  start
sudo pwd:fra


-- drop table `cantiere`.`Primes`
 
  --  int NOT NULL AUTO_INCREMENT  
  
  CREATE TABLE `cantiere`.`Dump2021Dez31`(
  `id`  int(11) NOT NULL AUTO_INCREMENT,
  `Abscissa` float,
  `Ordinate` float,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `cantiere`.`Primes`(
  `Ordinal` int(11) NOT NULL AUTO_INCREMENT,
  `Prime` bigint(20) NOT NULL,
  PRIMARY KEY (`Ordinal`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `Primes` (
  `Ordinal` int(11) NOT NULL AUTO_INCREMENT,
  `Prime` bigint(20) NOT NULL,
  PRIMARY KEY (`Ordinal`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

select * from `cantiere`.`Primes`

DELIMITER $$
CREATE DEFINER=`mysql.cantiere`@`localhost` PROCEDURE `usp_cantiere_Primes_INSERT`( IN in_Prime BIGINT UNSIGNED )
    MODIFIES SQL DATA
    SQL SECURITY INVOKER
    COMMENT '\n Description\n \n Inserts a single Prime, at the first free Ordinal.\n '
BEGIN
insert into  `cantiere`.`Primes`
(
 /* --Ordinal  */
Prime
)values(
/* --Ordinal Identity(1,1) ,i.e.  NOT NULL AUTO_INCREMENT */
in_Prime
);
END$$
DELIMITER ;

--##
22:25:17	
CREATE DEFINER=`mysql.cantiere`@`localhost` 
PROCEDURE `usp_cantiere_Primes_INSERT`( IN in_Prime BIGINT UNSIGNED )
    MODIFIES SQL DATA     
    SQL SECURITY INVOKER     
    COMMENT '\n Description\n \n Inserts a single Prime, at the first free Ordinal.\n ' 
    BEGIN insert into  `cantiere`.`Primes` (  /* --Ordinal  */ Prime )
    values( /* --Ordinal Identity(1,1) ,i.e.  NOT NULL AUTO_INCREMENT */ in_Prime ); 
    END	
    
    0 row(s) affected, 1 warning(s): 1449 The user specified as a definer ('mysql.cantiere'@'localhost') does not exist	0,00072 sec


insert into  `cantiere`.`Primes`
(
 /* --Ordinal  */
Prime
)values(
/* --1  */
13
)


--##
DELIMITER $$
CREATE DEFINER=`mysql.cantiere`@`localhost` PROCEDURE `usp_cantiere_Primes_INSERT`( IN in_Prime BIGINT UNSIGNED )
    MODIFIES SQL DATA
    SQL SECURITY INVOKER
    COMMENT '\n Description\n \n Inserts a single Prime, at the first free Ordinal.\n '
BEGIN
insert into  `cantiere`.`Primes`
(
 /* --Ordinal  */
Prime
)values(
/* --Ordinal Identity(1,1) ,i.e.  NOT NULL AUTO_INCREMENT */
in_Prime
);
END$$
DELIMITER ;

call `cantiere`.`usp_cantiere_Primes_INSERT`(17)
call `cantiere`.`usp_cantiere_Primes_LOAD`()

DELIMITER $$
CREATE PROCEDURE `usp_cantiere_Primes_LOAD`()
    COMMENT '\n Description\n\n LOAD multi on table Primes.\n '
BEGIN
select * from `cantiere`.`Primes`;
END$$
DELIMITER ;

SELECT Ordinal, Prime FROM Primes ORDER BY Ordinal ASC

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

call  `usp_cantiere_Dump2021Dez31_INSERT` ( 0.7 , sin(0.7) );

select * from Dump2021Dez31