 
package com.login.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.*;

import com.google.gson.Gson;
import com.login.bean.LoginBean;
import com.login.dao.LoginDao;

public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public LoginServlet() {
	 
	super();
	 System.out.println(" In Constructor");	
}
 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		 
	   	String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    
	    System.out.println(username);	
	    System.out.println(password);  
	    
        LoginBean loginBean = new LoginBean();
       
       loginBean.setUserName(username);
       loginBean.setPassword(password);
        
       LoginDao loginDao = new LoginDao();
        
        System.out.println(" About to call DAO class");	
        
       String userValidate = loginDao.authenticateUser(loginBean);
        System.out.println(userValidate);
        
        String firstName = loginDao.retrieveFirstName(loginBean);
        System.out.println(firstName);
        request.setAttribute("firstName", firstName);
        
        LoginBean loginBean1= new LoginBean();
        loginBean1.setFirstName(firstName);
        loginBean1.setMessage(userValidate);
        
        HttpSession session = request.getSession();
        session.setAttribute("fName", firstName);
           
        //String userValidate1 = new Gson().toJson(userValidate);
        
             /**** Preparing The Output Response ****/
       //response.setContentType("text/html");
      // response.setCharacterEncoding("UTF-8");
       //PrintWriter out = response.getWriter();
      // out.write(userValidate);
       //out.write(firstName);
       
        String json = new Gson().toJson(loginBean1);
		response.setContentType("application/json");
		response.getWriter().write(json);
}
}