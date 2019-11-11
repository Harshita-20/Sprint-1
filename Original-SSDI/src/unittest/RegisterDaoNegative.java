package unittest;

import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.login.bean.RegisterBean;
import com.login.dao.RegisterDao;
import com.login.util.DBConnection;
import com.mysql.jdbc.*;


@RunWith(MockitoJUnitRunner.class)
public class RegisterDaoNegative {

    @InjectMocks
    private RegisterDao Dao;

    @Mock
    private DBConnection ds;
    @Mock
    private DataSource mockDataSource;
    @Mock
    private Connection mockConn;
    @Mock
    private PreparedStatement mockPreparedStmnt;
    @Mock
    private ResultSet mockResultSet;
    
    private RegisterBean RB1;
    
    @Before
	public void setUp() throws Exception {
		assertNotNull(ds);
		when(mockConn.prepareStatement((String) any(String.class))).thenReturn(mockPreparedStmnt);
		when(((Statement) ds).getConnection()).thenReturn(mockConn);
		
		RB1 = new RegisterBean();
	
		RB1.setFirstName("Johannes");
		RB1.setLastName("Smythe");
		RB1.setPassword("test@1234");
		RB1.setEmail(null);
		RB1.setContact("9865341270");
		RB1.setGender("F");
		RB1.setAddress("951 K UTD");
		
	

		when(mockResultSet.first()).thenReturn(true);
		when(mockResultSet.getString(1)).thenReturn(RB1.getFirstName());
		when(mockResultSet.getString(2)).thenReturn(RB1.getLastName());
		when(mockResultSet.getString(3)).thenReturn(RB1.getPassword());
		when(mockResultSet.getString(4)).thenReturn(RB1.getEmail());
		when(mockResultSet.getString(5)).thenReturn(RB1.getContact());
		when(mockResultSet.getString(5)).thenReturn(RB1.getGender());
		when(mockResultSet.getString(7)).thenReturn(RB1.getAddress());
		when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
		
	}


    private String any(Class<String> class1) {
		// TODO Auto-generated method stub
		return null;
	}


			 
	@Test
	public void Registeruser() {
		new RegisterDao();
		//RegisterDao.registerUser(RB1);
	}

	

}

