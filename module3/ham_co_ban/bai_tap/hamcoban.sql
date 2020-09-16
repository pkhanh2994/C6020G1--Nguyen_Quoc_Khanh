drop database if exists cac_ham_thong_dung;
create database cac_ham_thong_dung;
use cac_ham_thong_dung;

create table hoc_vien(
id_hocvien int primary key,
ten_hocvien varchar(45),
tuoi_hocvien int,
khoa_hoc varchar(15),
so_tien int);

insert into hoc_vien
values
(1,'Hoang',21,'CNTT',400000),
(2,'Viet',19,'DTVT',320000),
(3,'Thanh',18,'KTDN',400000),
(4,'Nhan',19,'CK',450000),
(5,'Huong',20,'TCNH',500000),
(6,'Huong',20,'TCNH',200000);

select*
from hoc_vien
where ten_hocvien='Huong';

select sum(so_tien)
from hoc_vien
where ten_hocvien='Huong';

select distinct ten_hocvien
from hoc_vien;