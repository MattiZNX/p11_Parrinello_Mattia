import java.util.Date;

public class Programmazione


{
    /** Attributes */
    private Date giorno;
    private int ora;
    private int minuti;
    private int idProgramazione;
    private int postiDisponibili;

    /** Associations */
    private Film film;
    private Prenotazione[] prenotazioni;
    private Sala sala;
    private Cinema cinema;
    
    
 
    public Programmazione(Date giorno, int ora, int minuti, int idProgramazione, int postiDisponibili, Film film , Sala s1) {
		super();
		this.giorno = giorno;
		this.ora = ora;
		this.minuti = minuti;
		this.idProgramazione = idProgramazione; 
		this.postiDisponibili = postiDisponibili;
		this.film = film;
		this.sala = s1;
		this.prenotazioni = null;
	}
    
	public Programmazione() {
		// TODO Auto-generated constructor stub
		this.giorno = null;
		this.ora = 0; 
		this.minuti = 0;
		this.idProgramazione = 0;
		this.postiDisponibili = 0;
		this.film = null;
	}
	
	/**
     * Operation
     *
     * @param seatToAdd
     * @return int
     */
    public int updatePostiDisponibili (int seatToAdd )
    {
    	this.postiDisponibili = this.postiDisponibili + (seatToAdd);
    	
    	return postiDisponibili;
    }
    /**
     * Operation
     *
     * @param data
     * @param ora
     * @param minuti
     * @return boolean
     */
    public boolean cambiaOrari ( Date data, int ora, int minuti )
    {
    	if(this.getGiorno().before(data)){
    		this.setGiorno(giorno);
    		this.setOra(ora);
    		this.setMinuti(minuti);
    		return true;
    	}
    	return false;
    }
    
	public Date getGiorno() {
		return giorno;
	}
	
	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}
	
	public int getOra() {
		return ora;
	}
	
	public void setOra(int ora) {
		this.ora = ora;
	}
	
	public int getMinuti() {
		return minuti;
	}
	
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}
	
	public int getIdProgramazione() {
		return idProgramazione;
	}
	
	public void setIdProgramazione(int idProgramazione) {
		this.idProgramazione = idProgramazione;
	}
	
	public int getPostiDisponibili() {
		return postiDisponibili;
	}
	
	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}
	
	public Film getFilm() {
		return film;
	}
	
	public void setFilm(Film film) {
		this.film = film;
	}
	
	
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
	
	
    
    

}

