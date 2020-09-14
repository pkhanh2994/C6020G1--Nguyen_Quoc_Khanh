create database ga_din;
use ga_din;
create table din_ga(
id int,
age int
);

 alter table din_ga
 add heo varchar(50)
 first;
  alter table din_ga
 add ga varchar(50)
 after age;
 alter table din_ga
 modify age char(3) not null;
 select * from din_ga;
 alter table din_ga
 drop column heo;
 alter table din_ga
 change column ga heo
 char(20);
 alter table din_ga
 rename to din_heo;