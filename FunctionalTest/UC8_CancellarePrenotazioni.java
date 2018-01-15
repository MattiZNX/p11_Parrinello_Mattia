import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC8_CancellarePrenotazioni {

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
		myCal.set(Calendar.YEAR, 2018);
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
		
		prog1 = new Programmazione(dataFilm , 12 , 23 , 123 , 30 , null , s1);
		
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
		
		
	}
	
	@Test
	public void CancellarePrenotazione(){
		/*
		 * questo use case comprende le specifiche anche dello use case 9B ,pagamento con carta di credito
		 */
		assertNotNull("Oggetto non istanziato" , pren );
		
		cdc = new CartaDiCredito();
		cdc.setSaldo(10000000.43f);
		
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
		
		/*
		 * la simulazione la effettuo solo con l'abbonamento , valenza identica
		 * viene data dall'ulizzo di una carta di credito
		 */
		boolean ris = pren.cancellaPrenotazione(cdc);
		assertEquals("Errore Use Case" , ris , true);
	}
	
	@Test
	public void CancellarePrenotazione_6A(){
		
		cdc = new CartaDiCredito();
		cdc.setSaldo(10000000.43f);
		/*
		 * impostazione di una data ben oltre la data odierna per non consentire la cancellazione mettendo 
		 * la data di un anno fa 
		 */
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		dataFilm = myCal.getTime();
		prog1 = new Programmazione(dataFilm , 12 , 23 , 123 , 30 , null , s1);
		pren.setProgrammazione(prog1);
		boolean ris = pren.cancellaPrenotazione(cdc);
		assertEquals("Errore Use Case" , ris , false);
		
	}
	
	@Test
	public void CancellarePrenotazione_9A(){
		abb = new Abbonamento();
		
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
		
		/*
		 * considero il caso in cui sia possibile cancellare la prenotazione quinid 
		 * cambio l'orario del film con uno piu congegnale al risarcimento 
		 */
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2018);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		dataFilm = myCal.getTime();
		prog1.setGiorno(dataFilm);
		pren.setProgrammazione(prog1);
		/*
		* la simulazione la effettuo con l'abbonamento , valenza identica
		* viene data dall'ulizzo di una carta di credito
		*/
		boolean ris = pren.cancellaPrenotazione(abb);
		assertTrue("Errore Use Case" , ris );
	}
	
	@Test
	public void CancellarePrenotazione_9B(){
		cdc = new CartaDiCredito();
		
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
		
		/*
		 * considero il caso in cui sia possibile cancellare la prenotazione quinid 
		 * cambio l'orario del film con uno piu congegnale al risarcimento 
		 */
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2018);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 27);
		dataFilm = myCal.getTime();
		prog1.setGiorno(dataFilm);
		pren.setProgrammazione(prog1);
		
		boolean ris = pren.cancellaPrenotazione(cdc);
		assertTrue("Errore Use Case" , ris );
	} 
	
	
	
	

}
