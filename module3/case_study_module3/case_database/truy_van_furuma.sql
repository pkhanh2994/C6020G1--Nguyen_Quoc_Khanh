-- câu 2
select* 
from nhanvien
where ho_va_ten regexp '\\s[HTK]\\w+$' and char_length(ho_va_ten)<=15;
-- câu 3
select *
from khachhang
where ((YEAR(curdate()) - YEAR(ngay_sinh)) between 18 and 50 ) and  dia_chi in('Đà Nẵng','Quảng Trị'); 

-- câu 4
select  khachhang.ho_va_ten as 'Họ và tên',count(khachhang.id_khachhang) as 'Số lần đặt phòng', loaikhach.ten_loai_khach as 'Tên loại khách'
from khachhang
inner join hopdong on hopdong.id_khachhang=khachhang.id_khachhang
inner join loaikhach on loaikhach.id_loaikhach=khachhang.id_loaikhach
group by khachhang.id_khachhang,khachhang.id_loaikhach
having khachhang.id_loaikhach=1
order by count(khachhang.id_khachhang);

-- câu 5
select khachhang.id_khachhang, khachhang.ho_va_ten,loaikhach.ten_loai_khach,hopdong.id_hopdong,dichvu.ten_dich_vu,
hopdong.ngay_lam_hop_dong,hopdong.ngay_ket_thuc,dichvu.chi_phi_thue+hopdongchitiet.soluong*dichvudikem.gia
from khachhang
left join hopdong on hopdong.id_khachhang=khachhang.id_khachhang
left join loaikhach on loaikhach.id_loaikhach=khachhang.id_loaikhach
left join dichvu on dichvu.id_dichvu=hopdong.id_dichvu
left join hopdongchitiet on hopdongchitiet.id_hopdong=hopdong.id_hopdong
left join dichvudikem on dichvudikem.id_dichvudikem=hopdongchitiet.id_dichvudikem;
-- group by khachhang.id_khachhang;
-- Câu 6
select dichvu.id_dichvu, dichvu.ten_dich_vu,dichvu.dientich,dichvu.chi_phi_thue,loaidichvu.ten_cua_loai_dich_vu,hopdong.ngay_lam_hop_dong
from dichvu
left join loaidichvu on loaidichvu.id_loaidichvu=dichvu.id_loaidichvu
left join hopdong on hopdong.id_dichvu=dichvu.id_dichvu
where  dichvu.id_dichvu not in(
select dichvu.id_dichvu
from dichvu
left join hopdong on hopdong.id_dichvu=dichvu.id_dichvu
where year(hopdong.ngay_lam_hop_dong)=2019 and month(hopdong.ngay_lam_hop_dong) between 1 and 3
);

-- câu 7
select dichvu.id_dichvu, dichvu.ten_dich_vu, dichvu.dientich,dichvu.so_nguoi_toi_da,
dichvu.chi_phi_thue,loaidichvu.ten_cua_loai_dich_vu,hopdong.ngay_lam_hop_dong
from loaidichvu
inner join dichvu on dichvu.id_loaidichvu=loaidichvu.id_loaidichvu
inner join hopdong on hopdong.id_dichvu=dichvu.id_dichvu
where year(hopdong.ngay_lam_hop_dong)=2018 and dichvu.id_dichvu not in(
select dichvu.id_dichvu
from dichvu
inner join hopdong on hopdong.id_dichvu=dichvu.id_dichvu
where year(hopdong.ngay_lam_hop_dong)=2019
);
-- câu 8
-- cách 1
select distinct khachhang.ho_va_ten as 'Họ và tên'
from khachhang;
-- cách 2
select khachhang.ho_va_ten as'Họ và tên'
from khachhang
group by khachhang.ho_va_ten;
-- cách 3
select khachhang.ho_va_ten as'Họ và tên'
from khachhang
union
select khachhang.ho_va_ten as'Họ và tên'
from khachhang;

-- câu 9
select bang_thang.Tháng ,ifnull(sum(tongtien),0 ) AS 'Doanh thu'
from 
(SELECT '1' AS
'Tháng'
UNION SELECT '2' AS
'Tháng'
UNION SELECT '3' AS
'Tháng'
UNION SELECT '4' AS
'Tháng'
UNION SELECT '5' AS
'Tháng'
UNION SELECT '6' AS
'Tháng'
UNION SELECT '7' AS
'Tháng'
UNION SELECT '8' AS
'Tháng'
UNION SELECT '9' AS
'Tháng'
UNION SELECT '10' AS
'Tháng'
UNION SELECT '11' AS
'Tháng'
UNION SELECT '12' AS
'Tháng') as bang_thang
left join hopdong on month(hopdong.ngay_lam_hop_dong)=bang_thang.`Tháng` and year(hopdong.ngay_lam_hop_dong)='2019'
group by Tháng;

-- câu 10
select hopdong.id_hopdong, hopdong.ngay_lam_hop_dong, hopdong.ngay_ket_thuc,hopdong.tien_dat_coc,count(hopdong.id_hopdong) as 'Số lượng'
from hopdong
inner join hopdongchitiet on hopdongchitiet.id_hopdong=hopdong.id_hopdong
group by hopdong.id_hopdong;

