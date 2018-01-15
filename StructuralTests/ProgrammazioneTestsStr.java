import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProgrammazioneTestsStr {
	
	private static Programmazione prog1;
	private static Film f1;
	private static Calendar myCal;
	private static Date data;
	private static Date dataNew; 
	private static Sala s1;
	
	@BeforeClass
	public static void setup(){

		s1 = new Sala("A1", new boolean[3][3] , 9 ,  1584 ,null);
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2013);
		myCal.set(Calendar.MONTH, 5); 
		myCal.set(Calendar.DAY_OF_MONTH, 2);
		data = myCal.getTime();
		
		f1 = new Film("ciao" , "horror" , "...." , 120 , 4.5f , 7.50f ,null , null , null);
		prog1 = new Programmazione(data , 12 , 23 , 123 , 30 , f1 , s1);
		
		prog1.setPostiDisponibili(24);
	}

	@Test
	public void tUpdatePosti() {
		assertNotNull("Oggetto programmazione non creato " , prog1);
		
		
		prog1.updatePostiDisponibili(6);
		int postiDisponibili = prog1.getPostiDisponibili();
		int expectedResult = 30;
		
		assertEquals("Non è stato possibile aggiornare i posti" , postiDisponibili , expectedResult);
		
	}
	
	@Test
	public void tCambiaOrari(){
		
		myCal.set(Calendar.YEAR, 2013); 
		myCal.set(Calendar.MONTH, 6); 
		myCal.set(Calendar.DAY_OF_MONTH, 18);
		dataNew = myCal.getTime();
		
		boolean result = prog1.cambiaOrari(dataNew, 11, 23);
				
		assertTrue("Non è stato possibile cambiare orario" , result);
				
	}
	
	@Test 
	public void tCambiaOrari_2nd(){
		// Branch non è possibile non modificare orari
		myCal.set(Calendar.YEAR, 2012);
		myCal.set(Calendar.MONTH, 6);
		myCal.set(Calendar.DAY_OF_MONTH, 18);
		dataNew = myCal.getTime();
		
		assertFalse("Assert Error" , prog1.cambiaOrari(dataNew, 3, 20));
	}
	
	@Test
	public void tCostrprog(){
		Programmazione ppppp = new Programmazione();
	}
	
	@Test
	public void tOra(){
		prog1.setOra(12);
		assertEquals("" , 12 , prog1.getOra());
	}
	
	@Test
	public void tMinuti(){
		prog1.setMinuti(23);
		assertEquals("" , 23 , prog1.getMinuti());
	}

	@Test
	public void tIdProg(){
		prog1.setIdProgramazione(123);
		assertEquals("" , 123 , prog1.getIdProgramazione());
	}
	
	@Test
	public void tFilm(){
		prog1.setFilm(f1);
		assertEquals("" , f1 , prog1.getFilm());
	}
	
	@Test
	public void tSala(){
		prog1.setSala(s1);
		assertEquals("" , s1 , prog1.getSala());
	}
}
