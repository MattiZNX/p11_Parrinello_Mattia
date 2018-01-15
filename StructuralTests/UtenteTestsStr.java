import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class UtenteTestsStr {
	
	private static Utente user , u1 , u2 , u3;
	private static ArrayList<Utente> userRegList;

	@BeforeClass
	public static void setup() throws Exception{
		user = new Utente();
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
	public void tLogin() {
		assertNotNull("Non è istanziato User" , user);
		assertNotNull("Non è istanziato File" , userRegList); 
		
		boolean logEseguito = user.login("mark", "marks", userRegList); 
		 
		assertTrue("Login non eseguito" , logEseguito);
				
	}
	
	@Test 
	public void tLogin_2nd(){
		// Utente non esiste nella lista delle registrazioni 
		assertFalse("Error Assert" , user.login("giuseppe", "vale", userRegList));
	}
	
	@Test 
	public void tRegistrazione(){
		assertNotNull("Non è istanziato User" , user);  
		assertNotNull("Non è istanziato File" , userRegList);  
		
		assertTrue("Assert Error",user.registrazione("mag", "bru", "Marco", "Franco", "marco.figo@gmail.com", userRegList , "bru"));
					
	}
	
	@Test
	public void tRegistrazione_2nd(){
		//Utente già registrato con lo stesso user
		assertFalse("Assert Error" , user.registrazione("jorge", "jorges", "Giuseppe", "Bello", "giuse@gmail.com", userRegList , "jorges"));
	}
	
	@Test
	public void tRegistrazione_3rd(){
		// Errore tra la password e la sua ripetizione 
		assertFalse("Assert Error" , user.registrazione("luc", "lucc", "Luca", "Bianchi", "lb@gmail.com", userRegList , "carlo"));
	}
	
	@Test
	public void tRegistrazione_4th(){
		// Mail senza @
		assertFalse("Assert Error" , user.registrazione("fab", "fab2", "Fabio", "Fermi", "ff.com", userRegList , "fab2"));
		
	}
	
	@Test
	public void tLogout(){
		assertTrue("AssertError" , user.logout() );
	}
	
	@Test
	public void tModificaDatiPers(){
		assertTrue("AssertError" , user.modificaDatiPersonali("Lorenzo", "Lollo", "ll@gmail.com"));
	}
	
	@Test
	public void tModificaDatiPers_2nd(){
		// Branch in cui uno dei valori non è valido 
		assertFalse("AssertError" , user.modificaDatiPersonali("", "", "ll@gmail.com"));
	}
	
	
	@Test
	public void tLog(){
		user.setLoggato(true);
		assertTrue("" , user.getLoggato());
	}

}
