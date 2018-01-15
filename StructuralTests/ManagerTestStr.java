import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class ManagerTestStr {
	
	private static Manager manager;
	private static ArrayList<Cassiera> cassiere;
	private static Cassiera c1 , c2 , c3;
	private static Calendar myCal;
	private static Date dataAssunzione;
	private static ArrayList<Programmazione> programmazioni;
	private static Programmazione prog1 , prog2 , prog3, prog4 ,  progMod;
	private static Film f1 , f2 , f3 , f4;
	private static Sala s1 , s2;
	private static Film filmMod;
	private static Date dateF1 , dateF2 , dateF3 ,  dateF4 , dateMod;
	private static Circuito circ;
	private static ArrayList<Cinema> cinemas;
	private static Cinema cin;
	private static ArrayList<Sala> sale;
	
	
	@BeforeClass
	public static void setup(){  
		sale = new ArrayList<Sala>();
		cinemas = new ArrayList<Cinema>();
		circ = new Circuito();
		
		manager = new Manager();
		cassiere = new ArrayList<Cassiera>();
		manager.setCassiere(cassiere);
		
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dataAssunzione = myCal.getTime();
		
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 5); 
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dateF1 = myCal.getTime();
		
		myCal.set(2018, 3, 3, 14, 0);
		dateF2 = myCal.getTime();
		
		myCal.set(2016, 8, 9, 12, 30);
		dateF3 = myCal.getTime();
		
		myCal.set(2017, 4, 3 , 11 , 20);
		dateF4 = myCal.getTime();
		
		s1 = new Sala("A1", new boolean[3][3], 9, 123, programmazioni);
		sale.add(s1);
		s2 = new Sala ("B2" , new boolean[4][4], 16 , 4657 , programmazioni);
		sale.add(s2);
		
		c1 = new Cassiera(dataAssunzione , 1250 , manager, "Giorgia", "DeGiorgi", "gg@gmail.com", "giorg", 12);
		c2 = new Cassiera(dataAssunzione , 3000 , manager , "Carla" , "DeCrali" , "cc@mail.com0" , "cdc" , 24);
		c3 = new Cassiera(dataAssunzione , 3550 , manager , "Paola" , "Parodi" , "pp@mail.com0" , "pp" , 36);
		cassiere.add(c2);
		cassiere.add(c3);
		
		f1 = new Film("ciao" , "horror" , "...." , 120 , 4.5f , 7.50f ,null , null , null);
		f2 = new Film("salve" , "horror" , "...." , 120 , 4.5f , 7.50f ,null , null , null);
		f3 = new Film("Pirati dei Caruggi" , "Genovese" , "..." , 90 , 4.8f , 8.0f , null , null , null);
		f4 = new Film("Pirati dei Caraibi" , "..." , "..." , 90 , 4.8f , 8.0f , null , null , null);
		
		prog1 = new Programmazione(dateF1 , 12 , 23 , 123 , 30 , f1 , s1);
		prog2 = new Programmazione(dateF2 , 13 , 45 , 345 , 12 , f2 , s1);
		prog3 = new Programmazione(dateF3 , 14 , 20 , 347 , 18 , f3 , s2);
		prog4 = new Programmazione(dateF4 , 14 , 20 , 457 , 20 , f4 , s2);
		
		programmazioni = new ArrayList<Programmazione>();
		programmazioni.add(prog1);
		programmazioni.add(prog2);
		programmazioni.add(prog3);
		programmazioni.add(prog4);
		
		manager.setProgrammazione(programmazioni);
		manager.setCassiere(cassiere);
		
		cin = new Cinema("UCI", "Genova", "Via", programmazioni, sale);
		cinemas.add(cin);
		circ.setCinema(cinemas);
		manager.setCircuito(circ);
	}

	@Test
	public void tAggiungiCassiera() {
		assertNotNull("Manager non istanziato" , manager);
		
		boolean a = manager.aggiungiCassiera(c1);
		
		assertTrue("Branch non coperto" , a);
				
	}
	
	@Test
	public void tAggiungiCassiera_2nd(){
		// Branch con aggiunta cassiera con lo stesso id 
		Cassiera casTest = new Cassiera(dataAssunzione , 2000 , manager , "Franca" , "DeFranco" , "Franca@gmail.com" , "ff"  , 36);
		boolean a = manager.aggiungiCassiera(casTest);
		assertFalse("Branch non coperto" , a); 
	}
	
	@Test
	public void tAggiungiCassiera_3rd(){
		// Branch stesso nome , cognome e username
		Cassiera casTest = new Cassiera(dataAssunzione , 1250 , manager, "Paola", "Parodi", "gg@gmail.com", "pp", 129);
		boolean a = manager.aggiungiCassiera(casTest);
		assertFalse("Branch non coperto" , a);
	}
	
	@Test 
	public void tAggiungiassiera_4th(){
		// Branch con uno dei campi non validi 
		Cassiera casTest = new Cassiera(dataAssunzione , 2000 , manager , "" , "DeFranco" , "Franca@gmail.com" , ""  , 12);
		boolean a = manager.aggiungiCassiera(casTest);
		assertFalse("Branch non coperto" , a);
	}

	@Test
	public void tRimuoviCassiera(){
		assertNotNull("Manager non istanziato" , manager);
		
		boolean a = manager.eliminaCassiera(24);
		
		assertTrue("Branch non ricoperto" , a);
	}
	
	@Test
	public void tRimuoviCassiera_2nd(){
		// Rimozione di una cassiera non esistente
		boolean a = manager.eliminaCassiera(76859);
		assertFalse("Branch non ricoperto" , a);
	}
	
	
	
	
	@Test
	public void tModificaProgrammazione_2nd(){
		//Branch non trovo il cinema 
		Cinema cinTest = new Cinema("Gold" , "Milano" , "Via Bari" , null , null);
		progMod = new Programmazione(dateMod , 16 , 24 , 123 , 30 , f1 , s1);
		boolean result = manager.modificaProgrammazione(progMod , cinTest);
		assertFalse("Branch non ricoperto" , result);
	}
	
	@Test
	public void tModificaProgrammazione_3rd(){
		// Branch sovrapposizione programmazione esistente 
		progMod = new Programmazione(dateF1 , 12 , 23 , 123 , 30 , f1 , s1);
		boolean a = manager.modificaProgrammazione(progMod, cin);
		assertFalse("Branch non ricoperto" , a);
	}
	
	@Test
	public void tModificaProgrammazione_4th(){
		// Branch con modifica a un giorno successivo 
		myCal.set(2018, 10, 12, 20, 30);
		Date dateTemp = myCal.getTime(); 
		progMod = new Programmazione(dateTemp , 19 , 23 , 3457 , 10 , f2 , s1);
		boolean a = manager.modificaProgrammazione(progMod,  cin);   
		assertTrue("Branch non ricoperto" , a);   
	} 
	
	@Test 
	public void tModificaProgrammazione(){
		// Branch di modifica anticipando lo spettacolo 
		progMod = new Programmazione(dateF1 , 6 , 23 , 123 , 30 , f1 , s1);
		boolean a = manager.modificaProgrammazione(progMod,  cin);
		assertFalse("Branch non ricoperto" , a);  
	} 
	
	@Test
	public void tModificaFilm(){
		filmMod = new Film("ciao" , "avventura" , "Un gruppo di amici .." , 120 , 4.5f , 7.50f ,null , null , null);
		
		boolean result = manager.modificaFilm(filmMod);
		
		assertTrue("Branch non ricoperto" , result );		
	}
	
	@Test
	public void tModificaFilm_2nd(){
		// Branch non esiste il film 
		filmMod = new Film("La discesa" , "boh" , "degli amici .." , 120 , 4.5f , 7.50f ,null , null , null);
		
		assertFalse("Error Assert " , manager.modificaFilm(filmMod));
	}
	
	@Test
	public void tAggiungiFilm(){
		filmMod = new Film("hello" , "space" , "Ciao a tutti" , 90 , 4.5f , 7.50f ,null , null , null);
		progMod = new Programmazione(dateF1 , 6 , 23 , 123 , 30 , filmMod , s1);
		boolean a = manager.aggiungiFilm(filmMod, progMod, cin);
		assertTrue("Film non aggiunto" , a);	
	}
	
	@Test
	public void tAggiungiFilm_2nd(){
		//Branch di aggiunta film già esistente
		progMod = new Programmazione(dateF1 , 6 , 23 , 123 , 30 , f1 , s1);
		boolean a = manager.aggiungiFilm(f1, progMod, cin);
		assertFalse("Film non aggiunto" , a);
	}
	
	@Test
	public void tEliminaFilm(){
		String title = "ciao";
		
		boolean a = manager.eliminaFilm(title); 
		
		assertNotEquals("Film non aggiunto" , a );
	}
	
	@Test
	public void tEliminaFilm_2nd(){
		//Branch in cui non ci sono film da eliminare
		String title = "Walle";
		
		boolean a = manager.eliminaFilm(title);
		
		assertNotEquals("Film non aggiunto" , a );
	}
	
	@Test
	public void tVisualizzaCassiere(){
		manager.visualizzaCassiere();
	}
	
	@Test
	public void tProgram(){
		assertEquals("" , programmazioni , manager.getProgrammazione());
	}
	
	@Test
	public void tCassiere(){
		assertEquals("" , cassiere , manager.getCassiere());
	}
	
	@Test
	public void tCircuito(){
		assertEquals("" , circ , manager.getCircuito());
	}
	
	
	
}
