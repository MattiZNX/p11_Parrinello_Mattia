import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC1_Autenticarsi {
	
	private static Utente  u1, u2 , u3;
	private static ArrayList<Utente> userRegList;


	@BeforeClass
	public static void setup(){
		userRegList = new ArrayList<Utente>();
		u1 = new Utente();
		u1.defUtente("Carlo" , "Magno" , "cm@gmail.com" , "carlus" , "magnus" , 1);
		u2 = new Utente();
		u2.defUtente("Marco" , "Marchi" , "mm@gmail.com" , "mark" , "marks" , 2);
		u3 = new Utente();
		u3.defUtente("Giorgio" , "DeGiorgi" , "gg@gmail.com" , "jorge" , "jorges" , 3);
		
		userRegList.add(u1);
		userRegList.add(u2); 
		userRegList.add(u3);
			 
	}
	
	@Test
	public void Autenticarsi() {
		boolean result = u2.login("mark", "marks", userRegList);
		assertTrue("Branch non coperto" , result);
	}
	
	@Test
	public void Autenticarsi_4A() {
		/*
		 * Scenario in cui l'username è lo stesso ma non la password , login restituisce false
		 */
		assertNotNull("Non è istanziato File" , userRegList);
		
		boolean result = u2.login("mark", "marco", userRegList);
		assertFalse("Branch non coperto" , result);
		
	}
	
	@Test
	public void Autenticarsi_4B() {
		/*
		 * Scenario in cui non è corretto username
		 */
		assertNotNull("Non è istanziato File" , userRegList);
		
		boolean result = u2.login("lore", "marco", userRegList);
		assertFalse("Branch non coperto" , result);
	}
	
}
