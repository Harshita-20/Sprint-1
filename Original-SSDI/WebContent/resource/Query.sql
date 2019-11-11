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


CREATE TABLE AppointmentDetails (ID INT auto_increment unique key,
					PatientName VARCHAR(30) ,
					Specialist VARCHAR(30) ,
                    Appointment_Date DATE,
					Appointment_Time TIME ,
                    Problem_Description VARCHAR(500) ,
                    Comments VARCHAR(1000) );
Alter table AppointmentDetails ADD column DoctorName varchar(50) after PatientName;

Select * from AppointmentDetails;

SELECT FIRSTNAME,EMAIL,GENDER FROM users where role='patient';

TRUNCATE table AppointmentDetails

CREATE TABLE DoctorDetails (ID INT auto_increment unique key,
					DoctorName VARCHAR(30) ,
					Specialisation VARCHAR(30) ,
                    Email  VARCHAR(30),
                    ModifyDate DATE,
					FROMTIME TIME ,
                    TOTIME TIME );
                    
Insert into DoctorDetails values (1, "Andrew Roy", "Dental", "andrewr@gmail.com", "2019-11-24","10:00","17:00");
Insert into DoctorDetails values (2, "Jack Gran", "General Physician", "jackg@gmail.com", "2019-12-12","12:00","16:00");
Insert into DoctorDetails values (3, "Dale Martis", "Cardiologist", "dalem@gmail.com", "2019-11-18","10:00","17:00");
Insert into DoctorDetails values (4, "Bella Weasley", "Neuro Surgeon", "bellaw@gmail.com", "2019-12-28","14:00","17:00");
Insert into DoctorDetails values (5, "Harry Shaw", "Dental", "harrys@gmail.com", "2019-11-22","13:00","17:00");

select * from DoctorDetails;                  
DROP table DoctorDetails;              
                    
UPDATE DoctorDetails SET  FROMTIME="15:00", TOTIME="18:00" WHERE EMAIL='jackg@gmail.com'   ; 


Select Concat(slot_fromtime,'-', slot_totime) As TimeSlot from Slot
where date='2019-11-08' AND doctor_name="Andrew Roy";

           
