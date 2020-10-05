drop database if exists demo2;
create database demo2;
use demo2;

create table users(
id int not null auto_increment,
`name` varchar(50) not null,
email varchar(50) not null,
country varchar(50) not null,
primary key (id));

insert into users(`name`,email,country)
values
("Minh","Minh@gmail.com","Viet Nam"),
("Job","Job@gmail.com","USA"),
("Kakashi","kakashi@gmail.com","Japan");
select * from users order by `name`;


create table Permision(

id int primary key auto_increment,

name varchar(50)

);


create table User_Permision(

permision_id int,

user_id int

);

insert into Permision(name) values('add');

insert into Permision(name) values('edit');

insert into Permision(name) values('delete');

insert into Permision(name) values('view');


delimiter //
create procedure find_information_users()
begin
select *
from users;
end //
delimiter ;
call find_information_users();

delimiter //
create procedure update_information_users(id int,
new_name varchar(50),new_email varchar(50),new_country varchar(50))
begin
update users s
set `name`=new_name,email=new_email,country=new_country
where s.id=id;
end//
delimiter ;

delimiter //
CREATE  PROCEDURE get_user_by_id(user_id int)
begin
select users.name,users.country,users.email
from users where users.id=user_id;
end//
delimiter ;

delimiter //
create procedure delete_users(id int)
begin
delete from users where users.id=id;
end//
delimiter ;