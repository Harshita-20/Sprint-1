package unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.login.bean.BookAppointmentBean;
import com.login.bean.RegisterBean;
import com.login.controller.BookAppointmentServlet;
import com.login.controller.RegisterServlet;
import com.login.dao.AdminSlotDao;
import com.login.dao.BookAppointmentDao;
import com.login.dao.RegisterDao;
import com.login.util.DateConvert;
import com.login.util.IConnectionData;
 
public class BookAppointmentServletTest {
 
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
    
    @Mock
    BookAppointmentDao Dao;
    
    @Mock
    BookAppointmentServlet servlet;
    
    
    private BookAppointmentBean BAB;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        createTestObject();

       
    }
        
    private void createTestObject() throws ParseException {

    
		
		String dateInString = "11/22/2019";
	
		String time = "10:00 AM";
		
		  when(request.getParameter("dcsource")).thenReturn("Andrew Roy");
          when(request.getParameter("doctorssource")).thenReturn("Dental");
          when(request.getParameter("Appointment_Date")).thenReturn(dateInString);
          when(request.getParameter("Appointment_Time")).thenReturn(time);
          when(request.getParameter("Problem_Description")).thenReturn("TESTPD");
          when(request.getParameter("Comments")).thenReturn("TESTComments");
        
          

			
			
			
		
    }
          
        
  		
  	
	@Test
    public void testpositive() throws IOException, ServletException, ParseException {
		String dateInString = "11/22/2019";
		
		String time = "10:00 AM";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);

		LocalDate date = LocalDate.parse(dateInString, formatter);
		DateConvert dateConvert = new DateConvert();
		java.util.Date AppointmentDate = dateConvert.convertToDateViaInstant(date);
		
		SimpleDateFormat formatter11 = new SimpleDateFormat("hh:mm");


			java.util.Date d = formatter11.parse(dateInString);

			java.sql.Time sqlTime = new java.sql.Time(d.getTime());

		BookAppointmentBean BAB = new BookAppointmentBean();

		BAB.setDoctorName(request.getParameter("dcsource"));
		BAB.setAppointment_Date(AppointmentDate);
		BAB.setAppointment_Time(sqlTime);
		BAB.setSpecialist(request.getParameter("doctorssource"));
		BAB.setProblem_Description(request.getParameter("Problem_Description"));
		BAB.setComments(request.getParameter("Comments"));

		
		assertEquals(request.getParameter("dcsource"),	BAB.getDoctorName() );
		assertEquals(request.getParameter("Appointment_Date"),BAB.getAppointment_Date() );
		assertEquals(request.getParameter("Appointment_Time"),BAB.getAppointment_Time() );
		assertEquals(request.getParameter("doctorssource"),BAB.getSpecialist() );
		assertEquals(request.getParameter("Problem_Description"),BAB.getProblem_Description());
		assertEquals(request.getParameter("Comments"),BAB.getComments());
		
		
	

		
		
		

      
        
    	
 
    }
   @Test
    public void testDaoCalling1() throws IOException, ServletException {
	   

	   
	   IConnectionData connection = IConnectionData.getInstance("Test") ;
	BookAppointmentDao bookAppointmentDao = new BookAppointmentDao(connection);
		
		BookAppointmentBean BAB = new BookAppointmentBean();
		
	 bookAppointmentDao.bookAppointment(BAB);
		
       
        

    }

   @Test
   public void testDaoCalling2() throws IOException, ServletException {
	   

	   
	   IConnectionData connection = IConnectionData.getInstance("Test") ;
	
		BookAppointmentBean BAB = new BookAppointmentBean();

	AdminSlotDao adminSlotDao = new AdminSlotDao(connection);
		adminSlotDao.updateSlot(BAB);
      
       

   }

}
