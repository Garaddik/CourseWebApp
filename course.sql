--create database
CREATE DATABASE COURSEDB;
--select database
USE COURSEDB;
--Create Course Table
CREATE TABLE COURSE(code int,title varchar(255),description varchar(255),credits int,university varchar(255),PRIMARY KEY (id));
--Create Student
CREATE TABLE STUDENT(id int,firstName varchar(255),lastName varchar(255),course_code int,PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES COURSE(code));
--Create En
CREATE TABLE ENROLLMENT(enrollmentId int,course_code int,studentId int,PRIMARY KEY (enrollmentId),FOREIGN KEY (course_code) REFERENCES COURSE(code),FOREIGN KEY (studentId) REFERENCES STUDENT(id));



mysqldump -u admin -p COURSEDB > coursefile.sql

-- export database
sudo mysqldump --databases --user=root COURSEDB > coursedb.sql


LOAD DATA INFILE '/Downloads/json.csv' INTO TABLE COURSE FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;

mysql -u admin -p