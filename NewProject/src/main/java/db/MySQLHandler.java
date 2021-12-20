package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import business.Case;
import business.CaseDescription;
import business.Donor;
import business.Moderator;


public class MySQLHandler {
	public String buf;

	public void casesDB()
	{
		
	}
	public boolean adminDB (String str1,String str2) throws SQLException, ClassNotFoundException
	{
			boolean flag= false;
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    //insertion
			String sql = "INSERT INTO admin(username,password) VALUES(?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, str1);
			statement.setString(2, str2);
			int rowInserted = statement.executeUpdate();
			if (rowInserted > 0)
			{
				System.out.println("New account added successfully");
				flag = true;
			}
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			con.close();
			return flag;
	}
	
	public boolean  donorDB (String str1,String str2,String str3, String str4) throws SQLException, ClassNotFoundException
	{
		//ArrayList<Donor>temp=new ArrayList<Donor>();
		boolean f = false;
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    //insertion
			String sql = "INSERT INTO donor(name,username,email,password) VALUES(?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, str1);
			statement.setString(2, str2);
			statement.setString(3, str3);
			statement.setString(4, str4);
			int rowInserted = statement.executeUpdate();
			if (rowInserted > 0)
			{
				System.out.println("New account added successfully");
				f =  true;
			}
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from donor");
			while(rs.next())
			{
				//System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3)+ rs.getString(4));
				String name=rs.getString("name");
				String username=rs.getString("username");
				String email=rs.getString("email");
				String password=rs.getString("password");


			}
		
			con.close();
			return f;
			

	}
	
	
	public boolean moderatorDB (String str1,String str2,String str3, String str4) throws SQLException, ClassNotFoundException
	{
		//ArrayList<Donor>temp=new ArrayList<Donor>();

		    boolean f = false;
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    //insertion
			String sql = "INSERT INTO moderator(name,username,email,password) VALUES(?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, str1);
			statement.setString(2, str2);
			statement.setString(3, str3);
			statement.setString(4, str4);
			int rowInserted = statement.executeUpdate();
			if (rowInserted > 0)
			{
				System.out.println("New account added successfully");
				f = true;
			}
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from moderator");
			while(rs.next())
			{
				String name=rs.getString("name");
				String username=rs.getString("username");
				String email=rs.getString("email");
				String password=rs.getString("password");


			}
		
			con.close();
			return f;
			
			

	}
	
