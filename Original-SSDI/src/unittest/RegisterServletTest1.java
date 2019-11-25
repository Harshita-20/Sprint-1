package unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.login.bean.RegisterBean;
import com.login.controller.RegisterServlet;
import com.login.dao.RegisterDao;
import com.login.util.IConnectionData;

 
public class RegisterServletTest1 {
 
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
    
    @Mock
    RegisterDao Dao;
    
    @Mock
    RegisterServlet servlet;
    
    
    private RegisterBean RB;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        createTestObject();

       
    }
        
    private void createTestObject() {

    	  when(request.getParameter("firstName")).thenReturn("Swapnil");
          when(request.getParameter("lastName")).thenReturn("Samant");
          when(request.getParameter("password")).thenReturn("Marsplanet1.");
          when(request.getParameter("email")).thenReturn("harshums@gmail.com");
          when(request.getParameter("contact")).thenReturn("1199778844");
          when(request.getParameter("gender")).thenReturn("F");
          when(request.getParameter("address1")).thenReturn("9552 UTN");
          when(request.getParameter("address2")).thenReturn("Apartment L");
          when(request.getParameter("city")).thenReturn("Charlotte");
          when(request.getParameter("state")).thenReturn("North Carolina");
          when(request.getParameter("zipcode")).thenReturn("28262");
	}

	@Test
    public void testpositive() throws IOException, ServletException {
 
      
		RegisterBean RB = new RegisterBean();
		
		RB.setFirstName(request.getParameter("firstName"));
		RB.setLastName(request.getParameter("lastName"));
		RB.setEmail(request.getParameter("email"));
		RB.setContact(request.getParameter("contact"));
		RB.setPassword(request.getParameter("password"));
		RB.setGender(request.getParameter("gender"));
		RB.setAddress1(request.getParameter("address1"));
		RB.setAddress2(request.getParameter("address1"));
		RB.setCity(request.getParameter("city"));
		RB.setState(request.getParameter("state"));
		RB.setZipcode(request.getParameter("zipcode"));
	
		
		assertEquals(request.getParameter("firstName"),RB.getFirstName());
		assertEquals(request.getParameter("lastName"),RB.getLastName());
		assertEquals(request.getParameter("password"),RB.getPassword());
		assertEquals(request.getParameter("email"),RB.getEmail());
		assertEquals(request.getParameter("contact"),RB.getContact());
		assertEquals(request.getParameter("gender"),RB.getGender());
		assertEquals(request.getParameter("address1"),RB.getAddress1());
		assertEquals(request.getParameter("address2"),RB.getAddress2());
		assertEquals(request.getParameter("city"),RB.getCity());
		assertEquals(request.getParameter("state"),RB.getState());
		assertEquals(request.getParameter("zipcode"),RB.getZipcode());
    }
   @Test
    public void testDaoCalling() throws IOException, ServletException {
	   

	   
	   IConnectionData connection = IConnectionData.getInstance("Test") ;
		RegisterDao registerDao = new RegisterDao(connection);
		
		RegisterBean RB = new RegisterBean();
		
        registerDao.registerUser(RB);
    }
 
   }
   	

