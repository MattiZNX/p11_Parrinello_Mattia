import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class FilmTestsStr {
	
	private static Film film = null;
	private static ArrayList<Recensione> recensioni = null;
	private static Calendar myCal = null;
	private static Date dInizio = null;
	private static Date dFine = null;	
	
	@BeforeClass
	public static void setup(){
		recensioni = new ArrayList<Recensione>();
		Recensione r1 = new Recensione();
		r1.setCommento("Bello");
		r1.setVoto(4);
		recensioni.add(r1);
		
		Recensione r2 = new Recensione();
		r2.setCommento("WOW");
		r2.setVoto(5);
		recensioni.add(r2);
				
		film = new Film("Pirati dei Caraibi" , "Avventura" , "Jack Sparrow .... " ,  200 , 4.5f , 8.00f , dInizio , dFine , recensioni );
	}

	@Test
	public void tAggiungiRecensione() {
		assertNotNull("Film non istanziato" , film);
		 
		film.aggiungiRecensione("Non male", 3);
		
		int recSize = film.getRecensioni().size();
		int expectedResult = 3;
		
		assertEquals("Recensione non aggiunta" , expectedResult , recSize);
	}
	
	@Test
	public void tIsOutOfDate(){
		assertNotNull("Film non istanziato" , film);
		
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dInizio = myCal.getTime();
		
		myCal.set(Calendar.YEAR, 2018);
		myCal.set(Calendar.MONTH, 9);
		myCal.set(Calendar.DAY_OF_MONTH, 3);
		dFine = myCal.getTime();
		
		film.setDataInizio(dInizio);
		film.setDataFine(dFine);
		
		boolean isOut = film.isOutOfDate();
		System.out.println("Inizio : " + dInizio.toString());
		System.out.println("Fine : " + dFine.toString());
		/*
		 * rispetto alla data di oggi ci aspettiamo che il film sia effettivamente 
		 * fuori produzione , di un anno 
		 */
		assertTrue("Film non più proiettabile" , isOut);
	}
	
	@Test
	public void tIsOutOfDate_2nd(){
		
		
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2015);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dInizio = myCal.getTime();
		
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 9);
		myCal.set(Calendar.DAY_OF_MONTH, 3);
		dFine = myCal.getTime();
		
		film.setDataInizio(dInizio);
		film.setDataFine(dFine);
		System.out.println("\n Data Inizio : " + dInizio.toString() + "\n Data Fine : " + dFine.toString());
		boolean isOut = film.isOutOfDate();
		
		assertFalse("Film non più proiettabile" , isOut);
	}
	
	@Test
	public void tDisplayInfoFilm(){
		/*
		 * Solo test visivo poichè non present valori di ritorno 
		 */
		Calendar mycal = Calendar.getInstance();
		mycal.set(2016, 4, 4, 12, 30);
		Date di = mycal.getTime();
		mycal.set(2018, 3, 12, 13, 0 );
		Date df = mycal.getTime();
		
		film.setDataInizio(di);
		film.setDataFine(df);
		film.displayInfoFilm();
	}
	
	
	
	@Test
	public void tprezzo(){
		film.setPrezzo(8.00f);
		assertEquals("" , 8.00f , film.getPrezzo() , 0);
	}
	
	@Test
	public void tCategoria(){
		film.setCategoria("Avventura");
		assertEquals("" , "Avventura" , film.getCategoria());
	}
	
	@Test
	public void tTitolo(){
		film.setTitolo("Pirati dei Caraibi");
		assertEquals("" , "Pirati dei Caraibi" , film.getTitolo());
	}
	
	@Test
	public void tRecensioni(){
		film.setRecensioni(recensioni);
		assertEquals("" , recensioni , film.getRecensioni());
	}

}
