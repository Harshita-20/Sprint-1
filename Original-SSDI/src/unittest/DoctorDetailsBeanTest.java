package unittest;

import static org.junit.Assert.*;

import java.sql.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.junit.Test;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;

import com.login.bean.DoctorDetailsBean;

public class DoctorDetailsBeanTest {

	@Test
	public void BeanTest() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/YYYY");
		String dateInString = "11/20/2019";
		Date d = formatter.parse(dateInString);

		SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm a");
		String from_time = "10:00 AM";
		String to_time = "03:00 PM";
		long msft = formatDate.parse(from_time).getTime();
		Time ft = new Time(msft);
		long mstt = formatDate.parse(to_time).getTime();
		Time tt = new Time(mstt);

		DoctorDetailsBean DD = new DoctorDetailsBean();
		DD.setDoctorName("Harry");
		DD.setSpecialisation("Dental");
		DD.setEmail("harrys@gmail.com");
		DD.setModifyDate(d);
		DD.setFROMTIME(ft);
		DD.setTOTIME(tt);

		new VerificationMode() {
			{
				assertEquals("Harry", DD.getDoctorName());
				assertEquals("Dental", DD.getSpecialisation());
				assertEquals("harrys@gmail.com", DD.getEmail());
				assertEquals(d, DD.getModifyDate());
				assertEquals(ft, DD.getFROMTIME());
				assertEquals(tt, DD.getTOTIME());
			}

			@Override
			public void verify(VerificationData data) {

			}
		};

	}
};
