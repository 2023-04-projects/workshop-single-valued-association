create table customer(
id int auto_increment primary key,
name varchar(100),
phone_number long,
cust_id int,
FOREIGN KEY (cust_id) REFERENCES customerorder(id),
);
ALTER TABLE customer ADD COLUMN biryani_id int;
ALTER TABLE customer ADD CONSTRAINT  FOREIGN KEY (biryani_id) REFERENCES biryani(id);


create table customerorder(
id int auto_increment primary key,
name varchar(100),
price double(30,2)
);



create table biryani(
id int auto_increment primary key,
biryani_type varchar(100),
location varchar(4)
);
