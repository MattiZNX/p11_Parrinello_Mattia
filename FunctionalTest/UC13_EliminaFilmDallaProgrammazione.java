import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC13_EliminaFilmDallaProgrammazione {

	private static Manager man;
	private static Film film;
	private static Film filmdoppio;
	private static Film film2;
	private static Date dI;
	private static Date dF;
	private static ArrayList<Programmazione> pp;
	private static Programmazione programmazione , programmazione2;
	private static Sala s1 , s2;
	private static Cinema c1;
	private static ArrayList<Sala> ss;
	private static boolean conferma , risul;
	private static Circuito circ;
	private static ArrayList<Cinema> cins;
	
	@BeforeClass
	public static void setup(){
		man = new Manager();
		pp = new ArrayList<Programmazione>();
		ss = new ArrayList<Sala>();
		cins = new ArrayList<Cinema>();
		circ = new Circuito();
		
		
		programmazione = new Programmazione();
		c1 = new Cinema("UCI", "Genova", "Via Fiumara", pp, ss);
		cins.add(c1);
		
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2014);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dI = myCal.getTime();
		// vengono inpostati i parametri dei film 
		myCal.set(Calendar.YEAR, 2016);
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
	
		pp.add(programmazione);
		
		// vengono istanziate 2 programmazioni di due film diversi 
		
		programmazione2 = new Programmazione();
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 4);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dI = myCal.getTime();
		// vengono impostati i parametri dei film 
		myCal.set(Calendar.YEAR, 2019);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dF = myCal.getTime();
		film = new Film("Pirati dei caraibi", "Fantasy", "Tanto Tempo Fa ...", 120, 3, 8, dI, dF, null);
		man.aggiungiFilm(film, programmazione2 , c1) ;
		programmazione2.setGiorno(dI);
		programmazione2.setIdProgramazione(123);
		programmazione2.setMinuti(30);
		programmazione2.setOra(15);
		programmazione2.setPostiDisponibili(36);
		s2 = new Sala("S2", new boolean [6][6], 36, 453, pp);
		c1.aggiungiSala(s2);
		programmazione2.setSala(s2);
		
		pp.add(programmazione2);
		
		man.setProgrammazione(pp);
		circ.setCinema(cins);
		man.setCircuito(circ);
		
	}
	
	@Test
	public void RimuoviFilm() {
		// selezionato il film , ne passo il titolo da eliminare
		String titoloDaElimin = "Apocalypto";
		risul = man.eliminaFilm(titoloDaElimin);
		assertTrue("Caso d'uso non ricoperto " , risul);
		
	}
	
	@Test
	public void RimuoviFilm_2A(){
		// la lista vuota si presenta solo quando non c'è il film cercato con un titolo
		// che non esiste 
		String titoloDaElim = "Pierino";
		risul = man.eliminaFilm(titoloDaElim);
		assertFalse("Caso d'uso non ricoperto " , risul);
		
	}
	


}
