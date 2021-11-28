package offbrand_pictionary;

import static org.junit.Assert.*;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;
/*
 * Class: CreateAccountTest
 * usage: Testing the ability to create an account
 */
public class CreateAccountTest {

	/* 
	 * Tests required:
	 * 		* Login correct - uses submit
	 * 		* Username taken - uses submit
	 * 		* Password doesn't match - uses submit
	 * 		* leave page - uses cancel
	 */
	private PlayerGUI pg;
	private CreateAccountControl gac;
	private CreateAccountPanel gap;
	
	@Before
	public void setUp() {
		CreateAccountControl gac = new CreateAccountControl(null, null);
		CreateAccountPanel gap = new CreateAccountPanel(gac);
		pg = new PlayerGUI();
		
		
		
	}
	
	/*
	 * CorrectLoginTest
	 * 		* Randomly generates a username and password and uses the random password as the reentered password
	 * 		* Outcome - Account created successfully
	 */
	@Test
	public void CorrectLoginTest() {
		JButton button;
		//How do i pass the jpanel
		//How do I get connection to the client
		String username = gap.getUsername();
		
	
	}
	
	/* 
	 * UsernameTakenTest
	 * 		* Use a username already in the system
	 * 		* Outcome - An error message should appear
	 */
	@Test
	public void UsernameTakenTest() {
		fail("Not yet implemented");
	}

	/*
	 * NoMatchPasswordTest
	 * 		* Checks equality between password field and re-entered password field
	 */
	@Test
	public void NoMatchPasswordTest() {
		fail("Not yet implemented");
	}

	/*
	 * LeavePanelTest
	 * 		* only clicks the cancel button
	 */
	@Test
	public void LeavePanelTest() {
		fail("Not yet implemented");
	}

}