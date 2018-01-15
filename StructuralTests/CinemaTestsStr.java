import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class CinemaTestsStr {

	private static Cinema cinema = null;
	private static ArrayList<Sala> sale = null;
	private static ArrayList<Programmazione> programmazioni = null;
	private static Sala s1;
	private static Sala s2;
	private static Sala s3;
	private static Programmazione prog1 , prog2;
	private static Programmazione progTest;
	private static Film f1;
	private static Film f2;
	private static Date di1, df1;
	private static  boolean[][] dimS1;
	private static  boolean[][] dimS2;
	
	@BeforeClass
	public static void setup(){
		
		Calendar mycal = Calendar.getInstance();
		mycal.set(2017, 2, 22, 18, 0);
		di1 = mycal.getTime();
		mycal.set(2018, 3, 20, 15, 0);
		df1 = mycal.getTime();
			
		sale = new ArrayList<Sala>();
		programmazioni = new ArrayList<Programmazione>();
		
		dimS1 = new boolean[4][4];
		dimS2 = new boolean[3][5];
		
		s1 = new Sala("A1" , dimS1 , 16 , 123 , null);
		s2 = new Sala("B4" , dimS2 , 15 , 2345 , null);
		s3 = new Sala("C3" , dimS1 , 16 , 3456, null);
		
		f1 = new Film("ciao" , "horror" , "...." , 120 , 4.5f , 7.50f ,di1 , df1 , null);
		f2 = new Film("salve" , "horror" , "...." , 120 , 4.5f , 7.50f ,di1 , df1 , null);
		
		prog1 = new Programmazione(di1 , 12 , 23 , 123 , 30 , f1 , s1);
		prog2 = new Programmazione(di1 , 13 , 45 , 345 , 12 , f2 , s2);
		
		sale.add(s1);
		sale.add(s3);
		programmazioni.add(prog1);
		
		cinema = new Cinema("UCI" , "Genova" , "Via " , programmazioni , sale);
		
		
	}
	
	@Test
	public void tAggiungiSala() {
		assertNotNull("Cinema non istanziato" , cinema);
		
		boolean a = cinema.aggiungiSala(s2);
		
		assertTrue("Branch non coperto" , a );
	}
	
	@Test 
	public void tAggiungiSala_2nd(){
		Sala s4 = new Sala("C3" , dimS1, 16 , 3456, null);
		boolean a = cinema.aggiungiSala(s4);
		assertFalse("Branch non coperto " , a );
	}
	
	@Test
	public void tRimuoviSala(){
		assertNotNull("Cinema non istanziato" , cinema);
		
		boolean a = cinema.rimuoviSala(123);
				
		assertTrue("Branch non coperto" , a);
		
	}
	
	@Test
	public void tRimuoviSala_2nd(){
		assertNotNull("Cinema non istanziato" , cinema);
		
		boolean a = cinema.rimuoviSala(254674);
				
		assertFalse("Branch non coperto" , a);
	}
	
	@Test
	public void tAggiungiProgrammazione(){
		assertNotNull("Cinema non istanziato" , cinema);
		
		boolean a = cinema.aggiungiProgrammazione(prog2);
				
		assertTrue("Branch non coperto", a);
	}
	
	@Test
	public void tAggiungiProgrammazione_2nd(){
		assertNotNull("Cinema non istanziato" , cinema);
		progTest = new Programmazione(di1 , 13 , 45 , 345 , 12 , f2 , s2);
		boolean a = cinema.aggiungiProgrammazione(progTest);
				
		assertFalse("Branch non coperto", a);
	}
	
	@Test
	public void tRimuoviProgrammazione(){
		assertNotNull("Cinema non istanziato" , cinema);
		
		boolean a = cinema.rimuoviProgrammazione(123); 
			
		assertTrue("Branch non coperto", a);
	}
	
	@Test
	public void tRimuoviProgrammazione_2nd(){
		assertNotNull("Cinema non istanziato" , cinema);
		
		boolean a = cinema.rimuoviProgrammazione(8796); 
			
		assertFalse("Branch non coperto", a);
	}
	
	@Test 
	public void isSovrapposto(){
		// F1 viene messo in un altra sala 
		progTest = new Programmazione(di1 , 18 , 0 , 345 , 12 , f1 , s2);
		boolean a = cinema.isSovrapposto(progTest);
		assertFalse("Branch non coperto" , a);
	}
	
	@Test 
	public void isSovrapposto_2nd(){
		// F1 viene messo in un altra sala 
		progTest = new Programmazione(di1 , 12 , 23 , 123 , 30 , f1 , s1);
		boolean a = cinema.isSovrapposto(progTest);
		assertTrue("Branch non coperto" , a);
	}
	
	@Test
	public void tNome(){
		cinema.setNome("UCI");
		assertEquals("test getters/setters" , "UCI" , cinema.getNome());
	}
	
	@Test
	public void tCitta(){
		cinema.setCitta("Genova"); 
		assertEquals("test getters/setters" , "Genova" , cinema.getCitta());
	}
	
	@Test
	public void tIndirizzo(){
		cinema.setIndirizzo("Via "); 
		assertEquals("test getters/setters" , "Via " , cinema.getIndirizzo());
	}
	
	@Test
	public void tSale(){
		cinema.setSale(sale);
		assertEquals("test getters/setters" , sale , cinema.getSale());
	}
	
	@Test
	public void tProgrammazioni(){
		cinema.setProgrammazione(programmazioni);
		assertEquals("test getters/setters" , programmazioni , cinema.getProgrammazione());
	}
	


}
