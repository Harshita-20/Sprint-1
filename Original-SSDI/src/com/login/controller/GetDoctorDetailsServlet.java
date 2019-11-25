package com.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import com.google.gson.Gson;
import com.login.bean.DoctorDetailsBean;
import com.login.dao.DoctorManageTimingsDao;
import com.login.dao.LoginDao;
import com.login.util.IConnectionData;

public class GetDoctorDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetDoctorDetailsServlet() {
		super();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONArray arrayObj = null;
		List<DoctorDetailsBean> doctorList = null;
		try {

			System.out.println("In Servlet class");
			
			IConnectionData connection = IConnectionData.getInstance("") ;
			DoctorManageTimingsDao doctorManageTimingsDao =new DoctorManageTimingsDao(connection);

			doctorList = doctorManageTimingsDao.getupdatedDoctorListFromDb();
			if (doctorList != null && doctorList.size() > 0) {
				System.out.println("Total Patient Records Fetch From Db Are= " + doctorList.size());
			} else {
				System.out.println("No Patient Records Are Present In Db");
			}

			arrayObj = new JSONArray(doctorList);
			String jDoctorObj = new Gson().toJson(arrayObj);
			System.out.println(jDoctorObj);

			/***** Preparing The Output Response *****/
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jDoctorObj);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
