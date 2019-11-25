package unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.login.bean.RegisterBean;
import com.login.controller.RegisterServlet;
import com.login.dao.RegisterDao;
import com.login.util.IConnectionData;



@RunWith(MockitoJUnitRunner.class)
public class RegisterDaoTest1 {

    @InjectMocks
    private RegisterDao Dao;
    
    @Mock
    private PreparedStatement mockPreparedStmnt;
    
    @Mock
    private ResultSet result_set;
    
    private RegisterBean RB;
    
 
    @Before
    public void setUp() throws Exception {
    
        MockitoAnnotations.initMocks(this);
        createTestObject();
        IConnectionData connection = IConnectionData.getInstance("Test") ;
        Dao = new RegisterDao(connection);
                
    }    
    
    private void createTestObject() {
    	RB = new RegisterBean();
    	RB.setFirstName("TestfirstName");
    	RB.setLastName("TestlastName");
    	RB.setPassword("1234567");
    	RB.setEmail("abc1@gmail.com");
    	RB.setContact("987654321");
    	RB.setGender("Female");
    	RB.setAddress1("9551, University Terrace Drive");
		RB.setAddress2("Apartment K");
		RB.setCity("Charlotte");
		RB.setState("North Carolina");
		RB.setZipcode("28262");
    	 
    }
 
    @Test
    public void testpositive() throws IOException, ServletException, SQLException {
    	Dao.registerUser(RB);
    	
    	//String sql="Delete from users where role is patient";
		String sql= "Select * from users";
		

		when(result_set.first()).thenReturn(true);
		when(result_set.getString(1)).thenReturn(RB.getFirstName());
		when(result_set.getString(2)).thenReturn(RB.getLastName());
		when(result_set.getString(3)).thenReturn(RB.getPassword());
		when(result_set.getString(4)).thenReturn(RB.getEmail());
		when(result_set.getString(5)).thenReturn(RB.getContact());
		when(result_set.getString(6)).thenReturn(RB.getGender());
		when(result_set.getString(7)).thenReturn(RB.getAddress1());
		when(result_set.getString(8)).thenReturn(RB.getAddress2());
		when(result_set.getString(9)).thenReturn(RB.getCity());
		when(result_set.getString(10)).thenReturn(RB.getState());
		when(result_set.getString(11)).thenReturn(RB.getZipcode());
		when(mockPreparedStmnt.executeQuery(sql)).thenReturn(result_set);	
 
    	
    	
		assertEquals("TestfirstName", result_set.getString(1));
		assertEquals("TestlastName", result_set.getString(2));
		assertEquals("1234567", result_set.getString(3));
		assertEquals("abc2@gmail.com", result_set.getString(4));
		assertEquals("987654321", result_set.getString(5));
		assertEquals("Female", result_set.getString(6));
		assertEquals("9551, University Terrace Drive", result_set.getString(7));
		assertEquals("Apartment K", result_set.getString(8));
		assertEquals("Charlotte", result_set.getString(9));
		assertEquals("North Carolina", result_set.getString(10));
		assertEquals("28262", result_set.getString(11));
	
          
    }

	

}
