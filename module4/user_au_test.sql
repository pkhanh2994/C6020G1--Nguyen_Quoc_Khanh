drop database if exists user_au_test;
create database user_au_test;
use user_au_test;

create table app_user(user_id int primary key,user_name varchar(255));

create table app_role(role_id int primary key,role_name varchar(255));

insert into app_role values(1,"create"),(2,"update"),(3,"delete"),(4,"view");

create table user_role (id int,user_id int,  role_id int);
alter table user_role add constraint app_user_fk foreign key(user_id) references app_user(user_id);
alter table user_role add constraint app_role_fk foreign key(role_id) references app_role(role_id);
alter table app_user add column user_password varchar(255);
alter table app_user add column encryted_password text;
alter table app_user add column enabled int;
alter table app_user drop column user_password;


