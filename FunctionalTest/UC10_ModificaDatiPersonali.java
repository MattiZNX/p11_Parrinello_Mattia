import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC10_ModificaDatiPersonali {

		private static Utente user;
		private static boolean modifica;
		
	@BeforeClass
	public static void setup(){
		user = new Utente(); 
		user.defUtente("Luigi" , "Parodi" , "luigi.luigi@gmail.com" , "gigi" , "luigiXVI" , 0);
				
	}
	
	@Test
	public void ModificaDatiPersonali(){
		modifica = user.modificaDatiPersonali("Mario", "Rossi", "mario.rossi@gmail.com");
		assertTrue("operazione non riuscita" , modifica);
	}
	
		
	@Test
	public void ModificaDatiPersonali_5A(){
		// caso in cui uno dei campi sia non valido , cioè vuoto
		modifica = user.modificaDatiPersonali("", "Rossi", "mario.rossi@gmail.com");
		assertFalse("Use case non riuscito" , modifica);
	}
}
