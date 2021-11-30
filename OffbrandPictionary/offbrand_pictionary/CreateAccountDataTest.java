package offbrand_pictionary;

import static org.junit.Assert.*;

import java.awt.CardLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;
/*
 * Class: CreateAccountTest
 * usage: Testing the ability to create an account
 */
public class CreateAccountDataTest extends JPanel{

	/* 
	 * Tests required:
	 * 		* CreateAccountDataTest()
	 */
	
	private CreateAccountData gad;
	

	/*
	 * CreateAccountDataTest()
	 * 		* Randomly generates a username and password and uses the random password as the reentered password
	 * 		* Outcome - Password, username, and re entered password are initialized correctly
	 */
	@Test
	public void CreateAccountDataTest() {
		String[] username = generateRandomWords(1); 
		String[] password = generateRandomWords(1);
		String reenteredPassword = password[0];
		
		gad = new CreateAccountData(username[0], password[0], reenteredPassword);
		
		assertNotNull(gad.getPassword());
		assertNotNull(gad.getUsername());
		assertNotNull(gad.getRePassword());
	}
	
	/*
	 * Class: generateRandomWords(int numberofWords)
	 * 	generates a random array of string characters
	 * 	input to this function determines the number of random words created
	 */
	public static String[] generateRandomWords(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}

}