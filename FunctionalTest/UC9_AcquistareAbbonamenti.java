
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC9_AcquistareAbbonamenti {

	private static CartaDiCredito cdc = null;
	private static Abbonamento abb = null;
	
	@BeforeClass
	public static void setup(){
		abb = new Abbonamento();
		cdc = new CartaDiCredito();
		cdc.setSaldo(156.45f);
	}
	
	@Test
	public void AcquistareAbbonamenti(){
		abb.setCosto(15.50f);
		boolean canPay = cdc.pagamento(abb.getCosto());
		assertEquals("Use Case non coperto" , canPay , true);
	}
	
	@Test
	public void AcquistareAbbonamenti_7A(){
		abb.setCosto(1565.50f);
		boolean canPay = cdc.pagamento(abb.getCosto());
		assertEquals("Use Case non coperto" , canPay , false);
	} 
	

}
