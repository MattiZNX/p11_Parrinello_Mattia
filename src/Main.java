import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Main con inizializzazione del sistema a simulazione della compilazione di tutto il sistema 
		 */
		
		System.out.print("Inizializzazione del sistema con dei film ..... ");
		
		
		ArrayList<Programmazione> programmazioniUCI = new ArrayList<Programmazione>();
		ArrayList<Programmazione> programmazioniTheSpace =  new ArrayList<Programmazione>();
		ArrayList<Sala> saleUCI = new ArrayList<Sala>();
		ArrayList<Sala> saleTheSpace = new ArrayList<Sala>();
		
		System.out.println("Creazione Cinema UCI di Genova ");
		ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
		Calendar myCal = Calendar.getInstance();
		myCal.set(2017, 8, 8);
		Date today = myCal.getTime(); 
		
		System.out.println("Aggiunto : Film 1 : Thor 2/8/2016 3/9/2018 120' 8€ 4 S1 '' 8/8/2017 13:00");
		myCal.set(2016 , 8 , 2);
		Date dif1 = myCal.getTime();
		myCal.set(2018, 9, 3);
		Date dff1 = myCal.getTime();
		Sala s1 = new Sala("S1" , new boolean[3][3] , 9 , 12 , null);
		Film f1 = new Film("Thor" , "Hero" , "..." , 120 , 8 , 4 , dif1 , dff1, null);
		Programmazione prog1 = new Programmazione(today , 13 , 0 , 123 , 9 , f1, s1);
		
		System.out.println("Aggiunto : Film 2 : Spiderman 1/1/2015 1/1/2018 60' 6€ 3 '' 8/8/2017 14:00");
		myCal.set(2015 , 1 , 1);
		Date dif2 = myCal.getTime();
		myCal.set(2018, 1 , 1);
		Date dff2 = myCal.getTime();
		Sala s2 = new Sala("S2" , new boolean[4][4] , 16 , 124 , null);
		Film f2 = new Film("Spiderman" , "Hero" , "..." , 60 , 6 , 3 , dif2 , dff2, null);
		Programmazione prog2 = new Programmazione(today , 15 , 0 , 1253 , 10 , f2, s2);
		
		System.out.println("Aggiunto: Film 3 : Minion 2/4/2016 5/7/2018 100' 7€ 2 '' S3 8/8/2017 15:00");
		myCal.set(2016 , 4 , 2);
		Date dif3 = myCal.getTime();
		myCal.set(2018, 9, 3);
		Date dff3 = myCal.getTime();
		Sala s3 = new Sala("S3" , new boolean[3][3] , 9 , 1562 , null);
		Film f3 = new Film("Minion" , "Fantasy" , "..." , 120 , 9 , 4 , dif3 , dff3, null);
		Programmazione prog3 = new Programmazione(today , 16 , 0 , 12763 , 9 , f3, s3);
		
		saleUCI.add(s1);
		saleUCI.add(s2);
		saleUCI.add(s3);
		
		programmazioniUCI.add(prog1);
		programmazioniUCI.add(prog2);
		programmazioniUCI.add(prog3);
		
		
		Cinema uci = new Cinema("UCI" , "Genova" , "Via XX" , programmazioniUCI , saleUCI);
		
		System.out.println("Creazione cinema : The Space di Milano ");
		System.out.println("Aggiunto : Film 1 : Thor 2/8/2016 3/9/2018 120' 8€ 4 S1 8/8/2017 '' 10:00"); 
		Programmazione prog4 = new Programmazione(dif1 , 10 , 0 , 123 , 9 , f1, s1);
		
		System.out.println("Film 2 : IronMan 2/2/2016 6/6/2018 100' 6€ 5 '' S2 8/8/2017 10:00"); 
		myCal.set(2016 , 8 , 6);
		Date dif4 = myCal.getTime();
		myCal.set(2018, 6, 6);
		Date dff4 = myCal.getTime();
		Film f4 = new Film("IronMan" , "Hero" , "..." , 100 , 8 , 5 , dif4 , dff4 , null);
		Programmazione prog5 = new Programmazione(today , 8 , 0 , 4578 , 6 , f4 , s2);
		
		System.out.println("Aggiunto: Film 3 : Avengers 1/8/2016 3/9/2018 90' 9€ 4 '' S3 8/8/2017 17:00" );
		myCal.set(2016, 8, 1);
		Date dif5 = myCal.getTime();
		myCal.set(2018, 9, 3);
		Date dff5 = myCal.getTime();
		Film f5 = new Film("Avengers" , "Hero" , "..." , 120 , 9 , 4 , dif5 , dff5 , null);
		Programmazione prog6 = new Programmazione(today , 17 , 0 , 3675 , 4 , f5 , s3);
		
		saleTheSpace = saleUCI;
		programmazioniTheSpace.add(prog4);
		programmazioniTheSpace.add(prog5);
		programmazioniTheSpace.add(prog6);
		
		Cinema thespace = new Cinema("TheSpace" , "Milano" , "Via Napoleone" , programmazioniTheSpace , saleTheSpace); 
		
		cinemas.add(uci);
		cinemas.add(thespace);
		
		System.out.println("Benvenuto Cliente !!!");
		Cliente client = new Cliente(); 
		
	}

}
