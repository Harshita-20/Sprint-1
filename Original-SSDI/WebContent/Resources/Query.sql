DROP DATABASE IF EXISTS HMS;
CREATE DATABASE HMS ;
USE HMS;
drop table users;
CREATE TABLE users(USERID INT auto_increment unique key,
					FIRSTNAME VARCHAR(255) ,
					LASTNAME VARCHAR(255) ,
                    PASSWORD VARCHAR(255) ,
					EMAIL VARCHAR(255) PRIMARY KEY ,
                    CONTACT VARCHAR(45) ,
                    GENDER VARCHAR(15) ,
                    ADDRESS VARCHAR(455),
                    ROLE VARCHAR(255) DEFAULT 'patient');
                    
                 
Insert into users values(1, "Andrew", "Roy", "abcd123", "andrewr@gmail.com", "9874531122", "Male", "Charlotte", "Doctor");
Insert into users values(2, "Dale", "Martis", "abcd789", "dalem@gmail.com", "9835890412", "Female", "Charlotte", "Doctor");
Insert into users values(3, "Bella", "Weasley", "xyz123", "bellaw@gmail.com", "9874531122", "Female", "Charlotte", "Doctor");
Insert into users values(4, "Jack", "Gran", "abxy123", "jackg@gmail.com", "9237645122", "Male", "Charlotte", "Doctor");
Insert into users values(5, "Harry", "Shaw", "abty123", "harrys@gmail.com", "9569176022", "Male", "Charlotte", "Doctor");
Insert into users values(6, "admin", "admin", "abde123", "HMSadmin@gmail.com", "9076483222", "Male", "Charlotte", "Admin");

select * from users;



