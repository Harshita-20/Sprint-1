
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
import com.login.dao.RegisterDao;
import com.login.util.ConnectionData;
import com.login.util.IConnectionData;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
     
		super();
		System.out.println(" In Constructor");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username);
		System.out.println(password);

		LoginBean loginBean = new LoginBean();

		loginBean.setUserName(username);
		loginBean.setPassword(password);

		IConnectionData connection = IConnectionData.getInstance("") ;
		LoginDao loginDao = new LoginDao(connection);
		

		System.out.println(" About to call DAO class");

		String userValidate = loginDao.authenticateUser(loginBean);
		System.out.println(userValidate);

		String fullName = loginDao.retrieveName(loginBean);
		System.out.println(fullName);
		request.setAttribute("fullName", fullName);

		LoginBean loginBean1 = new LoginBean();
		loginBean1.setFirstName(fullName);
		loginBean1.setMessage(userValidate);

		HttpSession session = request.getSession();
		session.setAttribute("fullName", fullName);

		HttpSession session1 = request.getSession();
		session1.setAttribute("email", username);

		// String userValidate1 = new Gson().toJson(userValidate);

		/**** Preparing The Output Response ****/
		// response.setContentType("text/html");
		// response.setCharacterEncoding("UTF-8");
		// PrintWriter out = response.getWriter();
		// out.write(userValidate);
		// out.write(firstName);

		String json = new Gson().toJson(loginBean1);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
}