drop database  if exists compiny;

create database compiny;
use compiny;
create table offices(
officeCode varchar(10) primary key not null,
city varchar(50) not null,
phone varchar(50)not null,
addressLine1 varchar(50)  not null,
addressLine2 varchar(50),
state varchar(50),
country varchar(50),
postalCode varchar(15)
);
create table employees(
employeeNumber int primary key not null,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100),
jobTitle  varchar(50) not null,
reportTo int,
officeCode varchar(10),
foreign key(reportTo) references employees(employeeNumber),
foreign key(officeCode) references offices(officeCode)
);

create table customers(
customerNumber int primary key not null,
customerName varchar(50) not null,
contactLastName varchar(50) not null,
contactFirstName varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
city  varchar(50) not null,
state varchar(50) not null,
postalCode varchar(50) not null,
countryvarchar varchar(50) not null,
creditLimit float ,
salesRepEmployeeNumbe int,
foreign key(salesRepEmployeeNumbe) references employees (employeeNumber)
);
create table orders(
orderNumber int primary key not null,
orderDate date not null,
requiredDate date not null,
shippedDate date not null,
`status` varchar(15) not null,
comments text,
quantityOrdered int not null,
priceEach float not null,
customerNumber int,
foreign key(customerNumber) references customers(customerNumber)
);
create table payments(
customerNumber int primary key not null,
checkNumber varchar(50) not null,
paymentDate date not null,
amount float not null,
foreign key(customerNumber) references customers(customerNumber)
);
create table productlines(
productLine varchar(50) primary key not null,
textDescription text,
image varchar(50)
);

create table products(
productCode varchar(15) primary key,
productName varchar(70) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription text not null,
quantityInStock int not null,
buyPrice float not null,
MSRP float not null,
product_line varchar(50),
foreign key(product_line) references productlines(productLine)
);
create table orderdetails(
productCode varchar(15),
orderNumber int,
primary key(productCode,orderNumber),
foreign key(productCode) references products(productCode),
foreign key(orderNumber) references orders(orderNumber)
);


