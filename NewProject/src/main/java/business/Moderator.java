package business;

import java.util.ArrayList;

import db.MySQLHandler;

public class Moderator extends Account{
	private String firstname;
	private String username;
	private String email;
	
private String password;

	
    public Moderator() {
    	
    }
	public Moderator(String firstname, String username, String email,
			String password) {
		super();
		
		this.firstname = firstname;
		this.username = username;
		this.email = email;
		this.password = password;
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
	
	
}
