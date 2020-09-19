SELECT * FROM customers WHERE customerNumber = 175; 

EXPLAIN SELECT * FROM customers WHERE customerName = 'king';
drop index idabc on customers;
create index idabc on customers(customerName);

alter table customers
add index abc123(customerName);

alter table customers
drop index abc123;
drop index abc123 on customers;

