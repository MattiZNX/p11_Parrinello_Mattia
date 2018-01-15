import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class UC5_ConsultareSchedaFilm {
	private static Film f1;
	private static ArrayList<Recensione> recensioni;
	private static Recensione r1;
	private static Recensione r2;	
	@BeforeClass
	public static void setup(){
		/*
		 * Impostazione di un film 
		 */
		f1 = new Film("Wall-E", "Animazione", "In una galassia Lontana ...", 120, 4, 7, new Date(), new Date(), recensioni);
		recensioni = new ArrayList<Recensione>();
		r1 = new Recensione();
		r1.setCommento("WOW");
		r1.setVoto(5);
		r2 = new Recensione();
		r2.setCommento("Bello");
		r2.setVoto(4);
		recensioni.add(r1);
		recensioni.add(r2);
		f1.setRecensioni(recensioni);
		
		
	}
	@Test
	public void ConsultareSchedaFilm() {
		/*
		 * Non ha restistuzioni di errore , la corretteza del test è visiva con la visione a schermo della consultazione di tale scheda
		 */
		f1.displayInfoFilm(); 
	}
	

}
