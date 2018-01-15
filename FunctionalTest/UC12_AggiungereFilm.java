import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC12_AggiungereFilm {

	private static Manager man;
	private static Film film;
	private static Film filmdoppio;
	private static Film film2 , film3;
	private static Date dI;
	private static Date dF;
	private static ArrayList<Programmazione> pp;
	private static Programmazione programmazione;
	private static Sala s1;
	private static Cinema c1;
	private static ArrayList<Sala> ss;
	private static boolean a;
	
	@BeforeClass
	public static void setup(){
		man = new Manager();
		pp = new ArrayList<Programmazione>();
		ss = new ArrayList<Sala>();
		
		programmazione = new Programmazione();
		c1 = new Cinema("UCI", "Genova", "Via Fiumara", pp, ss);
		man.setProgrammazione(pp);
		
		
		
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2014);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dI = myCal.getTime();
		// vengono inpostati i parametri dei film 
		myCal.set(Calendar.YEAR, 2018);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dF = myCal.getTime();
		film3 = new Film("Minions", "Fantasy", "...", 120, 3, 8, dI, dF, null);
		
		if (man.aggiungiFilm(film3, programmazione , c1)){
			programmazione.setGiorno(dI);
			programmazione.setIdProgramazione(123);
			programmazione.setMinuti(30);
			programmazione.setOra(15);
			programmazione.setPostiDisponibili(36);
			s1 = new Sala("S1", new boolean [6][6], 36, 453, pp);
			c1.aggiungiSala(s1);
			programmazione.setSala(s1);
		}
		c1.aggiungiProgrammazione(programmazione);
	}

	@Test
	public void AggiungereNuovoFilm(){
		
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dI = myCal.getTime();
		// vengono inpostati i parametri dei film 
		myCal.set(Calendar.YEAR, 2019);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dF = myCal.getTime();
		film = new Film("Apocalypto", "Horror", "Tanto Tempo Fa ...", 120, 3, 8, dI, dF, null);
		
		man.aggiungiFilm(film, programmazione , c1);
		
		programmazione.setGiorno(dI); 
		programmazione.setIdProgramazione(123);
		programmazione.setMinuti(30);
		programmazione.setOra(15);
		programmazione.setPostiDisponibili(36);
		s1 = new Sala("S1", new boolean [6][6], 36, 453, pp);
		c1.aggiungiSala(s1);
		programmazione.setSala(s1);
		
		c1.aggiungiProgrammazione(programmazione);
		
		System.out.println("Programmazione aggiunta! \n Numero : " + programmazione.getIdProgramazione() + " \n Film : " + programmazione.getFilm().getTitolo());
	}
	
	@Test
	public void AggiungiNuovoFilm_4A(){
		
		filmdoppio = new Film("Minions", "Fantasy", "...", 120, 3, 8, dI, dF, null);
		
		assertFalse("Use case non coperto " , man.aggiungiFilm(filmdoppio, programmazione , c1));
	}
	
	@Test 
	public void AggiungiNuovoFilm_6A(){
		
		film2 = new Film("Gifted", "Fantascienza", "Forse ...", 60, 4, 9, dI, dF, null);
		programmazione.setGiorno(dI);
		programmazione.setIdProgramazione(123);
		programmazione.setMinuti(30);
		programmazione.setOra(15);
		programmazione.setPostiDisponibili(36);
		s1 = new Sala("S1", new boolean [6][6], 36, 453, pp);
		c1.aggiungiSala(s1);
		programmazione.setSala(s1);
		a = c1.aggiungiProgrammazione(programmazione);
		assertFalse("Use Case non coperto" , a);
		
	}
	
	
}
