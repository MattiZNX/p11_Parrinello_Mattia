import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC2_Logout {
	
	private static Utente user;
	
	@BeforeClass
	public static void setup(){
		user = new Utente(); 
		user.defUtente("Carlo" , "Magno" , "cm@gmail.com" , "carlus" , "magnus" , 1);
		user.setLoggato(true);
			 
	}

	@Test
	public void Logout() {
		/*
		 * il sistema non ha modo di controllare se il logout è avvenuto 
		 * per tanto la funzione logout semplicemente stampa un messaggio di uscita 
		 * un test consta quindi della semplice esecuzione della funzione 
		 */
		user.logout();
		assertEquals("Utente non Sloggato" , user.getLoggato() , false);
		
	}
	
	
	

}
