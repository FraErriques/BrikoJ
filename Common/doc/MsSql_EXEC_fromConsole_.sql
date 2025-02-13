USE [dotazioni2022]
GO

DECLARE	@return_value int

EXEC	@return_value = [dbo].[usp_ge135zj_INSERT]
		@data = '2020-12-31',
		@km = 112,
		@rifornimento_luogo = N'some place',
		@litri = 65,
		@gasolio_euro_litro = 1.654,
		@gasolio_euro = 95,
		@accessori_descr = NULL,
		@accessori_euro = NULL,
		@lavaggio_descr = NULL,
		@lavaggio_euro = NULL,
		@manutenzione_descr = NULL,
		@data_ingresso_officina = NULL,
		@data_uscita_officina = NULL,
		@manutenzione_euro = NULL,
		@altro_descriz = NULL,
		@altro_euro = NULL,
		@sinistro_descriz = NULL,
		@conducente = NULL,
		@descrizione_riga = N'some description',
		@costo_totale_riga = 95,
		@franchigia_assicurazione = NULL

SELECT	'Return Value' = @return_value
GO
-----####
select * from dotazioni2022.dbo.ge135zj
/*
NB. da console mettere gli apici intorno alle date e non intorno alle stringhe.
*/
----