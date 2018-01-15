import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteTestsStr {

	private static Cinema cinema = null;
	private static Cliente c = null;
	private static CartaDiCredito cdc = null;
	private static Calendar myCal = null;
	private static Date theDate = null;
	private static ArrayList<Cinema> cinemas = null;
	private static ArrayList<Programmazione> programmazioni = null;
	private static ArrayList<Sala> sale = null;
	private static Sala s1 = null;
	private static Sala s2 = null; 
	private static Programmazione prog1;
	private static Programmazione prog2;
	private static Film f1;
	private static Film f2;
	private static  boolean[][] dimS1;
	private static  boolean[][] dimS2;
	private static ArrayList<Programmazione> tempProg = null;
	private static ArrayList<Prenotazione> prenotazioni = null; 
	private static Abbonamento abb = null;
	private static Abbonamento abbcliente = null; 
	
	@BeforeClass
	public static void setup(){
		c = new Cliente();
		abbcliente = new Abbonamento();
		abbcliente.setCosto(5.50f);
		abbcliente.setnBigliettiRimanenti(15);
		abbcliente.setTipo("Carnet");
		abbcliente.setCliente(c);
		abb = new Abbonamento(); 
		abb.setCosto(15.50f);
		abb.setnBigliettiRimanenti(10);
		abb.setTipo("Carnet");
		abb.setCliente(c);
		cdc = new CartaDiCredito();
		cdc.setSaldo(120f);
		cdc.setnCarta("123456");
		c.setAbbonamento(abbcliente);
		c.setCartaDiCredito(cdc); 
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2013);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 2);
		theDate = myCal.getTime();
		
		prenotazioni = new ArrayList<Prenotazione>();
		c.setPrenotazioni(prenotazioni);
		
		cinemas = new ArrayList<Cinema>();
		sale = new ArrayList<Sala>();
		programmazioni = new ArrayList<Programmazione>();
		
		dimS1 = new boolean[4][4];
		dimS2 = new boolean[3][5];
		/*
		 * preparazione delle sale 
		 */
		s1 = new Sala("A1" , dimS1 , 16 , 123 , null);
		s2 = new Sala("B4" , dimS2 , 15 , 2345 , null);
		
		f1 = new Film("ciao" , "horror" , "...." , 120 , 4.5f , 7.50f ,null , null , null);
		f2 = new Film("salve" , "horror" , "...." , 120 , 4.5f , 7.50f ,null , null , null);
		
		prog1 = new Programmazione(theDate , 12 , 23 , 123 , 30 , f1, s1);
		prog2 = new Programmazione(theDate , 13 , 45 , 345 , 12 , f2 , s1);
		
		sale.add(s1);
		sale.add(s2);
		programmazioni.add(prog1);
		programmazioni.add(prog2);
		
		cinema = new Cinema("UCI" , "Genova" , "Via Marco" , programmazioni , sale);
		cinemas.add(cinema);
		
		
	}
	
	@Test
	public void tRicercaPerCinema() {
		assertNotNull("Nessuna ListaCinema" , cinemas);
		tempProg = new ArrayList<Programmazione>();
		tempProg = c.ricercaPerCinema(cinemas, "Genova", theDate, "UCI");
		
		int tempProgSize = tempProg.size();
		int expectedResult = 0;
		System.out.println("Programmazioni Trovate : "+ tempProgSize);
		 
		assertTrue("Ricerca non andata a buon fine" , tempProgSize > expectedResult);
		
	}
	
	@Test
	public void tRicercaPerCittà(){
		assertNotNull("Nessuna ListaCinema" , cinemas);
		tempProg = new ArrayList<Programmazione>();
		tempProg = c.ricercaPerCittà(cinemas, "Genova", theDate);
		
		int tempProgSize = tempProg.size();
		int expectedResult = 0;
		System.out.println("Programmazioni Trovate : " + tempProgSize);
		
		assertTrue("Ricerca non andata a buon fine" , tempProgSize > expectedResult);
	}
	
	@Test
	public void tRicercaPerFilm(){
		assertNotNull("Nessuna ListaCinema" , cinemas);
		tempProg = new ArrayList<Programmazione>();
		tempProg = c.ricercaPerFilm(cinemas, "Genova", theDate, "UCI", "ciao");
	
		int tempProgSize = tempProg.size();
		int expectedResult = 0;
		System.out.println("Programmazioni Trovate : " + tempProgSize);
		
		assertTrue("Ricerca non andata a buon fine" , tempProgSize > expectedResult);
	}
	
	@Test
	public void tAcquistaAbbonamento(){
		assertNotNull("Cliente non istanziato" , c);
		int bigliettiPrima = c.getAbbonamento().getnBigliettiRimanenti();
		System.out.println("Prima : " + c.getAbbonamento().getnBigliettiRimanenti());
		c.acquistaAbbonamento(abb);
		int bigliettiDopo = c.getAbbonamento().getnBigliettiRimanenti();
		System.out.println("Dopo : " + c.getAbbonamento().getnBigliettiRimanenti());
		boolean a = bigliettiPrima < bigliettiDopo;
		assertTrue("Abbonamento non andato a buon fine " , a);   
		
	}
	
	@Test
	public void tPrenotaBiglietto(){
		assertNotNull("Cliente non istanziato" , c);
		boolean a = c.prenotaBiglietto(prog1);
		assertTrue("Branch non coperto" , a);
	}
	
	@Test
	public void tCarta(){
		assertEquals("" , cdc , c.getCartaDiCredito());
	}
	
	@Test
	public void tpren(){
		assertEquals("" , prenotazioni , c.getPrenotazioni());
	}
	
}
