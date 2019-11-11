package unittest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;

import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import com.login.bean.LoginBean;
import com.login.dao.LoginDao;

@RunWith(MockitoJUnitRunner.class)
public class LoginDaoTest {

    @Mock
    DataSource mockDataSource;
    @Mock
    Connection mockConn;
    @Mock
    PreparedStatement mockPreparedStmnt;
    @Mock
    ResultSet mockResultSet;

    public LoginDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        when(mockDataSource.getConnection()).thenReturn(mockConn);
        when(mockDataSource.getConnection(anyString(), anyString())).thenReturn(mockConn);
        doNothing().when(mockConn).commit();
        when(mockConn.prepareStatement(anyString(), anyInt())).thenReturn(mockPreparedStmnt);
        doNothing().when(mockPreparedStmnt).setString(anyInt(), anyString());
        when(mockPreparedStmnt.execute()).thenReturn(Boolean.TRUE);
        when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
        
       
    }

    @After
    public void tearDown() {
    }
 
 LoginDao LoginDao = new LoginDao();
        @Test
        public void createValidUserA() {
            LoginBean validUser = new LoginBean(); 
            validUser.setUserName("HMSadmin@gmail.com");
            validUser.setPassword("abde123");

            LoginDao.authenticateUser(validUser);

            assertEntityCreatedInDB(validUser);
        }

        private void assertEntityCreatedInDB(LoginBean validUser) {
			// TODO Auto-generated method stub
			
		}
        @Test
        public void createValidUserD() {
            LoginBean validUser = new LoginBean(); 
            validUser.setUserName("harrys@gmail.com");
            validUser.setPassword("abty123");


            LoginDao.authenticateUser(validUser);

            assertEntityCreatedInDB(validUser);
        }
        
        @Test
        public void createValidUserP() {
            LoginBean validUser = new LoginBean(); 
            validUser.setUserName("test@gmail.com");
            validUser.setPassword("test12345");


            LoginDao.authenticateUser(validUser);

            assertEntityCreatedInDB(validUser);
        }

        @Test
        public void createInvalidUser() {
            LoginBean InvalidUser = new LoginBean();
            InvalidUser.setUserName("1234");
            InvalidUser.setPassword("hg");

            LoginDao.authenticateUser(InvalidUser);
            assertEntityCreatedInDB(InvalidUser);
            System.out.println("Invalid");
           
           // assertTransactionWasRolledBack(invalidUser);
        }   
}
