package donor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.Account;
import business.Admin;
import business.Case;
import business.CaseDescription;
import business.Donor;
import business.NGO;
import business.StringGenerator;

public class CaseTest {
	
	

	private static StringGenerator g;
	private static NGO ngo;
	private static Case c;
	private static Admin add;
	private static int id;
	private static Account a;
	
	@BeforeClass
	public static void init() {
	   
		c =  new Case();
		a = new Account();
		g = new StringGenerator();
		add = new Admin();
		
		ngo = new NGO();
		
		Random random = new Random(System.nanoTime() % 100000);

	   id = random.nextInt(1000);
		
	}
	@Test
	public void addcase() throws ClassNotFoundException, SQLException {
	
		//assertTrue(c.addProposedCase(id,"schooling", "providing free education", 1));//not confirmed yet in casedetails
		assertTrue(ngo.proposedCases(id, "schooling", "sdsdds", 1));
		assertTrue(ngo.addCases(id,"schooling", "providing free education", 10000));//confirmed in casedescription
		
	}
	@Test 
	public void getcasedescriptiondata() throws ClassNotFoundException, SQLException {
		ArrayList<CaseDescription> c1 = c.getData();// all not confirmed casedesc objs in it
		assertNotNull(c1);
		ArrayList<Case> c2 = c.cases();
		assertNotNull(c2);
		ArrayList<CaseDescription> c3 = c.fetchDescription();
		ArrayList<Case> cf = ngo.getData();
		assertNotNull(c3);
		assertNotNull(cf);
	}
	@Test
	public void updatetarget() throws ClassNotFoundException, SQLException {
		//String s = "ngo";
		assertFalse(c.updateTarget("ngo",12000));
	}
	@Test
	public void signup() throws ClassNotFoundException, SQLException {
		
		Random rand = new Random(System.currentTimeMillis());
		int ran = (int) (rand.nextInt(1000)%20+1);
		String username = g.generateRandomPassword(ran);
		String password = g.generateRandomPassword(ran);
		String email = g.generateRandomPassword(ran);
		assertTrue(a.signUp("maria",username, email, password));
		assertTrue(a.signIn("maria", password));
	}
	
	@Test 
	public void addmoderator() throws ClassNotFoundException, SQLException {
		Random rand = new Random(System.currentTimeMillis());
		int ran = (int) (rand.nextInt(1000)%20+1);
		
		String username = g.generateRandomPassword(ran);
		String password = g.generateRandomPassword(ran);
		String email = g.generateRandomPassword(ran);
	    assertTrue(a.moderatorAddition("alice",username, email, password));
	    assertTrue(a.moderatorsignIn("alice", password));
	    
		
	}
	@Test
	public void signin() throws ClassNotFoundException, SQLException {
		ArrayList<Donor> d = a.getData();
		assertNotNull(d);
	}
	@Test
	public void addadmin() throws ClassNotFoundException, SQLException {
		Random rand = new Random(System.currentTimeMillis());
		int ran = (int) (rand.nextInt(1000)%20+1);
		
		String username = g.generateRandomPassword(ran);
		String password = g.generateRandomPassword(ran);
		assertTrue(add.addadmin(username, password));
	}
}
