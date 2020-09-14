create database bank_information;
use bank_information;
create table customers(
customer_number varchar(14) not null,
full_name varchar(50),
address varchar(50),
email varchar(40),
phone int,
primary key(customer_number)
);

drop table customers;
create  table accounts(
account_number varchar(15),
account_type varchar(20),
`date` date,
balence int,
customer_number varchar(14),
primary key (account_number),
foreign key (customer_number) references customers(customer_number)
);
create table transactions(
tran_number varchar(50),
account_number varchar(15) not null,
`date` date,
 amounts int,
 descriptions text,
 primary key(tran_number),
  constraint fk_transactions foreign key(account_number) references accounts(account_number)
);

drop table transactions;