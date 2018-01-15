import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC3_Registrazione {
	
	private static Utente usernew , u1 , u2 , u3 , guest;
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
	public void Registrazione(){
		assertNotNull("Non è istanziato File" , userRegList);
		guest = new Utente();
		guest.defUtente("Ospite" , "Ospite" , "ops@gmail.com" , "ops" , "ops" , 0);
		boolean result = guest.registrazione("giul", "ces", "Giulio", "Cesaroni", "giuces@gmail.com", userRegList, "ces");
		assertTrue("Use Case non coperto" , result);
	}
	
	@Test
	public void Registrazione_4A(){
		/*
		 * username già in uso , utilizzo un utente già registrato 
		 */
		guest = new Utente();
		guest.defUtente("Ospite" , "Ospite" , "ops@gmail.com" , "ops" , "ops" , 0);
		boolean result = guest.registrazione("carlus", "magnus", "Carlo", "Magno", "cm@gmail.com", userRegList , "magnus");
			
		assertFalse("test 4A non passato" , result);
	}
	
	@Test
	public void Registrazione_4B(){
		/*
		 * la password non risultano coincidenti
		 */
		guest = new Utente();
		guest.defUtente("Ospite" , "Ospite" , "ops@gmail.com" , "ops" , "ops" , 0);
		boolean result = guest.registrazione("carlus", "magnus", "Carlo", "Magno", "cm@gmail.com", userRegList , "mg");
			
		assertFalse("test 4B non passato" , result);
	}
	
	@Test
	public void Registrazione_4C(){
		/*
		 * la mail è fuori dagli standard
		 */
		guest = new Utente();
		guest.defUtente("Ospite" , "Ospite" , "ops@gmail.com" , "ops" , "ops" , 0);
		boolean result = guest.registrazione("frank", "ff", "Franco", "Magno", "mailsbagliata.com", userRegList , "ff");
			
		assertFalse("test 4C non passato" , result);
	}
	

}
