package unittest;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.login.controller.RegisterServlet;
 
public class RegisterServletTest {
 
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
 
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testpositive() throws IOException, ServletException {
 
        when(request.getParameter("firstName")).thenReturn("TestFN");
        when(request.getParameter("lastName")).thenReturn("TestLN");
        when(request.getParameter("password")).thenReturn("Marsplanet1.");
        //when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("email")).thenReturn("harshu@gmail.com");
        when(request.getParameter("contact")).thenReturn("1199778844");
        when(request.getParameter("gender")).thenReturn("F");
        when(request.getParameter("address")).thenReturn("UTN");
      
 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 
        RegisterServlet myServlet =new RegisterServlet();
        myServlet.doGet(request, response);

 
    }

 }
