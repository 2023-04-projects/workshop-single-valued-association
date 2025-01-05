create table college(
clgNo int auto_increment primary key,
name varchar(100)
);

create table student(
id int auto_increment primary key,
name varchar(100),
fee double(30,2),
clgNo int,
FOREIGN KEY (clgNo) REFERENCES college(clgNo)
);

-- one to one 
create table course(
courseId int auto_increment primary key,
courseName varchar(10)
);

ALTER TABLE student ADD COLUMN course_courseId int;
ALTER TABLE student ADD CONSTRAINT  FOREIGN KEY (course_courseId ) REFERENCES course(courseId);