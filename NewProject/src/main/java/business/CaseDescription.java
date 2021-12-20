/*package business;

import java.sql.SQLException;
import java.util.ArrayList;

import db.MySQLHandler;

public class CaseDescription {
	MySQLHandler m;
	private String cname;
	private String cdescription;
	private int cgoal;
	private int id;
	
	public CaseDescription( String cname, String cdescription, int cgoal) {
		this.cname = cname;
		this.cdescription = cdescription;
		this.cgoal = cgoal;
	}
	public CaseDescription() {
		// TODO Auto-generated constructor stub
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public int getCgoal() {
		return cgoal;
	}
	public void setCgoal(int cgoal) {
		this.cgoal = cgoal;
	}
	
	
	
	public CaseDescription(int id, String cname, String cdescription, int cgoal) throws ClassNotFoundException, SQLException {
		super();
		this.id=id;
		this.cname = cname;
		this.cdescription = cdescription;
		this.cgoal = cgoal;
		
	}
	public void proposedCase(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.casesDB(name,description,goal);
	}
	
	public void activeCase(String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.activeCasesDB(name,description,goal);
	}
	
	public ArrayList<CaseDescription> getAll() throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		return m.pcasesGet();
	}
	
	
	/*
	public void getAll() throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.getDetails();
		
		for(int i=0;i<m.cd.size();i++) {
			System.out.println("CASES IN DB "+m.cd.get(i));
		}
	}	
		public void getaCase(String caseNo) throws ClassNotFoundException, SQLException
		{
			m=new MySQLHandler();
			m.getPartDetails(caseNo);;
			
			for(int i=0;i<m.cd.size();i++) {
				System.out.println("CASES IN DB "+m.cd.get(i));
			}
			
		}
		
		}
	*/	
		
package business;

import java.sql.SQLException;
import java.util.ArrayList;

import db.MySQLHandler;

public class CaseDescription {
	MySQLHandler m;

	private int caseID;
	private String title;
	private String desc;
	private int target;

	public int getCaseID() {
		return caseID;
	}

	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public CaseDescription( String cname, String cdescription, int cgoal) {
		this.title = cname;
		this.desc = cdescription;
		this.target = cgoal;
	}

	public CaseDescription(int caseID, String title, String desc, int target) {
		this.caseID = caseID;
		this.title = title;
		this.desc = desc;
		this.target = target;
	}

	/*
	public void getAll() throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		m.getDetails();
		
		for(int i=0;i<m.cd.size();i++) {
			System.out.println("CASES IN DB "+m.cd.get(i));
		}
	}	
		public void getaCase(String caseNo) throws ClassNotFoundException, SQLException
		{
			m=new MySQLHandler();
			m.getPartDetails(caseNo);;
			
			for(int i=0;i<m.cd.size();i++) {
				System.out.println("CASES IN DB "+m.cd.get(i));
			}
			
		}
	*/	
		
	public CaseDescription() {
		// TODO Auto-generated constructor stub
	}

	public boolean proposedCase(int id,String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		boolean flag = m.casesDB(id,name,description,goal);//adding data in casedetails not confirmed yet 
	    return flag;
	}
	
	public boolean activeCase(int id,String name, String description, int goal) throws ClassNotFoundException, SQLException
	{
		m=new MySQLHandler();
		boolean f = m.activeCasesDB(id,name,description,goal);//adding data in casedescription
	    return f;
	}
	
	public ArrayList<CaseDescription> getAll() throws ClassNotFoundException, SQLException//not confirmed cases
	{
		m=new MySQLHandler();
		return m.pcasesGet();
	}
	

}
	
	



