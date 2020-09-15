drop database if exists library;
create database library;
use library;
create table students(
student_number int primary key,
student_name varchar(50),
email varchar(50),
address varchar(50) not null,
image varchar(50),
date_of_birth date
);
create table library_card(
card_number varchar(50) primary key,
student_name varchar(50),
email varchar(50),
address varchar(50) not null,
image varchar(50),
date_of_birth date,
phone_number int,
student_number int,
foreign key (student_number) references students(student_number)
);
create table borrowOder(
student_name varchar(50) not null,
date_return date not null,
date_borrow date not null,
studen_number int not null,
borrow_number int primary key,
card_number_libary_card varchar(50),
foreign key(card_number_libary_card)references library_card(card_number)
);
create table type_of_book(
id int primary key,
book_name varchar(50) not null
);
create table book(
book_number int primary key,
book_name varchar(50) not null,
publisher varchar(50) not null,
author varchar(50) not null,
date_of_publication date,
number_of_pblication int,
type_of_book varchar(50),
price_book int,
student_number_book int,
foreign key(student_number_book) references students(student_number),
borrowOder_number  int,
foreign key(borrowOder_number)references borrowOder(borrow_number),
type_id_book int,
foreign key(type_id_book) references type_of_book(id)
);






