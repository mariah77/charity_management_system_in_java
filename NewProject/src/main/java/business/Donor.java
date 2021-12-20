package business;

import java.sql.SQLException;
import java.util.ArrayList;

import db.MySQLHandler;

public class Donor  {

	ArrayList<String> credentials = new ArrayList<String>() ;
	
	 MySQLHandler m=new MySQLHandler();

	private String firstname;

	private String username;

	private String email;
	 /*public Donor(String name,String username,String email,String password) throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public Donor(String firstame, String username, String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		m.donorDB(name, usrName, email, pass);	
		}
	
	*/

	private String password;

	

	public Donor(String firstname, String username, String email,
			String password) {
		super();
		
		this.firstname = firstname;
		//System.out.println(firstname);
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Donor() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getCredentials() {
		return credentials;
	}

	public void setCredentials(ArrayList<String> credentials) {
		this.credentials = credentials;
	}

	public MySQLHandler getM() {
		return m;
	}

	public void setM(MySQLHandler m) {
		this.m = m;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/*
	 * MySQLHandler m;
	 

	private String name;
	private String username;
	private String email;
	private String password;

	//ArrayList<Donor> donors=new ArrayList<Donor>();

	
	public Donor(String name, String username, String email, String password) throws ClassNotFoundException, SQLException {
		super();
		//this.m = m;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		//m.donorDB(name, username, email, password);
	}




	public Donor() {
		// TODO Auto-generated constructor stub
	}
	
	public void addDonor(String name, String username, String email, String password) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.donorDB(name, username, email, password);

	}
	public void tokenizeBuffer()
	{
	//System.out.println(m.buf);
	}
	/*
	public Boolean searchDonor(String username,String password) throws ClassNotFoundException, SQLException //,String password)
	{
		m=new MySQLHandler();
		//m.findUser();
		
		for(int i=0;i<m.user.size();i++) {
			System.out.println("USERNAMES IN DB "+m.user.get(i));
		}
		for(int i=0;i<m.pw.size();i++) {
			System.out.println("Passwords IN DB "+m.pw.get(i));
		}
		
		int i;
		for(i=0;i<m.user.size();i++) {//size ka function to get arraylist ka size
			for(i=0;i<m.pw.size();i++) {
				if((username.equals(m.user.get(i)))&&(password.equals(m.pw.get(i)))) {	
					
					System.out.println("username"+m.user.get(i));
					System.out.println("password"+m.pw.get(i));
					System.out.println("Username and Password Valid \n");
					return true;
				}
				else
					System.out.println("Credentials invalid");
					return false;
			}
			
		}
		return true;
	}
	*/
	


}
