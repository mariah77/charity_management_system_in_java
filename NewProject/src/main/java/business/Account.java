package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import db.MySQLHandler;

public class Account {
	
	public ArrayList<Donor> donors;
	public ArrayList<Moderator> moderators;

	public MySQLHandler m;

	public Account() {
		/*donors = new ArrayList<Donor>();
		//party_id=0;
		MySQLHandler m=new MySQLHandler();
		//v=db1.checkVoter();
		donors=m.donorDB(username, password, firstname, email);*/
		
		// TODO Auto-generated constructor stub
	}
	

	public boolean signUp(String name, String usrName, String email, String pass) throws ClassNotFoundException, SQLException {
		donors = new ArrayList<Donor>();
		m=new MySQLHandler();
		boolean f = m.donorDB(name, usrName, email, pass);
		donors.add(new Donor(name,usrName,email,pass));
		for(int i=0;i<donors.size();i++) {
			System.out.println("Name "+donors.get(i).getFirstname()+" Username "+donors.get(i).getUsername()+" email"+donors.get(i).getEmail()+" password"+donors.get(i).getPassword());
			
		}
		
		return f;
		//party_id=0;
		
		
	}
	
	public boolean moderatorAddition(String name, String usrName, String email, String pass) throws ClassNotFoundException, SQLException {
		
		moderators = new ArrayList<Moderator>();
		m=new MySQLHandler();
		boolean f =m.moderatorDB(name, usrName, email, pass);
		moderators.add(new Moderator(name,usrName,email,pass));
		for(int i=0;i<moderators.size();i++) {
			System.out.println("Name "+moderators.get(i).getFirstname()+" Username "+moderators.get(i).getUsername()+" email"+moderators.get(i).getEmail()+" password"+moderators.get(i).getPassword());
			
		}
		return f;
	}
	public ArrayList<Donor> getData() throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		donors=m.donorGet();
		Collections.copy(donors,m.donorGet());

		for(int i=0;i<donors.size();i++) {
			System.out.println("Name "+donors.get(i).getFirstname()+" Username "+donors.get(i).getUsername()+" email"+donors.get(i).getEmail()+" password"+donors.get(i).getPassword());
			
		}
		return donors;
	}
	
	public Boolean signIn(String usrName, String pass) throws ClassNotFoundException, SQLException {
		
		m=new MySQLHandler();
		donors=m.donorGet();
		Collections.copy(donors,m.donorGet());
		for(int i=0;i<donors.size();i++) {	//size ka function to get arraylist ka size
				
				if((usrName.equalsIgnoreCase(donors.get(i).getFirstname()))&&(pass.equalsIgnoreCase(donors.get(i).getPassword()))) {	
					
					//System.out.println("Element name "+mylist.get(i).name+" number "+mylist.get(i).number);
					System.out.println("Good work\n");
					return true;
					
				}
				
			}
			return false;
		}
	

	public boolean moderatorsignIn(String usrName, String pass) throws ClassNotFoundException, SQLException {
		
		m=new MySQLHandler();
		moderators=m.moderatorGet();
		Collections.copy(moderators,m.moderatorGet());
		for(int i=0;i<moderators.size();i++) {	//size ka function to get arraylist ka size
				
				if((usrName.equalsIgnoreCase(moderators.get(i).getFirstname()))&&(pass.equalsIgnoreCase(moderators.get(i).getPassword()))) {	
					
					//System.out.println("Element name "+mylist.get(i).name+" number "+mylist.get(i).number);
					System.out.println("Good work\n");
					return true;
					
				}
				
			}
			return false;
		}
	

}
