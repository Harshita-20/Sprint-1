package com.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.login.bean.BookAppointmentBean;
import com.login.util.DBConnection;

public class PatientDetailsDao {
	
 public static  List<BookAppointmentBean> getPatientListFromDb() {	
		 
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
	   
		 BookAppointmentBean bookApppointmentBean = null;
			List<BookAppointmentBean> getPatientList = new ArrayList<BookAppointmentBean>();
			try {
				
				 con = DBConnection.createConnection();
				 statement = con.createStatement();
				 
				 //PreparedStatement preparedStatement = null;
				 con = DBConnection.createConnection();
				 System.out.println("Before calling sql");
				 
                 resultSet = statement.executeQuery("SELECT ID,PatientName,Specialist,Appointment_Date,Appointment_Time,Problem_Description,Comments FROM AppointmentDetails");
				 System.out.println("After calling"+resultSet);
				 while(resultSet.next())
				 {
				
				bookApppointmentBean = new BookAppointmentBean();
				bookApppointmentBean.setPatientName(resultSet.getString("PatientName"));
				bookApppointmentBean.setSpecialist(resultSet.getString("Specialist"));
				bookApppointmentBean.setAppointment_Date(resultSet.getDate("Appointment_Date"));
				bookApppointmentBean.setAppointment_Time(resultSet.getTime("Appointment_Time"));
				bookApppointmentBean.setProblem_Description(resultSet.getString("Problem_Description"));
				bookApppointmentBean.setComments(resultSet.getString("Comments"));
									 
				getPatientList.add(bookApppointmentBean);
				System.out.println(getPatientList);
				}
			} catch (SQLException sqlExObj) {
				sqlExObj.printStackTrace();
			} finally {
				//disconnectDb();
			}
			return getPatientList;
		} 

}
