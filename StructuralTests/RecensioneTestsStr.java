import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class RecensioneTestsStr {
	
	private static Recensione rec = null;
	
	@BeforeClass
	public static void setup(){
		rec = new Recensione();
	}

	@Test
	public void tIsValid() {
		assertNotNull("Recensione non istanziata"); 
		
		rec.setCommento("Bellissimo");
		rec.setVoto(5);
		
		assertTrue("Error assert", rec.isValid());
	} 
	
	@Test
	public void tIsValid_2nd(){ 
		
		rec.setCommento("pessimo");  
		rec.setVoto(10);
		assertFalse("Error Assert" , rec.isValid()); 
	}
	
	@Test
	public void tDisplayError(){
		// Test visivo
		rec.displayError();
	}
	
	@Test
	public void tSetVoto(){
		rec.setVoto(3);
		assertEquals("Error Assert" , rec.getVoto() , 3);
	}
	
	@Test
	public void tSetVoto_2nd(){
		rec.setVoto(10);
		assertNotEquals("Error Assert" , rec.getVoto() , 10);
	}

}
