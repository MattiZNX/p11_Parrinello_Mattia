import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class PrenotazioneTestsStr {
	
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
		pren.setnBiglietti(3);
		
		abb = new Abbonamento();
		abb.setnBigliettiRimanenti(20);
		
		cdc = new CartaDiCredito();
		cdc.setSaldo(102.36f);
		
		pren.setProgrammazione(prog1);
		pren.setSala(s1);
		dimS1 = new boolean[4][4];
		s1 = new Sala("A1" , dimS1 , 16 , 123 , null);
		
		prog1 = new Programmazione(dataFilm , 12 , 23 , 123 , 30 , null , s1);
	}


	@Test
	public void tCalcolaTotale() {
		assertNotNull("Oggetto non istanziato" , pren );
		
		pren.calcolaTotale(3, 7.50f);
		float costoTotale = pren.getCostoTotale();
		float expectedResult = 22.50f;
		assertEquals("Impossibile aggiornare i costi" , expectedResult , costoTotale , 0);
	}
	
	@Test
	public void tVerificaDisponibilitàPosti(){
		assertNotNull("Oggetto non istanziato" , pren );
		
		dimS1 = new boolean[][]{{true , true , true , true} , 
								{false , false , false , false},
								{true , false , true , false},
								{false , false , false , true}};
		
		s1.setPosti(dimS1);
		pren.setSala(s1);
		boolean postiLiberi = pren.verificaDisponibilitàPosti(4);
		boolean expectedResult = true;
		
		assertEquals("Non ci sono posti disponibili" , expectedResult , postiLiberi);
	}
	
	@Test 
	public void tVerificaDisponibilitàPosti_2nd(){
		dimS1 = new boolean[][]{{true , true , true , true} , 
			{false , false , false , false},
			{true , false , true , false},
			{false , false , false , true}};

			s1.setPosti(dimS1);
			pren.setSala(s1);
			boolean postiLiberi = pren.verificaDisponibilitàPosti(10);
		
			assertFalse("Branch non coperto" , postiLiberi);
	}
	
	@Test
	public void tCancellaPrenotazioneAbb(){
		assertNotNull("Oggetto non istanziato" , pren );
		
		dimS1 = new boolean[][]{{true , true , true , true} , 
								{false , false , false , false},
								{true , false , true , false},
								{false , false , false , true}};
		
		s1.setPosti(dimS1);
		pren.setSala(s1);
		
		filaPosti = new int[]{0 , 0 , 0 , 0};
		colPosti = new int[]{0 , 1 , 2 , 3};
		
		pren.setFilaPosti(filaPosti);
		pren.setColPosti(colPosti);
		
		myCal.set(Calendar.YEAR, 2018);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		dataFilm = myCal.getTime(); 
		
		prog1 = new Programmazione(dataFilm , 12 , 23 , 123 , 30 , null , s1);
		
		pren.setProgrammazione(prog1); 
		
		
		pren.cancellaPrenotazione(abb);
		
		boolean postiLiberi = pren.verificaDisponibilitàPosti(4); 
		boolean expectedPostiLiberi = true;
		
		boolean temp[][] = pren.getSala().getPosti();
		for(int i = 0 ; i < temp.length ; i++){
			for(int k = 0; k< temp[i].length; k++){
				System.out.print(temp[i][k] + "\t");
			}
			System.out.println();
		}
		
		assertEquals("Non si può cancellare la prenotazione" , expectedPostiLiberi , postiLiberi);
		
	}
	
	@Test 
	public void tCancellaPrenotazioneAbb_2nd(){
		
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		dataFilm = myCal.getTime(); 
		
		prog1 = new Programmazione(dataFilm , 12 , 23 , 123 , 30 , null , s1);
		
		pren.setProgrammazione(prog1);
		assertFalse("Asser error" , pren.cancellaPrenotazione(abb));
	}
	
	@Test
	public void tCancellaPrenotazioneCdc(){
		assertNotNull("Oggetto non istanziato" , pren );
		
		dimS1 = new boolean[][]{{true , true , true , true} , 
								{false , false , false , false},
								{true , false , true , false},
								{false , false , false , true}};
		
		s1.setPosti(dimS1);
		pren.setSala(s1);
		
		filaPosti = new int[]{0 , 0 , 0 , 0};
		colPosti = new int[]{0 , 1 , 2 , 3};
		
		pren.setFilaPosti(filaPosti);
		pren.setColPosti(colPosti);
		
		myCal.set(Calendar.YEAR, 2018);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		dataFilm = myCal.getTime(); 
		
		prog1 = new Programmazione(dataFilm , 12 , 23 , 123 , 30 , null , s1);
		
		pren.setProgrammazione(prog1); 
		
		/*
		 * la simulazione la effettuo solo con l'abbonamento , valenza identica
		 * viene data dall'ulizzo di una carta di credito
		 */
		pren.cancellaPrenotazione(cdc);
		/*
		 * Mi aspetto che dopo la cancellazione ci sia posto per 13 biglietti 
		 * che prima non c'era
		 */
		boolean postiLiberi = pren.verificaDisponibilitàPosti(4); 
		boolean expectedPostiLiberi = true;
		
		boolean temp[][] = pren.getSala().getPosti();
		for(int i = 0 ; i < temp.length ; i++){
			for(int k = 0; k< temp[i].length; k++){
				System.out.print(temp[i][k] + "\t");
			}
			System.out.println();
		}
		
		assertEquals("Non si può cancellare la prenotazione" , expectedPostiLiberi , postiLiberi);
	}
	
	@Test
	public void tCancellaPrenotazioneCdc_2nd(){
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		dataFilm = myCal.getTime(); 
		
		prog1 = new Programmazione(dataFilm , 12 , 23 , 123 , 30 , null , s1);
		
		pren.setProgrammazione(prog1);
		assertFalse("Asser error" , pren.cancellaPrenotazione(cdc));
	}
	
	@Test
	public void tPagaPrenotazioneAbb(){
		assertNotNull("Oggetto non istanziato" , pren );
		
		/*
		 * Ogni volta Reistanzio la disponibilità dei posti della sala per aver maggiore 
		 * flessibilità nell'utilizzo delle funzioni da testare
		 */
		
		dimS1 = new boolean[][]{{true , true , true , true} , 
								{false , false , false , false},
								{true , false , true , false},
								{false , false , false , true}};

		s1.setPosti(dimS1);
		pren.setSala(s1);
		
		/*
		 * creo una filaPosti e una colPosti dimensionalmente grandi come il numero di 
		 * biglietti che ho prenotato
		 */
		
		filaPosti = new int[5];
		colPosti = new int[5]; 
		
		pren.setColPosti(colPosti);
		pren.setFilaPosti(filaPosti); 
		abb = new Abbonamento();
		abb.setnBigliettiRimanenti(10);
		pren.setnBiglietti(5); 
		boolean avvenutapren = pren.pagaPrenotazione("Abbonamento", abb, cdc);
		
		System.out.println("Posti presi : ");
		
		assertTrue("Errore nel pagamento" , avvenutapren);
		
	}
	
	@Test
	public void tPagaPrenotazioneAbb_2nd(){
		assertNotNull("Oggetto non istanziato" , pren );
		
		/*
		 * Ogni volta Reistanzio la disponibilità dei posti della sala per aver maggiore 
		 * flessibilità nell'utilizzo delle funzioni da testare
		 */
		
		dimS1 = new boolean[][]{{true , true , true , true} , 
								{false , false , false , false},
								{true , false , true , false},
								{false , false , false , true}};

		s1.setPosti(dimS1);
		pren.setSala(s1);
		
		/*
		 * creo una filaPosti e una colPosti dimensionalmente grandi come il numero di 
		 * biglietti che ho prenotato
		 */
		
		filaPosti = new int[5];
		colPosti = new int[5]; 
		
		pren.setColPosti(colPosti);
		pren.setFilaPosti(filaPosti); 
		abb.setnBigliettiRimanenti(2);
		pren.setnBiglietti(6); 
		boolean avvenutapren = pren.pagaPrenotazione("Abbonamento", abb, cdc);
	
		
		System.out.println("Posti presi : ");
		
		assertFalse("Errore nel pagamento" , avvenutapren);
		
	}
	
	@Test
	public void tPagaPrenotazioneCarta(){
		dimS1 = new boolean[][]{{true , true , true , true} , 
								{false , false , false , false},
								{true , false , true , false},
								{false , false , false , true}};

		s1.setPosti(dimS1);
		pren.setSala(s1);
		
		/*
		* creo una filaPosti e una colPosti dimensionalmente grandi come il numero di 
		* biglietti che ho prenotato
		*/
		
		filaPosti = new int[5]; 
		colPosti = new int[5]; 
		
		pren.setColPosti(colPosti); 
		pren.setFilaPosti(filaPosti);
		
		pren.setnBiglietti(5); 

		cdc = new CartaDiCredito(); 
		cdc.setSaldo(10000000.43f);
		assertTrue("Error Assert" , pren.pagaPrenotazione("CartaDiCredito", abb, cdc));
		
		/*
		 * per coprire l'altra parte di funzione 
		 */
		cdc = null;
		assertFalse("ErrorAssert" , pren.pagaPrenotazione("CartaDiCredito", abb, cdc));
	}
	
	@Test
	public void tPagaPrenotazioneCarta_2nd(){
		dimS1 = new boolean[][]{{true , true , true , true} , 
								{false , false , false , false},
								{true , false , true , false},
								{false , false , false , true}};

		s1.setPosti(dimS1);
		pren.setSala(s1);
		
		/*
		* creo una filaPosti e una colPosti dimensionalmente grandi come il numero di 
		* biglietti che ho prenotato
		*/
		
		filaPosti = new int[5]; 
		colPosti = new int[5]; 
		
		pren.setColPosti(colPosti); 
		pren.setFilaPosti(filaPosti);
		
		pren.setnBiglietti(7); 
		pren.setCostoTotale(123.4f);

		cdc = new CartaDiCredito(); 
		cdc.setSaldo(2.43f);
		assertFalse("Error Assert" , pren.pagaPrenotazione("CartaDiCredito", abb, cdc));
	}
	
	@Test
	public void tPagaPrenotazioneNull(){
		dimS1 = new boolean[][]{{true , true , true , true} , 
								{false , false , false , false},
								{true , false , true , false},
								{false , false , false , true}};

		s1.setPosti(dimS1);
		pren.setSala(s1);
		
		/*
		* creo una filaPosti e una colPosti dimensionalmente grandi come il numero di 
		* biglietti che ho prenotato
		*/
		
		filaPosti = new int[5]; 
		colPosti = new int[5]; 
		
		pren.setColPosti(colPosti); 
		pren.setFilaPosti(filaPosti);
		
		pren.setnBiglietti(5); 

		cdc = null;
		abb = null;
		assertFalse("Error Assert" , pren.pagaPrenotazione("CartaDiCredito", abb, cdc));
		
	}
	
	
	@Test
	public void notSeatAvailable(){
		/*
		 * affinche possa eseguire il branch che mi indica che non ci sono posti dispobilibi 
		 * 
		 */
		dimS1 = new boolean[][]{{true , true , true , true} , 
			{false , false , false , false},
			{true , false , true , false},
			{false , false , false , true}};

		s1.setPosti(dimS1);
		pren.setSala(s1);
		
		assertFalse("AssertError" ,pren.verificaDisponibilitàPosti(10));
		
	}
	
	@Test
	public void tVisualizzaErrore(){
		pren.visualizzaErrore();
	}
	

}
