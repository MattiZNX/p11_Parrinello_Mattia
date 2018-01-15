import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CartaDiCreditoTestsStr {
	private static CartaDiCredito cdc = null;
	
	@BeforeClass
	public static void setup(){
		cdc = new CartaDiCredito();
		System.out.println("Creazione Carta");
	}

	@Test
	public void tPagamento() {
		assertNotNull("Carta non istanziata");
	
		cdc.setSaldo(123.98f);
		
		boolean pay = cdc.pagamento(34.98f);
		
		boolean expectedResult = true; 
		
		assertEquals("Pagamento non eseguito" , expectedResult , pay);
		
		cdc.setSaldo(12.34f);
		boolean payy = cdc.pagamento(15.35f);
		
		assertFalse(" " , payy);
		
	}
	
	
	@Test
	public void tRimborso() {
		assertNotNull("Carta non istanziata");
	
		cdc.setSaldo(123.98f);
		
		cdc.rimborso(10.02f);
		
		float expectedResult = 134.00f;
		
		float saldo = cdc.getSaldo();
				
		assertEquals("Pagamento non eseguito" , expectedResult , saldo , 0);
		
	} 
	
	@Test
	public void tgetncarta(){
		cdc.setnCarta("123");
		String exp = "123";
		assertEquals("test gettrs/setters" , exp , cdc.getnCarta());
	}
	
	@Test
	public void tgetSaldo(){
		cdc.setSaldo(123.4f);
		float exp = 123.4f;  
		assertEquals("test getters/setters" , exp , cdc.getSaldo() , 0);
	}
	
	

}
