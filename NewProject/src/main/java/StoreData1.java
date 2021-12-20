


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData1 {
	
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
	              
	        
	        Person p=new Person();
	        p.setName("Azhar");
	        //emp.setDesg("Professor");
	        //emp.setCompany("FAST");
	        p.setSurname("Ali");
	       // emp.setEmpAddress(add);
	        session.save(p);
	        
	        Car c=new Car();
	        c.setCarId(123);
	        c.setOwnerId(111);
	        c.setCarId(123);
	        c.setLiscenceplate("IDJ-9557");
	        c.setMake("Suzuki");
	        c.setModel("1909");


	        //emp.setDesg("Professor");
	        //emp.setCompany("FAST");
	        //p.setSurname("Ali");
	       // emp.setEmpAddress(add);
	        session.save(c);
	        
	        
	        trans.commit();
	 }
}
	        

