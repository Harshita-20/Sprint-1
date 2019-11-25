package unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.login.bean.BookAppointmentBean;
import com.login.bean.RegisterBean;
import com.login.dao.BookAppointmentDao;

import com.login.util.IConnectionData;



@RunWith(MockitoJUnitRunner.class)
public class BookAppointmentDaoTest {

    @InjectMocks
    private BookAppointmentDao Dao;
    
    @Mock
    private PreparedStatement mockPreparedStmnt;
    
    @Mock
    private ResultSet result_set;
    
    private BookAppointmentBean BAB;


    
    @Before
    public void setUp() throws Exception {
    
        MockitoAnnotations.initMocks(this);
        createTestObject();
        IConnectionData connection = IConnectionData.getInstance("Test") ;
        Dao = new BookAppointmentDao(connection);
                
    }    

    private void createTestObject() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/YYYY");
		String dateInString = "11/22/2019";
		Date d = formatter.parse(dateInString);
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());

		SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm a");
		String time = "10:00 AM";
		long ms = formatDate.parse(time).getTime();
		Time t = new Time(ms);
		
		
		BAB = new BookAppointmentBean();
		
		BAB.setDoctorName("Andrew Roy");
		BAB.setPatientName("Rahul");
		BAB.setSpecialist("Dental");
		BAB.setAppointment_Date(sqlDate);
		BAB.setAppointment_Time(t);
		BAB.setProblem_Description("TestPD");
		BAB.setComments("TestCommets");
		
	}



			 
	@Test
	public void BookAppointment() throws SQLException, ParseException {
		

		Dao.bookAppointment(BAB);
		
		
		String sql= "Select * from appointmentdetails";

		when(result_set.first()).thenReturn(true);
		when(result_set.getString(1)).thenReturn(BAB.getDoctorName());
		when(result_set.getString(2)).thenReturn(BAB.getPatientName());
		when(result_set.getString(3)).thenReturn(BAB.getSpecialist());
		when(result_set.getDate(4)).thenReturn( (java.sql.Date) BAB.getAppointment_Date());
		when(result_set.getTime(5)).thenReturn(BAB.getAppointment_Time());
		when(result_set.getString(6)).thenReturn(BAB.getProblem_Description());
		when(result_set.getString(7)).thenReturn(BAB.getComments());
		when(mockPreparedStmnt.executeQuery(sql)).thenReturn(result_set);	

		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/YYYY");
		String dateInString = "11/22/2019";
		Date d = formatter.parse(dateInString);
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());

		SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm a");
		String time = "10:00 AM";
		long ms = formatDate.parse(time).getTime();
		Time t = new Time(ms);
		
		assertEquals("Andrew Roy", result_set.getString(1));
		assertEquals("Rahul", result_set.getString(2));
		assertEquals("Dental", result_set.getString(3));
		assertEquals(sqlDate, result_set.getString(4));
		assertEquals(t, result_set.getString(5));
		assertEquals("TestPD", result_set.getString(6));
		assertEquals("TestComments", result_set.getString(7));
	}

	

}

