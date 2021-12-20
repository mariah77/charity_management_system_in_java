


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	
	 public static void main(String[] args) {
	        // loads configuration and creates a session factory
	        Configuration con = new Configuration();
	        con.configure();
	        SessionFactory sf= con.buildSessionFactory();
	        Session session= sf.openSession();
	        Transaction trans= session.beginTransaction();


	  /*      Address add= new Address();
	        add.setAddress_id(121);
	        add.setCity("Islambad");
	        add.setStreet("street 85");*/
	              
	        
	        Employee emp=new Employee ();
	        emp.setName("Azhar");
	        //emp.setDesg("Professor");
	        //emp.setCompany("FAST");
	        emp.setEmail("azhar.ali@gmail");
	       // emp.setEmpAddress(add);
	        session.save(emp);
	        
	        
	        trans.commit();
	 }
}
	        