-- câu 11
select dichvudikem.*, khachhang.ho_va_ten
from dichvudikem
inner join hopdongchitiet on hopdongchitiet.id_dichvudikem=dichvudikem.id_dichvudikem
inner join hopdong on hopdong.id_hopdong=hopdongchitiet.id_hopdong
inner join khachhang on khachhang.id_khachhang=hopdong.id_khachhang
inner join loaikhach on loaikhach.id_loaikhach=khachhang.id_loaikhach
where loaikhach.id_loaikhach=1 and khachhang.dia_chi='Vinh' or khachhang.dia_chi='Quảng Ngãi';


-- câu 12
select hopdong.id_hopdong,nhanvien.ho_va_ten as 'Nhân viên',khachhang.ho_va_ten,khachhang.so_dien_thoai,
dichvu.ten_dich_vu,hopdongchitiet.soluong, hopdong.ngay_lam_hop_dong,khachhang.id_khachhang, sum(hopdong.tien_dat_coc)
from hopdong
inner join dichvu on dichvu.id_dichvu=hopdong.id_dichvu
inner join nhanvien on nhanvien.id_NhanVien=hopdong.id_nhanvien
inner join khachhang on khachhang.id_khachhang=hopdong.id_khachhang
inner join hopdongchitiet on hopdongchitiet.id_hopdong=hopdong.id_hopdong
where year(hopdong.ngay_lam_hop_dong)=2019 and (month(hopdong.ngay_lam_hop_dong) between 10 and 12);

-- câu 13
select * 
from(
select dichvudikem.*,sum(hopdongchitiet.soluong) as soluong
from hopdongchitiet 
inner join dichvudikem on dichvudikem.id_dichvudikem=hopdongchitiet.id_dichvudikem
inner join hopdong on hopdong.id_hopdong=hopdongchitiet.id_hopdong
inner join khachhang on khachhang.id_khachhang=hopdong.id_hopdong
group by hopdongchitiet.id_dichvudikem
)as so_luong_dich_vu_khach_su_dung
inner join (
select max(soluong) as b
from(
select dichvudikem.*,sum(hopdongchitiet.soluong) as soluong
from hopdongchitiet 
inner join dichvudikem on dichvudikem.id_dichvudikem=hopdongchitiet.id_dichvudikem
inner join hopdong on hopdong.id_hopdong=hopdongchitiet.id_hopdong
inner join khachhang on khachhang.id_khachhang=hopdong.id_hopdong
group by hopdongchitiet.id_dichvudikem
) as so_luong_dich_vu_khach_su_dung
) as a
on so_luong_dich_vu_khach_su_dung.soluong=a.b;

-- câu 14
	select dichvudikem.ten_dichvudikem,count(dichvudikem.ten_dichvudikem),hopdong.id_hopdong,dichvu.ten_dich_vu,loaidichvu.ten_cua_loai_dich_vu
	from dichvudikem
	inner join hopdongchitiet on hopdongchitiet.id_dichvudikem=dichvudikem.id_dichvudikem
	inner join hopdong on hopdong.id_hopdong=hopdongchitiet.id_hopdong
	inner join dichvu on dichvu.id_dichvu=hopdong.id_dichvu
	inner join loaidichvu on loaidichvu.id_loaidichvu=dichvu.id_loaidichvu
	group by dichvudikem.id_dichvudikem
	having count(dichvudikem.id_dichvudikem)=1;
    
-- câu 15
select nhanvien.id_NhanVien,nhanvien.ho_va_ten,nhanvien.id_trinh_do,trinhdo.ten_trinhdo,nhanvien.id_bo_phan, bophan.ten_bophan,
nhanvien.so_dien_thoai,nhanvien.dia_chi,count(hopdong.id_nhanvien) as so_lan_lam_hop_dong
from nhanvien
inner join bophan on bophan.id_bophan=nhanvien.id_bo_phan
inner join trinhdo on trinhdo.id_trinhdo=nhanvien.id_trinh_do
inner join hopdong on hopdong.id_nhanvien=nhanvien.id_nhanvien
where year(hopdong.ngay_lam_hop_dong)between 2018 and 2019
group by hopdong.id_nhanvien
having so_lan_lam_hop_dong<=3;

-- câu 16
delete from nhanvien
where nhanvien.id_nhanvien not in
(select bang_tam.id_Nhanvien
from 
(select nhanvien.id_NhanVien
from nhanvien
inner join hopdong on hopdong.id_nhanvien=nhanvien.id_NhanVien
where year(hopdong.ngay_lam_hop_dong) between 2017 and 2019) 
as bang_tam);

-- câu 17
update khachhang
set khachhang.id_loaikhach=1
where khachhang.id_khachhang in(
select bang_tam.id_khachhang
from(select khachhang.id_khachhang
from khachhang
inner join hopdong on hopdong.id_khachhang=khachhang.id_khachhang
where year(hopdong.ngay_lam_hop_dong)=2019 and hopdong.tongtien>10) as bang_tam);

