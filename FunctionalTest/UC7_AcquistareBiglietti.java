import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC7_AcquistareBiglietti {

	private static Prenotazione pren = null;
	private static Calendar myCal = null;
	private static Date dataPagamento = null;
	private static Date dataFilm = null;
	private static int filaPosti[] = null;
	private static int colPosti[] = null;
	private static Programmazione prog1 = null;
	private static Sala s1;
	private static boolean dimS1[][] = null;
	private static Abbonamento abb = null;
	private static CartaDiCredito cdc = null;
	
	private static float costoTotale = 0;
	
	@BeforeClass
	public static void setup(){
		
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dataPagamento = myCal.getTime();
		
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		dataFilm = myCal.getTime();
		
		pren = new Prenotazione();
		pren.setDataPagamento(dataPagamento);
		pren.setCostoTotale(15.00f);
		pren.setIdPrenotazione(3657);
		pren.setnBiglietti(4);
		
		abb = new Abbonamento();
		abb.setnBigliettiRimanenti(20);
		
		cdc = new CartaDiCredito();
		
		prog1 = new Programmazione(dataFilm , 12 , 23 , 123 , 30 , null,s1);
		
		pren.setProgrammazione(prog1);
		pren.setSala(s1);
		dimS1 = new boolean[4][4];
		s1 = new Sala("A1" , dimS1 , 16 , 123 , null);
		pren.calcolaTotale(3, 7.50f);
		costoTotale = pren.getCostoTotale();
		
		dimS1 = new boolean[][]{{true , true , true , true} , 
			{false , false , false , false},
			{true , false , true , false},
			{false , false , false , true}};

		s1.setPosti(dimS1);
		pren.setSala(s1);	
		
		
		//
		
	}
	
	@Test
	public void AcquistareBiglietti(){
		
		abb.setnBigliettiRimanenti(10);
		pren.setnBiglietti(4);
		filaPosti = new int[4];
		colPosti = new int[4]; 
		
		pren.setColPosti(colPosti);
		pren.setFilaPosti(filaPosti); 
		
		boolean avvenutapren = pren.pagaPrenotazione("Abbonamento", abb, cdc);
		boolean expectedResult=true;
		assertEquals("Errore nel pagamento" , avvenutapren , expectedResult);
	}
	
	@Test
	public void AcquistareBiglietti_4A(){
		/*
		 * si chiedono più biglietti di queli disponibili 
		 */
		pren.setnBiglietti(10);
		boolean postiLiberi = pren.verificaDisponibilitàPosti(10);
		assertEquals("Errore Caso d'uso 4A" , postiLiberi , false);
		
	}
	
	@Test
	public void AcquistareBiglietti_9A(){
		abb.setnBigliettiRimanenti(2);
		System.out.println("\n\n\n Print caso d'uso 9A : biglietti in abb " + abb.getnBigliettiRimanenti() + "\n\n\n");
		pren.setnBiglietti(4);
		boolean avvenutapren = pren.pagaPrenotazione("Abbonamento", abb, cdc);
		boolean expectedResult=false;
		// assertEquals("Errore Caso d'uso 9A" , avvenutapren , expectedResult);
		assertFalse("Errore Caso d'uso 9A" , avvenutapren);
				
	}
	
	@Test
	public void AcquistareBiglietti_9B(){
		cdc.setSaldo(6f);
		boolean avvenutapren = pren.pagaPrenotazione("CartaDiCredito", abb, cdc);
		boolean expectedResult=false;
		assertEquals("Errore Caso d'uso 9A" , avvenutapren , expectedResult);

		
	} 
	

}
