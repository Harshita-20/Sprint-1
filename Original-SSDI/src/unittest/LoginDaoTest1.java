package unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.login.bean.LoginBean;
import com.login.bean.RegisterBean;
import com.login.dao.LoginDao;
import com.login.dao.RegisterDao;
import com.login.util.ConnectionUtility;
import com.login.util.ConnectionData;
import com.login.util.IConnectionData;

@RunWith(MockitoJUnitRunner.class)
public class LoginDaoTest1 {

    @InjectMocks
    private LoginDao Dao;

    @Mock
    private PreparedStatement mockPreparedStmnt;
    
    @Mock
    private ResultSet result_set;
    
    private LoginBean LB;
    
    
    
 

    @Before
    public void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        createTestObject();
        IConnectionData connection = IConnectionData.getInstance("Test") ;
        Dao = new LoginDao(connection);

    }

    private void createTestObject() {
    	 LB = new LoginBean(); 
    	 LB.setUserName("HMSadmin@gmail.com");
    	 LB.setPassword("abde123");
		
	}

	@After
    public void tearDown() {
    }
 

        @Test
        public void createValidUserA() throws SQLException {
        	Dao.authenticateUser(LB);
       
        	         

    		String sql= "Select EMAIL, PASSWORD, ROLE from users";

    		when(result_set.first()).thenReturn(true);
    		when(result_set.getString(1)).thenReturn(LB.getUserName());
    		when(result_set.getString(2)).thenReturn(LB.getPassword());
    		when(result_set.getString(3)).thenReturn("admin");
    		when(mockPreparedStmnt.executeQuery(sql)).thenReturn(result_set);	

    		
    		
    		
    		assertEquals("HMSadmin@gmail.com", result_set.getString(1));
    		assertEquals("abde123", result_set.getString(2));
    		assertEquals("admin", result_set.getString(3));
    		
    	
        }
        
}
