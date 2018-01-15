import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC6_ScrivereRecensioni {

	private static Recensione rec = null;
	private static Film f1;
	private static ArrayList<Recensione> recs;
	private static Date d1;
	
	@BeforeClass
	public static void setup(){
		
		Calendar mycal = Calendar.getInstance();
		d1 = mycal.getTime();
		
		rec = new Recensione();
		recs = new ArrayList<Recensione>();
		f1 = new Film("Cenerentola", "Fantasy", "....", 60, 5, 4, d1, d1, recs);
	}

	@Test
	public void ScrivereRecensione(){
		/*
		 * Recensione Corretta
		 */
		rec.setCommento("Bello"); 
		rec.setVoto(5);
		boolean result = rec.isValid();
		boolean expectedResult = true;
		recs.add(rec);
		assertEquals("Errore caricamento recensione" , result , expectedResult);
	}
	
	@Test
	public void ScrivereRecensione_4A(){
		/*
		 * Manca il voto
		 */
		rec = new Recensione();
		rec.setCommento("Bello");
		rec.setVoto(0); // simulazione voto non inserito 
		boolean result = rec.isValid();
		boolean expectedResult = false;
		
		assertEquals("Errore use case 4A" , result , expectedResult);
		
	}
	
	@Test
	public void ScrivereRecensione_4B(){
		/*
		 * Commento non valido 
		 */
		rec = new Recensione();
		rec.setCommento(null);
		rec.setVoto(3);
		if(!rec.isValid()){
			/*
			 * Si entra nel caso in cui commento sia null ma ci sia il voto,
			 *  simulo l'inserimento di un nuovo commento 
			 */
			rec.setCommento("Wow");
			
		}
		boolean result = rec.isValid();
		boolean expectedResult = true;
		recs.add(rec);
		f1.displayInfoFilm();
		assertEquals("Errore use case 4B" , result , expectedResult);
	}
	

	
	
}
