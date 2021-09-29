DROP database if exists firstdb;
CREATE DATABASE firstdb;



use firstdb;

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
	email varchar (200) not null,
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
	email			varchar(200),
	address_id	int not null,
	constraint Primary Key (customer_id),
	constraint junction_ac_fk	foreign key (customer_id) references junction_ac (customer_id),
	constraint address_fk	foreign key (address_id) references address (address_id)
);


# Populate table with data

INSERT INTO junction_ac (email, customer_id ,account_id) VALUES ("Jason@rev.net", 1,900001);
INSERT INTO junction_ac (email, customer_id, account_id) VALUES ("Amanda@rev.net", 2, 900002);
INSERT INTO junction_ac (email, customer_id, account_id) VALUES ("Edward@rev.net", 3, 900003);
INSERT INTO junction_ac (email, customer_id ,account_id) VALUES ("Sam@rev.net", 4, 900004);
INSERT INTO junction_ac (email, customer_id ,account_id) VALUES ("John@rev.net", 5, 900005);
INSERT INTO junction_ac (email, customer_id ,account_id) VALUES ("Marty@rev.net",6,  900006);
INSERT INTO junction_ac (email, customer_id ,account_id) VALUES ("Jason@rev.net",7, 900007);

INSERT INTO address (address, city, state, zip) VALUES ("1 Way st.", "Tampa", "FL", 12345);
INSERT INTO address (address, city, state, zip) VALUES ("144 Bleeker st.", "Austin", "TX", 55447);
INSERT INTO address (address, city, state, zip) VALUES ("86 fuzzy lane", "Dallas", "TX", 55445);
INSERT INTO address (address, city, state, zip) VALUES ("212 1st ave", "Albany", "NY", 12210);
INSERT INTO address (address, city, state, zip) VALUES ("74 Daytona Ave.", "Albany", "NY", 12210);

INSERT INTO customers (customer_id, email, firstname, middlename, lastname, address_id) VALUES (0001, "Jason@rev.net", "Jason", "", "Smith", 2);
INSERT INTO customers (customer_id, email, firstname, middlename, lastname, address_id) VALUES (0002, "Amanda@rev.net", "Amanda", "", "Smith", 4);
INSERT INTO customers (customer_id, email, firstname, middlename, lastname, address_id) VALUES (0003, "John@rev.net", "John", "A", "Cross", 1);
INSERT INTO customers (customer_id, email, firstname, middlename, lastname, address_id) VALUES (0004, "Marty@rev.net", "Marty", "Andrew", "Gras", 3);
INSERT INTO customers (customer_id, email, firstname, middlename, lastname, address_id) VALUES (0005, "Sam@rev.net", "Jason", "A.", "Lastname", 5);

INSERT INTO accounts (account_id, balance) VALUES (900001, 1500.50);
INSERT INTO accounts (account_id, balance) VALUES (900002, 2780.25);
INSERT INTO accounts (account_id, balance) VALUES (900003, 150);
INSERT INTO accounts (account_id, balance) VALUES (900004, 13.33);
INSERT INTO accounts (account_id, balance) VALUES (900005, 100000.01); 
INSERT INTO accounts (account_id, balance) VALUES (900006, 12345.67);
INSERT INTO accounts (account_id, balance) VALUES (900007, 1345.67);

# Db test
SELECT c.firstname, c.middlename, c.lastname, ad.address, ad.city, ad.state, a.account_id, a.balance
FROM customers c
JOIN junction_ac ac ON c.customer_id = ac.customer_id
JOIN accounts a ON ac.account_id = a.account_id
JOIN address ad ON c.address_id = ad.address_id
ORDER BY a.balance DESC;

# Get a list of all customers with the last name "Smith".
SELECT * FROM customers
WHERE lastname LIKE 'Smith';

# Get the total balance of all accounts held by the Smiths.
SELECT SUM(balance) as "Smith's balance"
from accounts a
join junction_ac j on a.account_id = j.account_id
join customers c on c.customer_id = j.customer_id
WHERE c.lastname = 'Smith';

# Get the name and address of any customer with less than $50 in an account. (No duplicates!)
SELECT a.balance, c.firstname, c.middlename, c.lastname, concat(ad.address, ", ", ad.city, ", ", ad.state) as "Address"
FROM customers c
JOIN junction_ac j on c.customer_id = j.customer_id
JOIN accounts a on j.account_id = a.account_id
JOIN address ad on ad.address_id = c.address_id
WHERE balance < 50;

# Get a list of all the customers who live in Texas.
SELECT c.firstname, c.middlename, c.lastname, ad.state
From customers c 
Join address ad on c.address_id = ad.address_id
WHERE state = 'TX';

# Add $100 gift to any accounts belonging to customers in New York
update accounts a
join junction_ac j on a.account_id = j.account_id
join customers c on c.customer_id = j.customer_id
join address ad on ad.address_id = c.address_id
set balance = (balance + 100)
WHERE state = 'NY';

# Transfer $199.99 from Jason Smith to Amanda Smith (This requires two statements)
#From Jason
update accounts a
join junction_ac j on a.account_id = j.account_id
join customers c on c.customer_id = j.customer_id
set balance = (balance - 199.99)
WHERE c.firstname = 'Jason' and c.lastname = 'Smith' and a.account_id = 900001;
#To Amanda
update accounts a
join junction_ac j on a.account_id = j.account_id
join customers c on c.customer_id = j.customer_id
set balance = (balance + 199.99)
WHERE c.firstname = 'Amanda' and c.lastname = 'Smith' and a.account_id = 900003;

# Change Amanda Smith's last name to "Lastname"
UPDATE customers set lastname = 'Lastname'
WHERE firstname = 'Amanda';
#check update
SELECT * FROM customers
WHERE lastname LIKE 'Lastname';
