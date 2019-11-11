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

import com.login.controller.LoginServlet;
 
public class LoginServletTest {
 
    @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
 
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testadmin() throws IOException, ServletException {
 
        when(request.getParameter("username")).thenReturn("HMSadmin@gmail.com");
        when(request.getParameter("password")).thenReturn("abde103");
 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 
        LoginServlet myServlet =new LoginServlet();
        myServlet.doGet(request, response);

 
    }
    @Test
    public void testdoctor() throws IOException, ServletException {
 
        when(request.getParameter("username")).thenReturn("harrys@gmail.com");
        when(request.getParameter("password")).thenReturn("abty123");
 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 
        LoginServlet myServlet =new LoginServlet();
        myServlet.doGet(request, response);


 
    }
    @Test
    public void testincorrect() throws IOException, ServletException {
 
        when(request.getParameter("username")).thenReturn("hays@gmail.com");
        when(request.getParameter("password")).thenReturn("abty123");
 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 
        LoginServlet myServlet =new LoginServlet();
        myServlet.doGet(request, response);
       

 
    }


 }
