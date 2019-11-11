package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import com.login.bean.BookAppointmentBean;
import com.login.util.DBConnection;

public class AdminSlotDao {

	public String updateSlot(BookAppointmentBean bookAppointmentBean)
	 {
		
	 String doctorName = bookAppointmentBean.getDoctorName();
	 Date Appointment_Date= bookAppointmentBean.getAppointment_Date();
	 Time SlotTime= bookAppointmentBean.getAppointment_Time();
	   
	 System.out.println("In Admin Slot DAO:");
	 System.out.println(doctorName);
	 System.out.println(Appointment_Date);
	 System.out.println(SlotTime);
	 	 
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 
	 
	     java.sql.Date sqlDate = new java.sql.Date(Appointment_Date.getTime());
	     System.out.println("Time in java.sql.Date is : " + sqlDate);
	          
	 
	 try
	 { 
	 con = DBConnection.createConnection();
	 String query = "Delete from slot where doctor_name =? and date =? and slot_fromtime=?";
	 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 preparedStatement.setString(1, doctorName);
	 preparedStatement.setDate(2, sqlDate);
	 preparedStatement.setTime(3, SlotTime);
	 int i= preparedStatement.executeUpdate();
	 System.out.println(i);
	 
	 if (i!=0) {
		 return "Success"; 
	 }  	
	 }
	 
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return "Please check the details you have entered and Try Again !!";
 }
}
	
	

	
