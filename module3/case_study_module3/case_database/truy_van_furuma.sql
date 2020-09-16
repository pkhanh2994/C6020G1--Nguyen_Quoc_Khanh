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
where (year(hopdong.ngay_lam_hop_dong)<2019 );

-- câu 7
select dichvu.id_dichvu, dichvu.ten_dich_vu, dichvu.dientich,dichvu.so_nguoi_toi_da,
dichvu.chi_phi_thue,loaidichvu.ten_cua_loai_dich_vu,hopdong.ngay_lam_hop_dong
from dichvu
inner join loaidichvu on loaidichvu.id_loaidichvu=dichvu.id_loaidichvu
inner join hopdong on hopdong.id_dichvu=dichvu.id_dichvu
where year(hopdong.ngay_lam_hop_dong)=2018 and dichvu.id_dichvu not in(
select dichvu.id_dichvu
from dichvu
inner join hopdong on hopdong.id_dichvu=dichvu.id_dichvu
where(year(hopdong.ngay_lam_hop_dong)=2019)
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
select count(khachhang.id_khachhang) as 'Số khách hàng đặt phòng',month(hopdong.ngay_lam_hop_dong) as 'Tháng',sum(tongtien)as 'Tổng tiền',hopdong.ngay_lam_hop_dong as'Ngày làm hợp đồng'
from hopdong
inner join khachhang on khachhang.id_khachhang=hopdong.id_khachhang
where month(hopdong.ngay_lam_hop_dong) and year(hopdong.ngay_lam_hop_dong)=2019
group by month(hopdong.ngay_lam_hop_dong)
order by  month(hopdong.ngay_lam_hop_dong);


