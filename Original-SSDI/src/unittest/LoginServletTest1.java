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

import com.login.bean.LoginBean;
import com.login.bean.RegisterBean;
import com.login.controller.LoginServlet;
import com.login.controller.RegisterServlet;
import com.login.dao.LoginDao;
import com.login.dao.RegisterDao;
import com.login.util.IConnectionData;

public class LoginServletTest1 {
 
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
    
    @Mock
    LoginDao Dao;
    
    @Mock
    LoginServlet servlet;
    
    
    private LoginBean LB;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        createTestObject();

       
    }

private void createTestObject() {
	  when(request.getParameter("username")).thenReturn("HMSadmin@gmail.com");
	  when(request.getParameter("password")).thenReturn("abde123");
		
	}



	 @Test
	 public void test() throws Exception {



			LoginBean LB = new LoginBean();
			
			LB.setUserName(request.getParameter("username"));
			LB.setPassword(request.getParameter("password"));

		
			
			assertEquals(request.getParameter("username"),LB.getUserName() );
			assertEquals(request.getParameter("password"),LB.getPassword() );
		}
	 
	   @Test
	    public void testDaoCalling() throws IOException, ServletException {
		   
		 
		   
		   IConnectionData connection = IConnectionData.getInstance("Test") ;
		   LoginDao loginDao = new LoginDao(connection);
			
		LoginBean LB = new LoginBean();
			
	        loginDao.authenticateUser(LB);
	        
	       

	   
	        

	    }
	}