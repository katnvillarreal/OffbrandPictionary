package offbrand_pictionary;

import java.util.*;
import java.io.*;
import java.sql.*;

public class Database {
	// Private Data Members
	private Connection conn;
	//Add any other data fields you like ? at least a Connection object is mandatory
	
	// Constructor
	public Database() {
		try {
			//Create a properties
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("offbrand_pictionary/db.properties");
			
			prop.load(fis);
			String user = prop.getProperty("user");
			String pass = prop.getProperty("password");
			String url = prop.getProperty("url");
			
			conn = DriverManager.getConnection(url, user, pass);
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	// Query the database
	public ArrayList<String> query(String query) {
		//Add your code here
		ArrayList<String>  list = new ArrayList<String>();
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// Iterate through result set and create the comma delimited string
			while (rs.next()) {
				list.add(rs.getString(1)+","+rs.getString(2));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return list;
	}
	
	// Inserts
	public void executeDML(String dml) throws SQLException {
		//Add your code here
		Statement stmt = conn.createStatement();
		stmt.execute(dml);
	}
	
	// Method for verifying a username and password.
	public boolean verifyAccount(String username, String password) {
		String cmd = "select * from players where username='"+username+"' and password=aes_encrypt('"+ password + "','key');";
		ArrayList<String> result = this.query(cmd);
	    
		if (!result.isEmpty())
			return true;
		else
			return false;
	}
	  
	  // Method for creating a new account.
	public boolean createNewAccount(String username, String password) {
		String cmd = "select * from players where username='"+username+"' and password='"+password+"';";
		ArrayList<String> result = this.query(cmd);
	    
		if (result.isEmpty())  {
			try {
				String dml = "INSERT INTO players VALUES ('"+username+"', aes_encrypt('"+password+"', 'key'));";
				this.executeDML(dml);
				return true;
			} catch (SQLException e) { e.printStackTrace(); }
			return false;
		}
		else { return false; }
	}
	
	// Get a word from the database at random
	public String getWord(String choice) {
		String cmd = "select * from words where category='" + choice + "' order by RAND() LIMIT 1;";
		ArrayList<String> result = this.query(cmd);
		String[] word = result.get(0).split(",");
		return word[0];
	}
}