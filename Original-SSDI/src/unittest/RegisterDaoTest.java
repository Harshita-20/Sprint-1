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
public class RegisterDaoTest {

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
    
    private RegisterBean RB;

 
		@Before
	public void setUp() throws Exception {
		assertNotNull(ds);
		when(mockConn.prepareStatement((String) any(String.class))).thenReturn(mockPreparedStmnt);
		when(((Statement) ds).getConnection()).thenReturn(mockConn);
		
		RB = new RegisterBean();
		
		
		RB.setFirstName("Johannes");
		RB.setLastName("Smythe");
		RB.setPassword("test@1234");
		//RB.setEmail("test2@gmail.com");
		RB.setEmail("test1@gmail.com");
		RB.setContact("9865341270");
		RB.setGender("F");
		RB.setAddress("951 K UTD");
		
	

		when(mockResultSet.first()).thenReturn(true);
		when(mockResultSet.getString(1)).thenReturn(RB.getFirstName());
		when(mockResultSet.getString(2)).thenReturn(RB.getLastName());
		when(mockResultSet.getString(3)).thenReturn(RB.getPassword());
		when(mockResultSet.getString(4)).thenReturn(RB.getEmail());
		when(mockResultSet.getString(5)).thenReturn(RB.getContact());
		when(mockResultSet.getString(5)).thenReturn(RB.getGender());
		when(mockResultSet.getString(7)).thenReturn(RB.getAddress());
		when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
		
	}


    private String any(Class<String> class1) {
		// TODO Auto-generated method stub
		return null;
	}


			 
	@Test
	public void Registeruser() {
		new RegisterDao();
		//RegisterDao.registerUser(RB);
	}

	

}


