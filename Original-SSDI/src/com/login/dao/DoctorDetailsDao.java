package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.login.bean.BookAppointmentBean;
import com.login.bean.DoctorDetailsBean;
import com.login.bean.LoginBean;
import com.login.util.DBConnection;

public class DoctorDetailsDao {

	 public String updateAvailability(DoctorDetailsBean doctorDetailsBean)
	 {
		 
     String Email=doctorDetailsBean.getEmail();
     Date ModifyDate=doctorDetailsBean.getModifyDate();
     Time FromTime=doctorDetailsBean.getFROMTIME();
           
     
     
	 Time ToTime=doctorDetailsBean.getTOTIME();
	
	  //LoginBean loginBean= new LoginBean();
	  //String firstName=loginBean.getFirstName();

	 Connection con = null;
	 PreparedStatement preparedStatement = null;

    java.sql.Date sqlDate = new java.sql.Date(ModifyDate.getTime());
    System.out.println("Time in java.sql.FromDate is : " + sqlDate);
    
    System.out.println("In Doctor DAO Class");
    
   try
	 { 
	 con = DBConnection.createConnection();
	 String query = ("UPDATE DoctorDetails SET FROMTIME = ?, TOTIME = ? WHERE ModifyDate = ?");
	 	
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setTime(1,FromTime);
	 preparedStatement.setTime(2,ToTime);
	 preparedStatement.setDate(3,sqlDate);
	 
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

public static  List<DoctorDetailsBean> getDoctorListFromDb() {	
		 
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
	   
		 DoctorDetailsBean doctorDetailsBean = null;
			List<DoctorDetailsBean> getDoctorList = new ArrayList<DoctorDetailsBean>();
			try {
				
				 con = DBConnection.createConnection();
				 statement = con.createStatement();
				 
				 //PreparedStatement preparedStatement = null;
				 con = DBConnection.createConnection();
				 System.out.println("Before calling sql");
				 
                 resultSet = statement.executeQuery("SELECT ID,DoctorName,Specialisation,Email,ModifyDate,FROMTIME,TOTIME FROM DoctorDetails");
				 System.out.println("After calling"+resultSet);
				 while(resultSet.next())
				 {
				
					 doctorDetailsBean = new DoctorDetailsBean();
					 doctorDetailsBean.setDoctorName(resultSet.getString("DoctorName"));
					 doctorDetailsBean.setSpecialisation(resultSet.getString("Specialisation"));
					 doctorDetailsBean.setEmail(resultSet.getString("Email"));
					 doctorDetailsBean.setModifyDate(resultSet.getDate("ModifyDate"));
					 doctorDetailsBean.setFROMTIME(resultSet.getTime("FROMTIME"));
					 doctorDetailsBean.setTOTIME(resultSet.getTime("TOTIME"));
				
					 getDoctorList.add(doctorDetailsBean);
				System.out.println(getDoctorList);
				}
			} catch (SQLException sqlExObj) {
				sqlExObj.printStackTrace();
			} finally {
				//disconnectDb();
			}
			return getDoctorList;
		}
	 
}
