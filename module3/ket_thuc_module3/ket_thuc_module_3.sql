drop database if exists productDB;
create database productDB;
use productDB;
create table category(categoryID int auto_increment primary key,
typeOfProduct varchar(100));

create table color(colorID int auto_increment primary key,colorName varchar(50));
insert into color(colorName) value("Red"),
("Green"),("Black"),("White"),("Yellow");
insert into category(typeOfProduct)values("computer"),("telephone"),("television"),
("refrigerator"); 
create table product(productID int  primary key auto_increment,productName varchar(50),
price double,quantity int,
categoryID int,`description` varchar(100), colorID int,
constraint fk_category foreign key(categoryID) references category(categoryID) on delete cascade on update cascade,
constraint fk_color foreign key(colorID) references color(colorID) on update cascade on delete cascade);


insert into product(productName,price,quantity,categoryID,`description`,colorID) 
values("galaxy",1000,5,1,"Oke",1),
("samsung",1000,5,2,"Oke",2),
("galaxy",1000,5,3,"Oke",3);

select productID,productName,price,quantity,categoryID,`description`,colorID from product where productName="Tom Ga";

