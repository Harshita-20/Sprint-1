package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.bean.RegisterBean;
import com.login.dao.RegisterDao;
 

public class RegisterServlet extends HttpServlet {
 
 public RegisterServlet() {
	 
	 System.out.println(" In Register Servlet");
 }
 
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //Copying all the input parameters in to local variables
	 
	 System.out.println(" In Do Get Servlet");
	 
 String firstName = request.getParameter("firstName");
 String lastName = request.getParameter("lastName");
 String email = request.getParameter("email");
 String contact = request.getParameter("contact");
 String password = request.getParameter("password");
 String gender = request.getParameter("gender");
 String address = request.getParameter("address");
 
 System.out.println(email);
 System.out.println(firstName);
 System.out.println(lastName);
 

 RegisterBean registerBean = new RegisterBean();
 //Using Java Beans - An easiest way to play with group of related data
 registerBean.setFirstName(firstName);
 registerBean.setLastName(lastName);
 registerBean.setEmail(email);
 registerBean.setContact(contact);
 registerBean.setPassword(password);  
 registerBean.setGender(gender);
 registerBean.setAddress(address);
 
 RegisterDao registerDao = new RegisterDao();
 
 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
 String userRegistered = registerDao.registerUser(registerBean);
 
 System.out.println(userRegistered);
 
 /**** Preparing The Output Response ****/
response.setContentType("text/html");
response.setCharacterEncoding("UTF-8");
PrintWriter out = response.getWriter();
out.write(userRegistered);
 
 }
}