	public ArrayList<Donor> donorGet () throws SQLException, ClassNotFoundException
	{
		ArrayList<Donor>temp=new ArrayList<Donor>();

			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from donor");
			while(rs.next())
			{
				//System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3)+ rs.getString(4));
				String name=rs.getString("name");
				String username=rs.getString("username");
				String email=rs.getString("email");
				String password=rs.getString("password");

				temp.add(new Donor(name,username,email,password));//name,username,email,password));

			}	
			con.close();
			
			return temp;
	}
	
	
	/*
	//to get details of a specific case
	public void getPartDetails (String caseNo) throws SQLException, ClassNotFoundException
	{
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from casedetails where casenumber = 'CASE 01'"  );
			while(rs.next())
			{
				//System.out.println("sql handler: " + rs.getString(1)+ rs.getString(2)+ rs.getString(3));
				

			}
	
			con.close();
	}

	*/
	
	
	//////////////////////cases
	public boolean casesDB (int id,String str1,String str2,int int1) throws SQLException, ClassNotFoundException// for not confirmed cases
	{
		//ArrayList<Donor>temp=new ArrayList<Donor>();
            boolean flag = false;
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    //insertion
			String sql = "INSERT INTO casedetails(caseid,name,description,goal) VALUES(?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, str1);
			statement.setString(3, str2);
			statement.setInt(4, int1);
			int rowInserted = statement.executeUpdate();
			if (rowInserted > 0)
			{
				System.out.println("New case added successfully");
				flag = true;
			}
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from casedetails");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+rs.getString(2)+ rs.getString(3)+ rs.getString(4));
				String casename=rs.getString("name");
				String casedesc=rs.getString("description");
				int goal=rs.getInt("goal");


			}
			
		
			con.close();
			return flag;
			
			

	}
	
	public boolean activeCasesDB (int id,String str1,String str2,int int1) throws SQLException, ClassNotFoundException
	{
		//ArrayList<Donor>temp=new ArrayList<Donor>();
		boolean f =false;
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    //insertion
			String sql = "INSERT INTO caseDescription(caseID,title,description,amount) VALUES(?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, str1);
			statement.setString(3, str2);
			statement.setInt(4, int1);
			int rowInserted = statement.executeUpdate();
			if (rowInserted > 0)
			{
				System.out.println("New case added successfully");
				f = true;
			}
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from caseDescription");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3)+rs.getString(4));
				String casename=rs.getString("title");
				String casedesc=rs.getString("description");
				int goal=rs.getInt("amount");


			}
		
			con.close();
		    return f;	
			

	}
	
	/////////////////////////////MODERATOR
	
	public ArrayList<CaseDescription> pcasesGet () throws SQLException, ClassNotFoundException// from casedetails
	{
		ArrayList<CaseDescription>temp=new ArrayList<CaseDescription>();

			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from casedetails");
			while(rs.next())
			{
				//System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3)+ rs.getString(4));
				int caseid=rs.getInt("caseid");
				String name=rs.getString("name");
				String description=rs.getString("description");
				int goal=rs.getInt("goal");

				temp.add(new CaseDescription(caseid,name,description,goal));//name,username,email,password));

			}	
			con.close();
			
			return temp;
	}
	
	public ArrayList<Case> getInCases() throws SQLException, ClassNotFoundException
	{
		ArrayList<Case>temp=new ArrayList<Case>();

			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from casedetails");
			while(rs.next())
			{
				//System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3)+ rs.getString(4));
				int caseid=rs.getInt("caseid");
				String name=rs.getString("name");
				String description=rs.getString("description");
				int goal=rs.getInt("goal");

				temp.add(new Case(caseid,name,description,goal));//name,username,email,password));

			}	
			con.close();
			
			return temp;
	}

	public ArrayList<CaseDescription> getDetails () throws SQLException, ClassNotFoundException
	{
		ArrayList<CaseDescription> temp2 =new ArrayList<CaseDescription>();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(" select * from caseDescription;");
		while(rs.next())
		{
			Integer caseID=rs.getInt("caseID");
			String title=rs.getString("title");
			String description=rs.getString("description");
			Integer amount=rs.getInt("amount");
			//System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3));

			temp2.add( new CaseDescription(caseID,title,description,amount));

		}
		con.close();

		return temp2;
	}
	
	public ArrayList<Moderator> moderatorGet () throws SQLException, ClassNotFoundException
	{
		ArrayList<Moderator>temp2=new ArrayList<Moderator>();

			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
		    
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from moderator");
			while(rs.next())
			{
				//System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3)+ rs.getString(4));
				String name=rs.getString("name");
				String username=rs.getString("username");
				String email=rs.getString("email");
				String password=rs.getString("password");

				temp2.add(new Moderator(name,username,email,password));//name,username,email,password));

			}	
			con.close();
			
			return temp2;
	}
	
	
	//I AM NEW 
		public boolean updateTarget (String title,int updatedTarget) throws SQLException, ClassNotFoundException
		{
			//ArrayList<Donor>temp=new ArrayList<Donor>();

			boolean f = false;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
			//insertion
			String sql = "update caseDescription SET amount = ? WHERE title = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, updatedTarget);
			statement.setString(2, title);
			//statement.setString(3, "hogia");
			//statement.setInt(4, updatedTarget);
			int rowInserted = statement.executeUpdate();
			if (rowInserted > 0)
			{
				System.out.println("Updation Successful");
				f = true;
			}
			//display
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from caseDescription");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ rs.getString(2)+ rs.getString(3));
				String casename=rs.getString("title");
				String casedesc=rs.getString("description");
				int goal=rs.getInt("amount");
			}

			con.close();
			return f;
		}
	
	
	

}
