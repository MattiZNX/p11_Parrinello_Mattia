import java.util.ArrayList;

public class Circuito

{
    /** Attributes */
    private String nome;
    
    /** Associations */
    private Manager manager;
    private ArrayList<Cinema> cinema;
    
	
	public ArrayList<Cinema> getCinema() {
		return cinema;
	}
	
	public void setCinema(ArrayList<Cinema> cinema) {
		this.cinema = cinema;
	}
   
    
}

