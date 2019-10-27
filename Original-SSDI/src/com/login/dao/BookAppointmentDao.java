package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

import com.login.bean.BookAppointmentBean;
import com.login.bean.LoginBean;
import com.login.bean.RegisterBean;
import com.login.util.DBConnection;

public class BookAppointmentDao {
	

	 public String bookAppointment(BookAppointmentBean bookAppointmentBean)
	 {
		 
	 String Specialist =bookAppointmentBean.getSpecialist();
	 Date Appointment_Date=bookAppointmentBean.getAppointment_Date();
	 Time Appointment_Time=bookAppointmentBean.getAppointment_Time();
	 String Problem_Description=bookAppointmentBean.getProblem_Description();
	 String Comments=bookAppointmentBean.getComments();
	 
	 LoginBean loginBean= new LoginBean();
	 
	 String firstName=loginBean.getFirstName();

	 
	 System.out.println(Specialist);
	 System.out.println(Appointment_Date);
	 System.out.println(Appointment_Time);
	 
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 
	 try
	 { 
	 con = DBConnection.createConnection();
	 String query = "insert into AppointmentDetails(id,PatientName,Specialist,Appointment_Date,Appointment_Time,Problem_Description,Comments) values (NULL,?,?,?,?,?,?)"; 
	 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 preparedStatement.setString(1, firstName);
	 preparedStatement.setString(2, Specialist);
	 preparedStatement.setDate(3, (java.sql.Date) Appointment_Date);
	 preparedStatement.setTime(4,Appointment_Time);
	 preparedStatement.setString(5, Problem_Description);
	 preparedStatement.setString(6, Comments);

	 
	 int i= preparedStatement.executeUpdate();
	 
	 if (i!=0)  //Just to ensure data has been inserted into the database
	 return "Success"; 
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "Please check the details you have entered and Try Again !!"; 
	 }
	
	
}
