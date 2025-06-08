--create database Numerics
--use Numerics


USE [Numerics]
GO

/****** Object:  Table [dbo].[ZetaDump]    Script Date: 22/01/2022 21:23:55 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ZetaDump](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Re_s] [float] NOT NULL,
	[Im_s] [float] NOT NULL,
	[Re_z] [float] NOT NULL,
	[Im_z] [float] NOT NULL,
	[Re_image] [float] NOT NULL,
	[Im_image] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

--####
USE [Numerics]
GO

/****** Object:  StoredProcedure [dbo].[usp_ZetaDump_INSERT]    Script Date: 22/01/2022 21:34:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



CREATE         procedure [dbo].[usp_ZetaDump_INSERT]
	@Re_s	float,
	@Im_s	float,
	@Re_z	float,
	@Im_z	float,
	@Re_image	float,
	@Im_image	float
AS
insert into [ZetaDump](
	--[id] [int] IDENTITY(1,1) NOT NULL,
	[Re_s],
	[Im_s],
	[Re_z],
	[Im_z],
	[Re_image],
	[Im_image]
			)values(
	--id
	@Re_s,
	@Im_s,
	@Re_z,
	@Im_z, 
	@Re_image,
	@Im_image
)
GO

