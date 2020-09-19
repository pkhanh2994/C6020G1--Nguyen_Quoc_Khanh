drop database if exists view_SP_index;
create database view_SP_index;
use view_SP_index;

create table products(
Id int primary key,
productCode varchar(20)not null,
productName varchar(45) not null,
productPrice int not null,
productAmount int,
productDescription text,
productStatus varchar(45) not null);

insert into products
values
(1,'SP0001','yamaha',15,20,'abc','oke'),
(2,'SP0002','suzuki',16,21,'gg','not oke'),
(3,'SP0003','lexus',17,22,'abhhc','oke'),
(4,'SP0004','honda',18,23,'kk','not oke'),
(5,'SP0005','mazda',19,24,'ll','oke');

create unique index idx_product on products(productCode);
 create index composite_idx on products(productName, productPrice);
 drop index composite_idx on products ;
 
explain select *
 from products 
 where productName='yamaha';
 
 create view products_information as
 select productCode,productName,productPrice,productStatus from products;
 
 select * from products_information;
 
 update products_information
 set productName='mishubishi'
 where productCode='SP0001';
 
drop view products_information;

delimiter //
create procedure find_information_products()
begin
select *
from products;
end //
delimiter ;
call find_information_products();

delimiter //
create procedure add_new_product(Id int,productCode varchar(20),
productName varchar(45),
productPrice int,productAmount int,productDescription text,
productStatus varchar(45))
begin
insert into products
values(Id,productCode,productName,productPrice,productAmount,productDescription,productStatus);
end //
delimiter ;


call add_new_product(7,'SP0007','Kia1',1500,3000,'good','oke');

delimiter //
create procedure update_info_product(id int,new_productCode varchar(20),
new_productName varchar(45),
new_productPrice int,new_productAmount int,new_productDescription text,
new_productStatus varchar(45))
begin
update products p
set  productCode=new_productCode,productName=new_productName,productPrice=new_productPrice,
productAmount=new_productAmount,productDescription=new_productDescription,productStatus=new_productStatus
where p.id=id;
end //
delimiter ;

call update_info_product(6,'SP0008','yamaha',15,20,'abc','oke');

delimiter //
create procedure delete_product(id int)
begin
delete from products where products.id=id;
end //
delimiter ;

call delete_product(1);
