import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class PagamentoStr {

	private static Pagamento p;
	
	@BeforeClass
	public static void setup(){
		p = new Pagamento(123 , new Date() , "VISA" , false);
	}

	@Test
	public void paga(){
		p.eseguiPagamento("VISA");
	}
}
