/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  itfraerr
 * Created: 25 feb 2022
 * Environement : MsSql
 */

USE [dotazioni2022]
GO
/****** Object:  Table [dbo].[generica_autovettura]    Script Date: 02/25/2022 16:27:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[generica_autovettura](
	[autovettura_id] [int] IDENTITY(1,1) NOT NULL,
	[targa_autovettura] [varchar](255) NOT NULL,
	[registration_date] [date] NULL,
	[km] [float] NULL,
	[rifornimento_luogo] [varchar](255) NULL,
	[rifornimento_litri] [float] NULL,
	[costo_gasolio_euro_litro] [float] NULL,
	[spesa_gasolio_euro] [float] NULL,
	[accessori_descriz] [varchar](255) NULL,
	[accessori_euro] [float] NULL,
	[lavaggio_descr] [varchar](255) NULL,
	[lavaggio_euro] [float] NULL,
	[manutenzione_descr] [varchar](255) NULL,
	[data_ingresso_officina] [date] NULL,
	[data_uscita_officina] [date] NULL,
	[manutenzione_euro] [float] NULL,
	[altro_descriz] [varchar](255) NULL,
	[altro_euro] [float] NULL,
	[sinistro_descriz] [varchar](255) NULL,
	[conducente] [varchar](255) NULL,
	[riga_descriz] [varchar](255) NOT NULL,
	[costo_totale_riga_euro] [float] NOT NULL,
	[franchigia_assicurazione_euro] [float] NULL,
 CONSTRAINT [PK_dotazioni2022_genericaautovettura_] PRIMARY KEY CLUSTERED 
(
	[autovettura_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