-- câu 18
alter table hopdong
 drop foreign key fk_khachhang;
 alter table hopdong
 add constraint fk_khachhang foreign key(id_khachhang) references khachhang(id_khachhang) on delete cascade
 on update cascade;
 alter table hopdongchitiet
 drop foreign key fk_hopdong;
 alter table hopdongchitiet
 add constraint fk_hopdong foreign key(id_hopdong) references hopdong(id_hopdong) on delete cascade
 on update cascade;
delete from khachhang
where id_khachhang in (
select bang_tam.ma_so
from(
select kh.id_khachhang as ma_so
from khachhang kh
inner join hopdong hd on kh.id_khachhang=hd.id_khachhang and year(hd.ngay_lam_hop_dong)<2016
)as bang_tam
);

-- câu 19

update dichvudikem 
set dichvudikem.gia=dichvudikem.gia*2
where dichvudikem.id_dichvudikem in (
select bang_tam.id_dichvudikem
from(
select hopdongchitiet .id_dichvudikem,sum(hopdongchitiet.soluong) as so_luong
from dichvudikem
inner join hopdongchitiet on hopdongchitiet.id_dichvudikem=dichvudikem.id_dichvudikem
group by hopdongchitiet.id_dichvudikem
having so_luong>10 )
 as bang_tam);

-- câu 20
select khachhang.id_khachhang as 'id',khachhang.ho_va_ten,
khachhang.email,khachhang.so_dien_thoai,khachhang.ngay_sinh, khachhang.dia_chi, 'khách hàng' as 'nhân viên hoặc khách hàng'
from khachhang
union all
select nhanvien.id_NhanVien as 'id',nhanvien.ho_va_ten,
nhanvien.email,nhanvien.so_dien_thoai,nhanvien.ngay_sinh,nhanvien.dia_chi,  'nhân viên' as 'nhân viên hoặc khách hàng'
from nhanvien;

-- câu 21
create view v_nhanvien as
select nhanvien.* 
from  nhanvien
inner join hopdong using(id_Nhanvien)
where nhanvien.dia_chi='Hải Châu' and hopdong.ngay_lam_hop_dong='2019-12-12';
select *
from v_nhanvien;

-- câu 22
update v_nhanvien
set v_nhanvien.dia_chi='Liên Chiểu'
where v_nhanvien.dia_chi='Hải Châu';

-- câu 23
delimiter //
create procedure xoa_nhanvien(id int)
begin
delete from nhanvien where nhanvien.id_NhanVien=id;
end //
delimiter ;
call xoa_nhanvien(6);

-- câu 24
delimiter //
drop procedure if exists sp_2//
create procedure sp_2(new_id_hopdong int,
 new_id_nhanvien int,
 new_id_khachhang int ,
 new_id_dichvu int ,
 new_ngay_lam_hop_dong date ,
 new_ngay_ket_thuc date,
 new_tien_dat_coc int,
 new_tongtien int )
 begin
 declare idtam_hopdong int default(-1);
 declare idtam_nhanvien int default(-1);
 declare idtam_khachhang int default(-1);
 declare idtam_dichvu int default(-1);
 --
 select id_hopdong
 into idtam_hopdong 
 from hopdong
 where id_hopdong=new_id_hopdong;
 --
 select id_nhanvien
 into idtam_nhanvien
 from nhanvien
 where id_nhanvien=new_id_nhanvien;
 --
 select id_khachhang
 into idtam_khachhang
 from khachhang
 where id_khachhang=new_id_khachhang;
 --
 select id_dichvu
 into idtam_dichvu
 from dichvu
 where id_dichvu=new_id_dichvu;
  -- kiểm tra
  if ((new_id_hopdong<=0) or (idtam_hopdong<>-1)) then select ('Hợp đồng đã tồn tại') as 'Trạng thái';
  elseif ((new_id_nhanvien<=0) or (idtam_nhanvien=-1)) then select ('Nhân viên không tồn tại') as'Trạng thái';
  elseif ((new_id_khachhang<=0) or (idtam_khachhang=-1)) then select('Khách hàng không tồn tại') as'Trạng thái';
  elseif ((new_id_dichvu<=0) or (idtam_dichvu=-1)) then select('Dịch vụ không tồn tại') as'Trạng thái';
  else 
  select'Đã thêm' as 'Trạng thái';
  insert into hopdong
  value (new_id_hopdong, new_id_nhanvien, new_id_khachhang, new_id_dichvu, new_ngay_lam_hop_dong, new_ngay_ket_thuc, new_tien_dat_coc, new_tongtien);
  end if;
 end //
 delimiter ;
 call sp_2(14,3,1,1,'2011-02-06','2015-02-06',200,300);
 
--  -- câu 25
--  delimiter //
-- create trigger Tr_1
-- after delete on hopdong for each row
-- begin
-- declare 
-- câu 27
delimiter //
create function func_1(hopdong)
returns table 
deterministic
begin
declare dem int
select dem=count(dichvu.id_dichvu)
from hopdong
where hopdong.tongtien>20
returns dem;
end //
delimiter ;



