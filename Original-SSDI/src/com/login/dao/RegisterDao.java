package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.login.bean.RegisterBean;
import com.login.util.DBConnection;

public class RegisterDao {
	 
	    static ResultSet rsObj = null;
		static Statement stmtObj = null;
		static Connection connObj = null;

public String registerUser(RegisterBean registerBean)
	 {
	 String firstName = registerBean.getFirstName();
	 String lastName = registerBean.getLastName();
	 String email = registerBean.getEmail();
	 String contact = registerBean.getContact();
	 String password = registerBean.getPassword();
	 String gender = registerBean.getGender();
	 String address = registerBean.getAddress();
	 
	 System.out.println(email);
	 System.out.println(firstName);
	 System.out.println(gender);
	 
	 
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 
	 try
	 { 
	 con = DBConnection.createConnection();
	 String query = "insert into users(USERID,FIRSTNAME,LASTNAME,EMAIL,CONTACT,PASSWORD,GENDER,ADDRESS) values (NULL,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
	 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 preparedStatement.setString(1, firstName);
	 preparedStatement.setString(2, lastName);
	 preparedStatement.setString(3, email);
	 preparedStatement.setString(4, contact);
	 preparedStatement.setString(5, password);
	 preparedStatement.setString(6, gender);
	 preparedStatement.setString(7, address);
	 
	 int i= preparedStatement.executeUpdate();
	 
	 if (i!=0)  //Just to ensure data has been inserted into the database
	 return "Success"; 
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "Please check the details you have entered and Try Again !!";  // On failure, send a message from here.
	 }
	  
	}

