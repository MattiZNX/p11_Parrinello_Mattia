import java.util.ArrayList;

public class Sala


{
    /** Attributes */
    private String nomeSala;
    private boolean[][] posti;
    private int postiTotali;
    private int id;
    

    /** Associations */
    private ArrayList<Programmazione> programmazioni;

	public Sala(String nomeSala, boolean[][] posti, int postiTotali, int id, ArrayList<Programmazione> programmazioni) {
		super();
		this.nomeSala = nomeSala;
		this.posti = posti;
		this.postiTotali = postiTotali; 
		this.id = id;
		this.programmazioni = programmazioni;
	}

	public boolean[][] getPosti() {
		return posti;
	}

	public void setPosti(boolean[][] posti) {
		this.posti = posti;
	}


	public int getId() {
		return id;
	}

	

	

    
    
}

