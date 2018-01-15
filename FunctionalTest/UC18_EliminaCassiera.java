import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC18_EliminaCassiera {

	public static Manager man ;
	public static Cassiera cas1 , cas2 , cas3 , cas4;
	public static ArrayList<Cassiera> cassiere;
	public static Calendar myCal;
	public static Date dateCas1 , dateCas2 , dateCas3, dateCas4;
	
	@BeforeClass
	public static void setup(){
		man = new Manager();
		cassiere = new ArrayList<Cassiera>();
		myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 5);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		dateCas1 = myCal.getTime(); 
		cas1 = new Cassiera(dateCas1, 4, man , "Maria" , "Rossi" , "maria.rossi@gmail.com" , "mrossi" , 1);
		cassiere.add(cas1);
		
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 6);
		myCal.set(Calendar.DAY_OF_MONTH, 13);
		dateCas2 = myCal.getTime(); 
		cas2 = new Cassiera(dateCas2, 5, man , "Giorgia" , "Parodi" , "giorgia.parodi@gmail.com" , "gparodi" , 2);
		cassiere.add(cas2);
		
		myCal.set(Calendar.YEAR, 2017);
		myCal.set(Calendar.MONTH, 7);
		myCal.set(Calendar.DAY_OF_MONTH, 12);
		dateCas3 = myCal.getTime(); 
		cas3 = new Cassiera(dateCas3, 10, man , "Franca" , "Olms" , "franca.olms@gmail.com" , "Folms" , 3);
		cassiere.add(cas3);
		
		man.setCassiere(cassiere);
	}

	@Test
	public void EliminaCassiera(){
		boolean ris;
		ris = man.eliminaCassiera(2);
		assertTrue("Caso d'uso non ricoperto" , ris);
	}
	
	@Test
	public void EliminaCassiera_3A(){
		boolean ris;
		ris = man.eliminaCassiera(12);
		assertFalse("Caso d'uso non ricoperto" , ris);
	}
	

}
