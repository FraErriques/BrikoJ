/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  itfraerr
 * Created: 25 feb 2022
 */

---@@@@@
USE [dotazioni2022]
GO
/****** Object:  StoredProcedure [dbo].[usp_genericaautovettura_INSERT]    Script Date: 02/25/2022 16:49:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[usp_genericaautovettura_INSERT]
	--@autovettura_id [int] IDENTITY(1,1) NOT NULL,
    @targa_autovettura [varchar](255),
	@registration_date  [date],
	@km [float],
	@rifornimento_luogo [varchar](255),
	@rifornimento_litri  [float],
	@costo_gasolio_euro_litro [float],
	@spesa_gasolio_euro [float],
	@accessori_descriz [varchar](255),
	@accessori_euro [float],
	@lavaggio_descr [varchar](255),
	@lavaggio_euro [float],
	@manutenzione_descr [varchar](255),
	@data_ingresso_officina [date],
	@data_uscita_officina [date],
	@manutenzione_euro [float],
	@altro_descriz [varchar](255),
	@altro_euro [float],
	@sinistro_descriz [varchar](255),
	@conducente [varchar](255),
	@riga_descriz [varchar](255),
	@costo_totale_riga_euro [float],
	@franchigia_assicurazione_euro [float]
as
--
insert into [dotazioni2022].[dbo].[generica_autovettura]
(
--  [autovettura_id]  [int] IDENTITY(1,1) NOT NULL,
[targa_autovettura],
[registration_date] ,
[km],
[rifornimento_luogo],
[rifornimento_litri] ,
[costo_gasolio_euro_litro] ,
[spesa_gasolio_euro] ,
[accessori_descriz] ,
[accessori_euro],
[lavaggio_descr],
[lavaggio_euro],
[manutenzione_descr],
[data_ingresso_officina],
[data_uscita_officina],
[manutenzione_euro],
[altro_descriz],
[altro_euro],
[sinistro_descriz],
[conducente],
[riga_descriz] ,
[costo_totale_riga_euro] ,
[franchigia_assicurazione_euro] 
		)values(
	--@autovettura_id  [int] IDENTITY(1,1) NOT NULL,
	@targa_autovettura,
	@registration_date ,
	@km,
	@rifornimento_luogo,
	@rifornimento_litri  ,
	@costo_gasolio_euro_litro ,
	@spesa_gasolio_euro ,
	@accessori_descriz ,
	@accessori_euro,
	@lavaggio_descr,
	@lavaggio_euro,
	@manutenzione_descr,
	@data_ingresso_officina,
	@data_uscita_officina,
	@manutenzione_euro,
	@altro_descriz,
	@altro_euro,
	@sinistro_descriz,
	@conducente,
	@riga_descriz ,
	@costo_totale_riga_euro ,
	@franchigia_assicurazione_euro 
)
GO
