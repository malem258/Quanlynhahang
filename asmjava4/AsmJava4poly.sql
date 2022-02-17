use AsmJava4
go
create database [AsmJava4]
go 
use AsmJava4 
go
create table [user]
(id int primary key identity,
username varchar(10) unique not null,
[password] varchar (10) not null,
email varchar (50) unique not null,
isAdmin bit not null default 0,
isActive bit not null default 1,
)
go
create table video
(id int primary key identity,
title nvarchar (255) not null,
href varchar (50) unique,
poster varchar(255) null,
[views] int not null default 0,
shares int not null default 0,
[description] nvarchar(255) not null,
isActive bit not null default 1,


)
go
create table history
(id int primary key identity,
userId int foreign key references[user](id),
videoId int foreign key references video(id),
viewedDate datetime not null default getDate(),
isLiked bit not null default 0,
likedDate datetime null,

)
go
insert into [user](username,[password],email,isAdmin) values
('huy','111', 'phantu@gmail.com',1),
('haiy','3411', 'anhntu@gmail.com',0)
go
insert into video(title,href,[description] )values
(N'SAO EM VÔ TÌNH | JACK x K-ICM ft. LIAM | HƯƠNG LY COVER', 'llMHKYyzCEo',  N'huong ly- jack'),
(N'CHẮC AI ĐÓ SẼ VỀ - SƠN TÙNG M-TP | HƯƠNG LY COVER',       'VtuwWr5eEP4',  N'HuongLy -kct'),
(N'Cao Ốc 20 | B Ray x DatG ( Masew Mix )',                  '_YuVs1ihPjo',  N'bray')
go

insert into history(userId,videoId, isLiked, likedDate) values
(2,1,1, getDate()),
(2,3,0,null)
go