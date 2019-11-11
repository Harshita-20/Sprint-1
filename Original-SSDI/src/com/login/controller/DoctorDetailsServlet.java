package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.bean.BookAppointmentBean;
import com.login.bean.DoctorDetailsBean;
import com.login.dao.BookAppointmentDao;
import com.login.dao.DoctorDetailsDao;
import com.login.util.DateConvert;


public class DoctorDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoctorDetailsServlet() {
        super();
   }

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Object obj = request.getSession().getAttribute("fName");
    System.out.println("Displaying value in Doctor object"+obj);
	 
	 String patientName= (String)obj;
    
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.US);
	 
     String Change_Date= request.getParameter("Change_Date");
	 String Time_From = request.getParameter("Time_From");
	 System.out.println(Time_From);
	 
     String Time_To = request.getParameter("Time_To");
     System.out.println(Time_To); 
	 
     LocalDateTime datetime = LocalDateTime.parse(Time_From,formatter);
     LocalDateTime datetime1 = LocalDateTime.parse(Time_To,formatter);
	 
     datetime=datetime.minusHours(5);
     datetime1=datetime1.minusHours(5);
    
     String newFromTime=datetime.format(formatter);
     
     String newToTime=datetime1.format(formatter);
     
     System.out.println("New From Time"+newFromTime); 
     System.out.println("New To Time"+newToTime); 
     
	 LocalDate date = LocalDate.parse(Change_Date,formatter);
	 
	 LocalTime FromTime = LocalTime.parse(newFromTime,formatter);
	 
	 LocalTime ToTime = LocalTime.parse(newToTime,formatter);
	 		 
	 Time From_Time = java.sql.Time.valueOf(FromTime);
	 
	 Time To_Time = java.sql.Time.valueOf(ToTime);
	 
	 System.out.println("Converted date value "+date);
	 
	 System.out.println("Extracted From time "+From_Time);
	 
	 System.out.println("Extracted To time "+To_Time);
	 
	 DateConvert dateConvert = new DateConvert();
	 java.util.Date ChangeDate=dateConvert.convertToDateViaInstant(date);
	 
	 System.out.println(ChangeDate);
	 System.out.println(From_Time);
	 System.out.println(To_Time);

	 System.out.println("In Booking servlet.. About to set values");
	 
	 
	 LocalTime Frotime =From_Time.toLocalTime();
	 System.out.println(Frotime);
	 	 
	 DoctorDetailsBean doctorDetailsBean = new DoctorDetailsBean();
	 
	 doctorDetailsBean.setFROMTIME(From_Time);
	 doctorDetailsBean.setTOTIME(To_Time);
	 doctorDetailsBean.setModifyDate(ChangeDate);
	
	 DoctorDetailsDao doctorDetailsDao = new DoctorDetailsDao();
	 
	 //The core Logic the Registration application is present here. We are going to insert user data in to the database.
	 String updateStatus = doctorDetailsDao.updateAvailability(doctorDetailsBean);

 	 System.out.println(updateStatus);

    /**** Preparing The Output Response ****/
	response.setContentType("text/html");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	out.write(updateStatus);
	
	}

}
