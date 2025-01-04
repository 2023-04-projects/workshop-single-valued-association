CREATE TABLE item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10, 2)
);

CREATE TABLE Restaurent (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100),
    item_id INT,
    FOREIGN KEY (item_id) REFERENCES item(id)
);

CREATE TABLE order (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_num INT,
    order_status varchar(4),
);
 
ALTER TABLE restaurent ADD COLUMN order_id int;
ALTER TABLE restaurent ADD CONSTRAINT  FOREIGN KEY (order_id) REFERENCES order_id(id);  