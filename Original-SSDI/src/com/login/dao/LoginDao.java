package com.login.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import com.login.bean.LoginBean;
import com.login.util.DBConnection;
 
public class LoginDao {
 
public String authenticateUser(LoginBean loginBean)
{
	
	 System.out.println(" In DAO class");	
 String userName = loginBean.getUserName();
 String password = loginBean.getPassword();
 
 System.out.println(userName);
 System.out.println(password);
 
 Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
 String userNameDB = "";
 String passwordDB = "";
 String roleDB = "";

 try
 {
 con = DBConnection.createConnection();
 statement = con.createStatement();
 resultSet = statement.executeQuery("select email,password,role from users where email='" +userName+ "'");
 
 while(resultSet.next())
 {
 
 userNameDB = resultSet.getString("email");
 passwordDB = resultSet.getString("password");
 roleDB = resultSet.getString("role");
 System.out.println(roleDB);
 System.out.println(userNameDB);
 System.out.println(passwordDB);
 if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
 return "Admin_Role";
 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Doctor"))
 return "Doctor_Role";
 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("patient"))
 return "Patient_Role";
 }
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 return "Invalid user credentials";
}

public String retrieveFirstName(LoginBean loginBean) {
	
	String userName = loginBean.getUserName();
	 
	 Connection con = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 
	 String firstNameDB = "";
	 try
	 {
	 con = DBConnection.createConnection();
	 statement = con.createStatement();
	 resultSet = statement.executeQuery("select firstname from users where email='" +userName+ "'");

	 while(resultSet.next())
	 {
	 
	 firstNameDB = resultSet.getString("firstname");
	
	 }
	return firstNameDB;
}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return "UserName Not Found";
	}

}