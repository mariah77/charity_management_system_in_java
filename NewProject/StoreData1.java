


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

	        Person p=new Person();
	        p.setName("Azhar");
	        p.setSurname("Ali");
	        session.save(p);
	        
	        
	        trans.commit();
	 }
}
	        

