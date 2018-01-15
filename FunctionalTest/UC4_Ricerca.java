import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC4_Ricerca {

	private static Cinema uci , thespace;
	private static Film f1 , f2 , f3 , f4 , f5;
	private static Date dif1 , dif2 , dif3 , dif4 , dif5 , dff1 , dff2 , dff3 , dff4 , dff5 , today;
	private static Sala s1 , s2 , s3;
	private static Programmazione prog1 , prog2 , prog3 , prog4 , prog5 , prog6;
	private static Calendar myCal;
	private static Cliente client;
	private static ArrayList<Cinema> cinemas;
	
	
	@BeforeClass
	public static void setup(){
		
		ArrayList<Programmazione> programmazioniUCI = new ArrayList<Programmazione>();
		ArrayList<Programmazione> programmazioniTheSpace =  new ArrayList<Programmazione>();
		ArrayList<Sala> saleUCI = new ArrayList<Sala>();
		ArrayList<Sala> saleTheSpace = new ArrayList<Sala>();
		
		cinemas = new ArrayList<Cinema>();
		myCal = Calendar.getInstance();
		myCal.set(2017, 8, 8);
		today = myCal.getTime(); 
		
		// Film 1 : Thor 2/8/2016 3/9/2018 120' 8€ 4 S1 '' 8/8/2017 13:00
		myCal.set(2016 , 8 , 2);
		dif1 = myCal.getTime();
		myCal.set(2018, 9, 3);
		dff1 = myCal.getTime();
		s1 = new Sala("S1" , new boolean[3][3] , 9 , 12 , null);
		f1 =  new Film("Thor" , "Hero" , "..." , 120 , 8 , 4 , dif1 , dff1, null);
		prog1 = new Programmazione(today , 13 , 0 , 123 , 9 , f1, s1);
		
		// Film 2 : Spiderman 1/1/2015 1/1/2018 60' 6€ 3 '' 8/8/2017 14:00
		myCal.set(2015 , 1 , 1);
		dif2 = myCal.getTime();
		myCal.set(2018, 1 , 1);
		dff2 = myCal.getTime();
		s2 = new Sala("S2" , new boolean[4][4] , 16 , 124 , null);
		f2 =  new Film("Spiderman" , "Hero" , "..." , 60 , 6 , 3 , dif2 , dff2, null);
		prog2 = new Programmazione(today , 15 , 0 , 1253 , 10 , f2, s2);
		
		// Film 3 : Minion 2/4/2016 5/7/2018 100' 7€ 2 '' S3 8/8/2017 15:00
		myCal.set(2016 , 4 , 2);
		dif3 = myCal.getTime();
		myCal.set(2018, 9, 3);
		dff3 = myCal.getTime();
		s3 = new Sala("S3" , new boolean[3][3] , 9 , 1562 , null);
		f3 =  new Film("Minion" , "Fantasy" , "..." , 120 , 9 , 4 , dif3 , dff3, null);
		prog3 = new Programmazione(today , 16 , 0 , 12763 , 9 , f3, s3);
		
		saleUCI.add(s1);
		saleUCI.add(s2);
		saleUCI.add(s3);
		
		programmazioniUCI.add(prog1);
		programmazioniUCI.add(prog2);
		programmazioniUCI.add(prog3);
		
		uci = new Cinema("UCI" , "Genova" , "Via XX" , programmazioniUCI , saleUCI);
		
		// The Space
		// Film 1 : Film 1 : Thor 2/8/2016 3/9/2018 120' 8€ 4 S1 8/8/2017 '' 10:00
		prog4 = new Programmazione(dif1 , 10 , 0 , 123 , 9 , f1, s1);
		
		// Film 2 : IronMan 2/2/2016 6/6/2018 100' 6€ 5 '' S2 8/8/2017 10:00
		myCal.set(2016 , 8 , 6);
		dif4 = myCal.getTime();
		myCal.set(2018, 6, 6);
		dff4 = myCal.getTime();
		f4 = new Film("IronMan" , "Hero" , "..." , 100 , 8 , 5 , dif4 , dff4 , null);
		prog5 = new Programmazione(today , 8 , 0 , 4578 , 6 , f4 , s2);
		
		// Film 3 : Avengers 1/8/2016 3/9/2018 90' 9€ 4 '' S3 8/8/2017 17:00
		myCal.set(2016, 8, 1);
		dif5 = myCal.getTime();
		myCal.set(2018, 9, 3);
		dff5 = myCal.getTime();
		f5 = new Film("Avengers" , "Hero" , "..." , 120 , 9 , 4 , dif5 , dff5 , null);
		prog6 = new Programmazione(today , 17 , 0 , 3675 , 4 , f5 , s3);
		
		saleTheSpace = saleUCI;
		programmazioniTheSpace.add(prog4);
		programmazioniTheSpace.add(prog5);
		programmazioniTheSpace.add(prog6);
		
		thespace = new Cinema("TheSpace" , "Milano" , "Via Napoleone" , programmazioniTheSpace , saleTheSpace); 
		
		cinemas.add(uci);
		cinemas.add(thespace);
		
		// Setup Utente 
		client = new Cliente(); 
						
	}
	
	@Test 
	public void Ricerca(){
		// Test Ricerca per Città , ci si aspetta che la lista contenga 3 programmazioni
		ArrayList<Programmazione> result = new ArrayList<Programmazione>();
		result = client.ricercaPerCittà(cinemas, "Genova", today);
		assertEquals("Caso d'uso non ricoperto" , result.size() , 3);
	}
	
	@Test
	public void Ricerca_3A(){
		ArrayList<Programmazione> result = new ArrayList<Programmazione>();
		result = client.ricercaPerCittà(cinemas, "Firenze", today);
		assertEquals("Caso d'uso non ricoperto" , result.size() , 0);
	}

}
