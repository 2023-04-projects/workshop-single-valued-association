use 2024_batch;
create table doctor(doctorId int auto_increment primary key,doctorName varchar(100),specialty varchar(100),phonenumber Long);
create table patient(patientId int auto_increment primary key,patientName varchar(100),phoneNumber Long,doctorId int,FOREIGN KEY(doctorId) REFERENCES doctor(doctorId));
create table appointment(appointId INT AUTO_INCREMENT PRIMARY KEY,appointDate DATE,patientId int,FOREIGN KEY(patientId) REFERENCES patient(patientId));
ALTER TABLE patient ADD COLUMN appointId int;
