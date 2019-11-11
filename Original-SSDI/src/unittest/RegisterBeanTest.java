package unittest;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.verification.VerificationMode;


import com.login.bean.RegisterBean;

public class RegisterBeanTest {
	private RegisterBean RB;

	
	 @Test
	 public void TestWithCorrectParams() {

	 RB = new RegisterBean();

	 RB.setFirstName("TestFN");
	 RB.setLastName("TestLN");
	 RB.setEmail("Test12@gmail.com");
	 RB.setContact("4536192870");
	 RB.setPassword("Test1234");  
	 RB.setGender("F");
	 RB.setAddress("UTN");
	 
	 

	 new VerificationMode() {{
	 assertEquals("TestFN", RB.getFirstName());
	 assertEquals("TestLN", RB.getLastName());
	 assertEquals("Test1234", RB.getPassword());
	 assertEquals("Test12@gmail.com", RB.getEmail()); 
	 assertEquals("4536192870", RB.getContact());
	 assertEquals("F", RB.getGender());
	 assertEquals("UTN", RB.getAddress());}
	@Override
	public void verify(VerificationData data) {
		
	}};


	 }
};
	/*@Test
	public void IncorrectDetails() {
		
		String firstName = rb.setFirstName("Smrithi");
		String lastName = rb.setLastName("Suriya");
		String email = rb.setEmail("smriths05@gmail.com");
		String contact = rb.setContact("9803371870");
		String password = rb.setPassword("bubbles97");
		String gender  = rb.setGender("Female");
		String address = rb.setAddress("508 Barton Creek");
	      
			
	      
	      Assertions.assertEquals(firstName, "Aditya", "");
	      Assertions.assertEquals(lastName, "Suriya", "");
	      Assertions.assertEquals(email, "smriths05@gmail.com", "");
	      Assertions.assertEquals(contact, "9803371870", "");
	      Assertions.assertEquals(password, "bubbles97", "");
	      Assertions.assertEquals(gender, "Male", "");
	      Assertions.assertEquals(address, "508 Barton Creek", "");
	     
	}*/

