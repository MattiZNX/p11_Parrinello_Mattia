import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC14_ModificareProgrammazione {

	public static Circuito circ;
	public static Cinema c1 , c2 , cinSel;
	public static ArrayList<Programmazione> programmazioneMan , programmazioneSala1 , programmazioneSala2;
	public static Programmazione p1 , p2 , p3 , p4 , p5 , p6 ,progSel , pErr;
	public static Film f1 , f2 , f3 , filmNotEx;
	public static Manager man;
	public static Sala s1 , s2;
	public static Date now , dif1 , dif2 , dif3 , dff1 , dff2 , dff3 , dateMod;
	public static ArrayList<Sala> sale;
	public static Calendar myCal;
	
	@BeforeClass
	public static void setup(){
		man = new Manager();
		programmazioneMan = new ArrayList<Programmazione>();
		programmazioneSala1 = new ArrayList<Programmazione>();
		programmazioneSala2 = new ArrayList<Programmazione>();
		s1 = new Sala("A", new boolean [4][4], 16, 1, programmazioneSala1);
		s2 = new Sala("B", new boolean [4][4], 16, 1, programmazioneSala2);
		myCal = Calendar.getInstance();
		now = myCal.getTime();
		// Film1 (Inizio: 1 Maggio 2017 , Fine: 1 Maggio 2018) 
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dif1 = myCal.getTime(); 
		myCal.set(Calendar.YEAR, 2018);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dff1 = myCal.getTime();
		f1 = new Film("Wolf of WallStreet" , "Thriller" , "..." , 124  , 5 , 4 , dif1 , dff1, null );
		// Film2 ( Inizio: 4 Aprile 2016 , Fine: 3 Gennaio 2019)
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 4);
		myCal.set(Calendar.DAY_OF_MONTH, 4);
		dif2 = myCal.getTime(); 
		myCal.set(Calendar.YEAR, 2019);
		myCal.set(Calendar.MONTH, 1);
		myCal.set(Calendar.DAY_OF_MONTH, 3);
		dff2 = myCal.getTime();
		f2 = new Film("Thor" , "Heroes" , "..." , 120 , 4 , 6 , dif2 , dff2 , null);
		// Film3 (Inizio : 2 Febbraio 2017 , Fine: 4 Febbraio 2018)
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 2);
		myCal.set(Calendar.DAY_OF_MONTH, 2);
		dif3 = myCal.getTime(); 
		myCal.set(Calendar.YEAR, 2018);
		myCal.set(Calendar.MONTH, 2);
		myCal.set(Calendar.DAY_OF_MONTH, 4);
		dff3 = myCal.getTime();
		f3 = new Film("Spiderman" , "Heroes" , "..." , 60 , 3 , 8 , dif3 , dff3 , null);
		// Wolf of Wall Street , 4 Aprile 2016 15:30 , Sala A
		p1 = new Programmazione(dif1 , 15 , 30 , 2347 , 16 , f1 , s1);
		// Wolf of Wall Street , 4 Aprile 2016 17:30 , Sala B
		p2 = new Programmazione(dif1 , 17 , 30 , 2567 , 16 , f1 , s2);
		// Thor , 4 Aprile 2016 , 12:00 ,  Sala A
		p3 = new Programmazione(dif2 , 12 , 00 , 4567 , 16 , f2 , s1); 
		// Thor , 4 Aprile 2016 , 15:00 , Sala B
		p4 = new Programmazione(dif2 , 15 , 00 , 34567 , 16 , f2 , s2);
		// Spiderman , 2 Febbraio 2017 , 18:00 , Sala A
		p5 = new Programmazione(dif3 , 18 , 00 , 23567 , 16 , f3 , s1);
		// Spiderman , 2 Febbraio 2017 , 13:00 , Sala B
		p6 = new Programmazione(dif3 , 13 , 00 , 23457 , 16 , f3 , s2);
		
		programmazioneSala1.add(p1);
		programmazioneSala1.add(p3);
		programmazioneSala1.add(p5);
		
		programmazioneSala2.add(p2);
		programmazioneSala1.add(p4);
		programmazioneSala1.add(p6);
		
		programmazioneMan.add(p1);
		programmazioneMan.add(p2);
		programmazioneMan.add(p3);
		programmazioneMan.add(p4);
		programmazioneMan.add(p5);
		programmazioneMan.add(p6);
		
		sale = new ArrayList<Sala>();
		sale.add(s1);
		sale.add(s2);
		
		c1 = new Cinema("UCI", "Genova", "Via Fiumara", programmazioneMan, sale);
		c2 = new Cinema("Valli" , "Milano" , "Via MonteNapoleone" , programmazioneMan, sale );
		
		c1.setProgrammazione(programmazioneMan);
		c2.setProgrammazione(programmazioneMan);
		circ = new Circuito();
		ArrayList<Cinema> cinCirc = new ArrayList<Cinema>();
		cinCirc.add(c1);
		cinCirc.add(c2);
		circ.setCinema(cinCirc);
		man.setCircuito(circ); 
	}
	
	@Test 
	public void ModificaProgrammazione(){
		// Creazione di una programmazione fittizia dettata dal fatto che il 
		// Manager abbia selezionato determinate caratteritiche come il film e il 
		// cinema su cui cercare 
		cinSel = new Cinema("UCI", "Genova", "Via Fiumara", null, null);
		myCal.set(2017 , 6 , 4 , 10 , 20);
		dateMod = myCal.getTime(); 
		// programmazione diversa di Wolf of WallStreet che passa alle 19:30
		progSel = new Programmazione(dateMod , 22 , 30 , 2347 , 16 , f1 , s1);
		assertTrue( "Caso d'uso non ricoperto", man.modificaProgrammazione(progSel,  cinSel));
	}
	
	@Test
	public void ModificaProgrammazione_3A(){
		cinSel = new Cinema("UCI", "Genova", "Via Fiumara", null, null);
		// viene creato un film inesistente 
		filmNotEx = new Film("IronMan" , "Heroes" , "..." , 120 , 4 , 6 , dif2 , dff2 , null);
		progSel = new Programmazione(dif2 , 19 , 30 , 2347 , 16 , filmNotEx , s1);
		assertFalse("Caso d'uso non ricoperto" , man.modificaProgrammazione(progSel,  cinSel));
	}
	
	@Test
	public void ModificaProgrammazione_7A(){
		// caso in cui si intenda anticipare uno spettacolo 
		cinSel = new Cinema("UCI", "Genova", "Via Fiumara", null, null);
		p1 = new Programmazione(dif1 , 8 , 30 , 2347 , 16 , f1 , s1);
		assertFalse("Caso d'uso non ricoperto " , man.modificaProgrammazione(p1,  cinSel));
		
	}
	
	@Test
	public void ModificaProgrammazione_7B(){
		// sovrapposizione di Sala con un altro film 
		cinSel = new Cinema("UCI", "Genova", "Via Fiumara", null, null);
		// alle 15:30 in Sala A c'è Thor , decido di metterci Spiderman , non posso 
		pErr = new Programmazione(dif2 , 15 , 00 , 2347 , 16 , f3 , s1);
		assertFalse("Caso d'uso non ricoperto" , man.modificaProgrammazione(pErr,  cinSel));
	}
	
	@Test
	public void prova(){}

}
