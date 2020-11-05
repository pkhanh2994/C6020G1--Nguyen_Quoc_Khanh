use manager_blog;

create table app_user(user_id int primary key,user_name varchar(255));

create table app_role(role_id int primary key,role_name varchar(255));
insert into app_role (role_id, role_name) values (1, 'ROLE_ADMIN');

insert into app_role (role_id, role_name) values (2, 'ROLE_USER');

create table user_role (id int,user_id int,  role_id int);
alter table user_role add constraint app_user_fk foreign key(user_id) references app_user(user_id);
alter table user_role add constraint app_role_fk foreign key(role_id) references app_role(role_id);
alter table app_user add column user_password varchar(255);
alter table app_user add column encryted_password text;
alter table app_user add column enabled int;
alter table app_user drop column user_password;

insert into user_role  values (1, 1, 1);

insert into user_role values (2, 1, 2);

insert into user_role  values (3, 2, 2);
