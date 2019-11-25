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
import com.login.util.ConnectionData;
import com.login.util.ConnectionUtility;
import com.login.util.IConnectionData;

public class DoctorManageTimingsDao {

	private IConnectionData conn_data;
	
	public DoctorManageTimingsDao(IConnectionData conn_data) {
	 this.conn_data = conn_data;
	 }
	
	public String updateSlot(BookAppointmentBean bookAppointmentBean)
	 {
		
	 String email = bookAppointmentBean.getEmail();
	 Date Appointment_Date= bookAppointmentBean.getAppointment_Date();
	 Time SlotTime= bookAppointmentBean.getAppointment_Time();
	   
	 System.out.println("In Doctor Manage Slot DAO:");
	 System.out.println(email);
	 System.out.println(Appointment_Date);
	 System.out.println(SlotTime); 	 
	 Connection con = null;
	 PreparedStatement preparedStatement = null;

	     java.sql.Date sqlDate = new java.sql.Date(Appointment_Date.getTime());
	     System.out.println("Time in java.sql.Date is : " + sqlDate);
	 try
	 { 
		 
	//ConnectionData conn_data = new ConnectionData();
	con= ConnectionUtility.getConnection(conn_data);
	 String query = "Delete from slot where email =? and date =? and slot_fromtime=?";
	 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 preparedStatement.setString(1, email);
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

public List<DoctorDetailsBean> getDoctorListFromDb() {	
		 
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
	   
		 DoctorDetailsBean doctorDetailsBean = null;
			List<DoctorDetailsBean> getDoctorList = new ArrayList<DoctorDetailsBean>();
			try {
				 con= ConnectionUtility.getConnection(conn_data);
				 //con = DBConnection.createConnection();
				 statement = con.createStatement();
				 
				 //PreparedStatement preparedStatement = null;
				 //con = DBConnection.createConnection();
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


public List<DoctorDetailsBean> getupdatedDoctorListFromDb() {	
	 
	 Connection con = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
  
	 DoctorDetailsBean doctorDetailsBean = null;
		List<DoctorDetailsBean> getDoctorList = new ArrayList<DoctorDetailsBean>();
		try {
			con= ConnectionUtility.getConnection(conn_data);
			 //con = DBConnection.createConnection();
			 statement = con.createStatement();
			 
			 //PreparedStatement preparedStatement = null;
			 //con = DBConnection.createConnection();
			 System.out.println("Before calling sql");
			 
            resultSet = statement.executeQuery("SELECT ID,DoctorName,Specialisation,Email,ModifyDate,FROMTIME,TOTIME FROM DoctorDetails where Concat(fromtime,'-', totime) != '10:00:00-17:00:00'");
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
