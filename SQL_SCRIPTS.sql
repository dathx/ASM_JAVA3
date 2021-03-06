USE [QLSV_ASM_JAVA3]
GO
/****** Object:  Table [dbo].[STUDENTS]    Script Date: 8/15/2020 4:31:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[STUDENTS](
	[MASV] [varchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[Email] [varchar](50) NULL,
	[SoDT] [varchar](15) NULL,
	[GioiTinh] [bit] NULL,
	[DiaChi] [nvarchar](200) NULL,
	[Hinh] [nvarchar](100) NULL,
	[TiengAnh] [float] NULL,
	[TinHoc] [float] NULL,
	[GDTC] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MASV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USERS]    Script Date: 8/15/2020 4:31:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERS](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[vaitro] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh], [TiengAnh], [TinHoc], [GDTC]) VALUES (N'SV01', N'Nguyễn Thùy Diễm', N'datcoicc@gmail.com', N'01111265', 1, N'TP HCM', N'hinh2.jpg', 8.6000003814697266, 9.8000001907348633, 10)
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh], [TiengAnh], [TinHoc], [GDTC]) VALUES (N'SV02', N'Nguyễn Thị Tú Anh', N'anhlun@gmail.com', N'0134546534', 0, N'TP ĐN', N'hinh1.jpg', 10, 10, 10)
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh], [TiengAnh], [TinHoc], [GDTC]) VALUES (N'SV03', N'Nguyễn Thị Vy', N'vyvy@gmail.com', N'0126898568', 0, N'TP Đà Nẵng', N'hinh11.jpg', 5, 1, 6)
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh], [TiengAnh], [TinHoc], [GDTC]) VALUES (N'SV04', N'Lê Thị Thanh Trúc', N'thanhthanh@gmail.com', N'0134546534', 1, N'TP ĐN', N'hinh5.jpg', 8, 9, 10)
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh], [TiengAnh], [TinHoc], [GDTC]) VALUES (N'SV05', N'Nguyễn Thị Ánh', N'anhnn@gmail.com', N'0213556898', 0, N'TP HP', N'hinh4.jpg', 10, 10, 10)
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh], [TiengAnh], [TinHoc], [GDTC]) VALUES (N'SV06', N'Nguyễn Hoàng Anh Thư', N'anhns@gmail.com', N'0265859545', 1, N'TP HN', N'hinh3.jpg', 9, 7, 10)
INSERT [dbo].[STUDENTS] ([MASV], [HoTen], [Email], [SoDT], [GioiTinh], [DiaChi], [Hinh], [TiengAnh], [TinHoc], [GDTC]) VALUES (N'SV07', N'Nguyễn Thùy Mỹ Thủy', N'thuythuy@gmail.com', N'01236985885', 0, N'TP Hà Nội', N'hinh10.jpg', 0, 0, 0)
INSERT [dbo].[USERS] ([username], [password], [vaitro]) VALUES (N'abc', N'123', N'can bo dao tao')
INSERT [dbo].[USERS] ([username], [password], [vaitro]) VALUES (N'acb', N'123', N'giang vien')
INSERT [dbo].[USERS] ([username], [password], [vaitro]) VALUES (N'datcoi', N'dat123', N'giang vien')
INSERT [dbo].[USERS] ([username], [password], [vaitro]) VALUES (N'hihi', N'abc123', N'giang vien')
INSERT [dbo].[USERS] ([username], [password], [vaitro]) VALUES (N'vv', N'abc', N'can bo dao tao')
