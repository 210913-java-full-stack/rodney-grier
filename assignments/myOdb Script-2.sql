DROP database if exists myOdb;
CREATE DATABASE myOdb;
use myOdb;

DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS junction_ac;

# Build Tables

CREATE table junction_ac
(
	junction_id int auto_increment,
	account_id int not null,
	customer_id int not null,
	email  varchar (200),
	index (account_id),
	index (customer_id),
	constraint primary key (junction_id)
	
);



CREATE TABLE accounts
(
	account_id int not null,
	balance decimal(10,2),
	constraint primary key (account_id),
	constraint acct_cust_fk foreign key (account_id) references junction_ac (account_id)
);

CREATE table address
(
	address_id 		int auto_increment,
	address			varchar(200),
	city			varchar(200),
	state			char(2),
	zip				int not null,
	constraint address_pk Primary Key (address_id)
);

CREATE table customers
(
	customer_id	int not null,
	firstname		varchar(200),
	middlename		varchar(20),
	lastname		varchar(200),
	email		varchar(200),
	address_id	int not null,
	index (email),
	constraint Primary Key (customer_id),
	constraint junction_ac_fk	foreign key (customer_id) references junction_ac (customer_id),
	constraint address_fk	foreign key (address_id) references address (address_id)
);

# Populate table with data

INSERT INTO junction_ac (customer_id, account_id) VALUES (0001, 900001);
INSERT INTO junction_ac (customer_id, account_id) VALUES (0001, 900002);
INSERT INTO junction_ac (customer_id, account_id) VALUES (0002, 900003);
INSERT INTO junction_ac (customer_id, account_id) VALUES (0002, 900004);
INSERT INTO junction_ac (customer_id, account_id) VALUES (0003, 900005);
INSERT INTO junction_ac (customer_id, account_id) VALUES (0004, 900006);
INSERT INTO junction_ac (customer_id, account_id) VALUES (0005, 900007);

INSERT INTO address (address, city, state, zip) VALUES ("1 Way st.", "Tampa", "FL", 12345);
INSERT INTO address (address, city, state, zip) VALUES ("144 Bleeker st.", "Austin", "TX", 55447);
INSERT INTO address (address, city, state, zip) VALUES ("86 fuzzy lane", "Dallas", "TX", 55445);
INSERT INTO address (address, city, state, zip) VALUES ("212 1st ave", "Albany", "NY", 12210);
INSERT INTO address (address, city, state, zip) VALUES ("74 Daytona Ave.", "Albany", "NY", 12210);

INSERT INTO customers (customer_id, firstname, middlename, lastname, email, address_id) VALUES (0001, "Jason", "", "Smith", "j@dotcom", 2);
INSERT INTO customers (customer_id, firstname, middlename, lastname, email, address_id) VALUES (0002, "Amanda", "", "Smith", "k@dotcom", 4);
INSERT INTO customers (customer_id, firstname, middlename, lastname, email, address_id) VALUES (0003, "John", "", "Cross", "m@dotcom", 1);
INSERT INTO customers (customer_id, firstname, middlename, lastname, email, address_id) VALUES (0004, "Marty", "Andrew", "Gras", "c@dotcom", 3);
INSERT INTO customers (customer_id, firstname, middlename, lastname, email, address_id) VALUES (0005, "Jason", "A.", "Lastname", "d@dotcom", 5);

INSERT INTO accounts (account_id, balance) VALUES (900001, 1500.50);
INSERT INTO accounts (account_id, balance) VALUES (900002, 2780.25);
INSERT INTO accounts (account_id, balance) VALUES (900003, 150);
INSERT INTO accounts (account_id, balance) VALUES (900004, 13.33);
INSERT INTO accounts (account_id, balance) VALUES (900005, 100000.01); 
INSERT INTO accounts (account_id, balance) VALUES (900006, 12345.67);
INSERT INTO accounts (account_id, balance) VALUES (900007, 1345.67);


#Db Test

SELECT c.firstname, c.middlename, c.lastname, c.email, ad.address, ad.city, ad.state, a.account_id, a.balance
FROM customers c
JOIN junction_ac ac ON c.customer_id = ac.customer_id
JOIN accounts a ON ac.account_id = a.account_id
JOIN address ad ON c.address_id = ad.address_id
ORDER BY a.balance DESC;

