import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class CassieraStr {
	
	private static Cassiera c;
	private static Date d;
	private static Manager man;
	private static Calendar myCal;

	@BeforeClass
	public static void setup(){
		myCal = Calendar.getInstance();
		myCal.set(2017, 6, 4);
		man = new Manager();
		d = myCal.getTime();
		c = new Cassiera(d , 1200 , man , "Giorgia" , "Rossi" , "gg@gmail.com" , "gg" , 0);
		
	}
	
	@Test 
	public void tDataass(){
		myCal.set(2017, 10 , 2); 
		Date r = myCal.getTime();
		c.setDataAssunzione(r);
		assertEquals("" , r , c.getDataAssunzione());
	}
	
	@Test
	public void tStipendio(){
		c.setStipendio(1234);
		assertEquals("" , 1234 , c.getStipendio());
	}
	
	@Test
	public void tmanager(){
		Manager m2 = new Manager();
		c.setManager(m2);
		assertEquals("" , m2 , c.getManager());
	}
	
	@Test
	public void tShowInfo(){
		c.showInfo();
	}
	

}
