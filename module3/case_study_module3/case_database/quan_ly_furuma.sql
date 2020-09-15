drop database if exists furima_khunghiduong_quan_ly;
create database furima_khunghiduong_quan_ly;
use furima_khunghiduong_quan_ly;

-- -----------------------------------------------------------nhan vien--------------------------
-- tao ban vi tri
create table vitri(
id_vitri int primary key,
ten_vitri varchar(45)
);

-- tao bang trinh do
create table trinhdo(
id_trinhdo int primary key,
ten_trinhdo varchar(50) not null
);

-- tao ban bo phan
 create table bophan(
 id_bophan int primary key,
 ten_bophan varchar(50) not null
 );
 
-- tao ban nhan vien
create table nhanvien(
id_NhanVien int primary key,
ho_va_ten varchar(50) not null,
id_vi_tri int not null,
id_trinh_do int not null,
id_bo_phan int not null,
ngay_sinh date not null,
soCMND varchar(10) not null,
luong int not null,
so_dien_thoai varchar(20),
email varchar(50),
dia_chi varchar(50) not null,
foreign key (id_vi_tri) references vitri(id_vitri),
foreign key (id_trinh_do) references trinhdo(id_trinhdo),
foreign key(id_bo_phan) references bophan(id_bophan)
);
 -- ---------------------------------dich vu
  -- tao bang loai dich vu
 create table loaidichvu(
 id_loaidichvu int primary key,
 ten_cua_loai_dich_vu varchar(50) not null
 );
 
  -- tao bang kieu thue
  create table kieuthue(
 id_kieuthue int primary key,
 ten_kieuthue varchar(50) not null, 
 gia int not null
 );


  -- tao bang dich vu
 create table dichvu(
 id_dichvu int primary key,
 dientich int not null,
 sotang int not null,
 so_nguoi_toi_da int not null,
 chi_phi_thue int not null,
 id_kieuthue int not null,
 id_loaidichvu int not null,
 trang_thai varchar(45) not null,
 foreign key(id_kieuthue)references kieuthue(id_kieuthue),
 foreign key(id_loaidichvu) references loaidichvu(id_loaidichvu)
 );
 
 -- --------------------------------khach hang----------------
  -- tao bang loai khach
 create table loaikhach(
 id_loaikhach int primary key,
 ten_loai_khach varchar(45) not null
 );
  -- tao bang khach hang
 create table khachhang(
 id_khachhang int primary key,
 id_loaikhach int not null,
 ho_va_ten varchar(50) not null,
 ngay_sinh date not null,
 soCMND varchar(45) not null,
 so_dien_thoai varchar(12) not null,
 email varchar(45) not null,
 dia_chi varchar(50) not null,
 foreign key(id_loaikhach) references loaikhach(id_loaikhach)
 );
 
 -- ------------------------------------------- hop dong
  -- tao bang hop dong
 create table hopdong(
 id_hopdong int primary key,
 id_nhanvien int not null,
 id_khachhang int not null,
 id_dichvu int not null,
 ngay_lam_hop_dong date not null,
 ngay_ket_thuc date not null,
 tien_dat_coc int not null,
 tongtien int not null,
 foreign key(id_nhanvien) references nhanvien(id_NhanVien),
 foreign key(id_dichvu) references dichvu(id_dichvu),
 foreign key(id_khachhang) references khachhang(id_khachhang)
 );

 -- tao bang dich vu di kem
 create table dichvudikem(
 id_dichvudikem int primary key,
 ten_dichvudikem varchar(50) not null,
 gia int not null,
 donvi int not null,
 trang_thai_kha_dung varchar(50) not null
 );
 -- tao bang hop dong chi tiet
 create table hopdongchitiet(
 id_hopdongchitiet int primary key,
 id_hopdong int not null,
 id_dichvudikem int ,
 soluong int not null,
 foreign key(id_hopdong)references hopdong(id_hopdong),
 foreign key(id_dichvudikem)references dichvudikem(id_dichvudikem)
 );
 
-- -----------------------------------chèn dữ liệu vào bảng---------------------------------
 -- bảng bộ phận 
insert into bophan
values
(1,'Sale-Marketing'),
(2,'Hành chính'),
(3,'Quản lý'),
(4,'Phục vụ'),
(5,'Sale-Marketing'),
(6,'Sale-Marketing');

insert into trinhdo
values
(1,'Cao đẳng'),
(2,'Trung cấp'),
(3,'Đại học'),
(4,'Sau đại học'),
(5,'Cao đẳng'),
(6,'Đại học');

insert into vitri
values
(1,'Lễ tân'),
(2,'Phục vụ'),
(3,'Chuyên viên'),
(4,'Giám sát'),
(5,'Quản lý'),
(6,'Giám đốc');

insert into nhanvien
values 
(1,'Nguyễn Quốc Khánh',6,6,3,'1994-09-02','123123123',15000000,'0909876645','khanh@gmail.com','Quảng Nam'),
(2,'Hân Thị Mông',2,6,3,'1998-02-01','123123124',5000000,'0909876645','khanh2@gmail.com','Quảng Ninh'),
(3,'Lương Phú Tùng',3,6,3,'1997-03-02','123123125',500000,'0909876645','khanh3@gmail.com','Quảng An'),
(4,'Lương Vũ Quang Công',1,6,3,'1994-09-02','123123128',50000,'0909876645','khanh4@gmail.com','Quảng Ngãi'),
(5,'Trần Thị Huyền',1,6,3,'1993-02-01','123123124',1000000,'0909876645','khanh5@gmail.com','Quảng Bình'),
(6,'Khương Văn Dừa',5,3,2,'1998-03-02','123123122',1000000,'0909876645','khanh6@gmail.com','Quảng Trị');

insert into loaikhach
values
(1loaikhach,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Sliver'),
(5,'Member');

insert into khachhang
values
(1,2,'Uzumaki Naruto','1997-12-12','123123123','01230123433','naruto@gmail.com','konoha'),
(2,1,'Uchiha Suzuke','1997-12-12','123123123','099991239','suzuke@gmail.com','Ame'),
(3,3,'Hatake Kakashi','1997-12-12','123123123','0899123123','kakashi@gmail.com','Kaze'),
(4,4,'Rock Lee','1997-12-12','123123123','078122123','lee@gmail.com','Suna'),
(5,5,'Huyga Hinata','1997-12-12','123123123','067123123','hianata@gmail.com','Ikanari');

