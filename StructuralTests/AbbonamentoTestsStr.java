import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class AbbonamentoTestsStr {
	
	private static Abbonamento abb = null;
	private static Cliente c;
	
	@BeforeClass
	public static void setup(){
		
		abb = new Abbonamento();
	}
	
	@Test
	public void tAggiornaBiglietti() {
		assertNotNull("Oggetto Abbonamento non istanziato" , abb);
		
		abb.setnBigliettiRimanenti(4);
		
		int nBiglietti = 3;
		
		int expectedRefund = 1; 
		
		abb.aggiornaBiglietti(nBiglietti);
		
		int br = abb.getnBigliettiRimanenti();
		  
		assertEquals("Biglietti non scalati " , expectedRefund , br);
		
		abb.setnBigliettiRimanenti(2);
		abb.aggiornaBiglietti(nBiglietti);
		
	}
	
	@Test
	public void tRimborsoBiglietti(){
		assertNotNull("Oggetto Abbonamento non istanziato" , abb);
		
		abb.setnBigliettiRimanenti(5);
		
		int nBiglietti = 4;
		
		int expectedRefund = 9;
		
		abb.rimborsoBiglietti(nBiglietti);
		
		int br = abb.getnBigliettiRimanenti(); 
		
		assertEquals("Biglietti non rimborsati " , expectedRefund , br);
	}
	
	@Test
	public void tgetTipo(){
		abb.setTipo("tipo");
		String expect = "tipo";
		assertEquals("test getters/setters" , expect , abb.getTipo());
	}
	
	@Test
	public void tsetTipo(){
		abb.setTipo("tipo");
		String expect = "tipo";
		assertEquals("test getters/setters" , expect , abb.getTipo());
	}
	
	
	@Test
	public void tgetCosto(){
		abb.setCosto(12.03f); 
		float expect = 12.03f; 
		assertEquals("test getters/setters" , expect , abb.getCosto() , 1);
	}
	
	
	@Test
	public void tsetCosto(){
		abb.setCosto(12f);
		float expect = 12f;
		assertEquals("test getters/setters" , expect , abb.getCosto() , 1);
	}
	
	@Test 
	public void tgetCliente(){
		c = new Cliente();
		abb.setCliente(c);
		Cliente exp = c;
		assertEquals("test getters/setters" , exp ,abb.getCliente());
	}
	
	@Test 
	public void tsetCliente(){
		c = new Cliente();
		abb.setCliente(c);
		Cliente exp = c;
		assertEquals("test getters/setters" , exp ,abb.getCliente());
	}
	
	
	
	
	

}
