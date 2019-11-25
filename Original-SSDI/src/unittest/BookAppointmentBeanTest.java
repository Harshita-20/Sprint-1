package unittest;

import static org.junit.Assert.*;

import java.sql.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.junit.Test;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;

import com.login.bean.BookAppointmentBean;

public class BookAppointmentBeanTest {

	@Test
	public void BeanTest() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/YYYY");
		String dateInString = "11/20/2019";
		Date d = formatter.parse(dateInString);
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());
		//System.out.println(d);
		SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm a");
		String time = "10:00 AM";
		long ms = formatDate.parse(time).getTime();
		Time t = new Time(ms);
		//System.out.println(t);

		BookAppointmentBean BAB = new BookAppointmentBean();
		BAB.setSpecialist("Dental");
		BAB.setAppointment_Date(d);
		BAB.setAppointment_Time(t);
		BAB.setProblem_Description("XYZT");
		BAB.setComments("ABCD");
		BAB.setEmail("test@gmail.com");

		new VerificationMode() {
			{
				assertEquals("Dental", BAB.getSpecialist());
				assertEquals(sqlDate, BAB.getAppointment_Date());
				assertEquals(t, BAB.getAppointment_Time());
				assertEquals("XYZT", BAB.getProblem_Description());
				assertEquals("ABCD", BAB.getComments());
				assertEquals("test@gmail.com", BAB.getEmail());
			}

			@Override
			public void verify(VerificationData data) {

			}
		};

	}
};
