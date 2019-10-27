package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.bean.BookAppointmentBean;
import com.login.bean.RegisterBean;
import com.login.dao.BookAppointmentDao;
import com.login.dao.RegisterDao;

public class BookAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookAppointmentServlet() {
        super();
        System.out.println("In Booking Servlet");
      
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String speciality = request.getParameter("speciality");
		 String Appointment_Date= request.getParameter("Appointment_Date");
		 String Appointment_Time = request.getParameter("Appointment_Time");
		 String Problem_Description = request.getParameter("Problem_Description");
		 String Comments = request.getParameter("Comments");
		
		 System.out.println(speciality);
		 System.out.println(Appointment_Date);
		 System.out.println(Appointment_Time);
		 System.out.println(Problem_Description);
		 System.out.println(Comments);

		 BookAppointmentBean bookAppointmentBean = new BookAppointmentBean();
		 
		// bookAppointmentBean.setAppointment_Date(Appointment_Date);
		// bookAppointmentBean.setAppointment_Time(Appointment_Time);
		 bookAppointmentBean.setSpecialist(speciality);
		 bookAppointmentBean.setProblem_Description(Problem_Description);
		 bookAppointmentBean.setComments(Comments);
	 try {
			bookAppointmentBean.setAppointment_Date(new SimpleDateFormat("mm/dd/yyyy").parse("Appointment_Date"));
			bookAppointmentBean.setAppointment_Time((Time) new SimpleDateFormat("hh:mm").parse("Appointment_Time"));
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 BookAppointmentDao bookAppointmentDao = new BookAppointmentDao();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userBookedStatus = bookAppointmentDao.bookAppointment(bookAppointmentBean);
		 
		 System.out.println(userBookedStatus);
		 
		 /**** Preparing The Output Response ****/
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(userBookedStatus);
		 
}

}


