create database QLSV_ASM_JAVA3
go
use QLSV_ASM_JAVA3

create table GRADE
(
ID int primary key not null,
MASV varchar(50),
TiengAnh float,
TinHoc float,
GDTC float
);

create table STUDENTS
(
MASV varchar(50) primary key not null,
HoTen nvarchar(50),
Email varchar(50),
SoDT varchar(15),
GioiTinh bit,
DiaChi nvarchar(200),
Hinh nvarchar(100)
);

create table USERS
(
username nvarchar(50) primary key not null,
password nvarchar(50),
vaitro nvarchar(50)
);

alter table GRADE 
add constraint  fk foreign key (MASV) references STUDENTS(MASV)

select * from USERS
select * from STUDENTS
select * from GRADE

insert into USERS values
('datcoi','dat123','giang vien'),
('abc','123','can bo dao tao'),
('hihi','abc123','giang vien')