DROP database if exists myOdb;
CREATE DATABASE myOdb;



use myOdb;

DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS junction_ac;


# Build Tables

CREATE table address
(
	address_id 		varchar(200),
	address			varchar(200),
	city			varchar(200),
	state			char(2),
	zip				int not null,
	constraint Primary Key (address_id)
	
);

CREATE table customers
(
	customer_id		varchar (200),
	firstname		varchar(200),
	middlename		varchar(20),
	lastname		varchar(200),
	
	constraint Primary Key (customer_id)
	
	
);

CREATE TABLE accounts
(
	account_num int auto_increment,
	account_id varchar(200),
	balance decimal(10,2),
	constraint primary key (account_num),
	index (account_id)
	
);
CREATE table junction_ac
(
	email		varchar(200) not null unique,	
	junction_id int auto_increment,
	account_id varchar(200) ,
	customer_id varchar(200),
	address_id	varchar(200) ,
	
	
	constraint primary key (junction_id),
	constraint customer_fk foreign key (customer_id) references customers (customer_id),
	constraint accounts_fk foreign key (account_id) references accounts (account_id),
	constraint address_fk foreign key (address_id)	references address (address_id)
	
);


# Populate table with data

INSERT INTO address (address_id, address, city, state, zip) VALUES ("rodney@rev.netTX", "1 Way st.", "Tampa", "FL", 12345);
INSERT INTO address (address, city, state, zip) VALUES ("144 Bleeker st.", "Austin", "TX", 55447);
INSERT INTO address (address, city, state, zip) VALUES ("86 fuzzy lane", "Dallas", "TX", 55445);
INSERT INTO address (address, city, state, zip) VALUES ("212 1st ave", "Albany", "NY", 12210);
INSERT INTO address (address, city, state, zip) VALUES ("74 Daytona Ave.", "Albany", "NY", 12210);

INSERT INTO customers (customer_id, firstname, middlename, lastname) VALUES ("rodney@rev.netTX", "Jason", "", "Smith");
INSERT INTO customers (firstname, middlename, lastname) VALUES ("Amanda", "", "Smith");
INSERT INTO customers (firstname, middlename, lastname) VALUES ("John", "", "Cross");
INSERT INTO customers (firstname, middlename, lastname) VALUES ("Marty", "Andrew", "Gras");
INSERT INTO customers (firstname, middlename, lastname) VALUES ("Jason", "A.", "Lastname");

INSERT INTO accounts (account_id, balance) VALUES ("rodney@rev.netTX", 0.00);
INSERT INTO accounts (balance) VALUES (2780.25);
INSERT INTO accounts (balance) VALUES (150);
INSERT INTO accounts (balance) VALUES (13.33);
INSERT INTO accounts (balance) VALUES (100000.01); 
INSERT INTO accounts (balance) VALUES (12345.67);
INSERT INTO accounts (balance) VALUES (1345.67);

INSERT INTO junction_ac (email, account_id, customer_id, address_id) VALUES ("test", "rodney@rev.netTX", "rodney@rev.netTX", "rodney@rev.netTX");
INSERT INTO junction_ac (email) VALUES ("test");
INSERT INTO junction_ac (email) VALUES ("test");
INSERT INTO junction_ac (email) VALUES ("test");
INSERT INTO junction_ac (email) VALUES ("test");
INSERT INTO junction_ac (email) VALUES ("test");
INSERT INTO junction_ac (email) VALUES ("test");


# Db test
SELECT c.firstname, c.middlename, c.lastname, ad.address, ad.city, ad.state, a.account_id, a.balance
FROM customers c
JOIN junction_ac ac ON c.customer_id = ac.customer_id
JOIN accounts a ON ac.account_id = a.account_id
JOIN address ad ON ac.customer_id = ad.address_id
ORDER BY a.balance DESC;

# Get a list of all customers with the last name "Smith".
SELECT * FROM customers;
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
