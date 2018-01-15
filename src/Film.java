import java.util.ArrayList;
import java.util.Date;

public class Film


{
    /** Attributes */
    private String titolo;
    private String categoria;
    private String trama;
    private int durata;
    private float votoMedio;
    private float prezzo;
    private Date dataInizio;
    private Date dataFine;
    
    /** Associations */
    private ArrayList<Recensione> recensioni; 
    
    
    
    public Film(String titolo, String categoria, String trama, int durata, float votoMedio, float prezzo,
			Date dataInizio, Date dataFine, ArrayList<Recensione> recensioni) {
		super();
		this.titolo = titolo;
		this.categoria = categoria;
		this.trama = trama;
		this.durata = durata; 
		this.votoMedio = votoMedio;
		this.prezzo = prezzo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.recensioni = recensioni;
	}
	/**
     * Operation
     *
     * @return 
     */
    public void  displayReviews (  )
    {
        for (Recensione r : recensioni){
        	System.out.println("------------------------------------------------------------------");
        	System.out.println("Voto : " + r.getVoto() + " Stelle ");
        	System.out.println("Commento : " + r.getCommento());
        	System.out.println("------------------------------------------------------------------");
        }
    }
    /**
     * Operation 
     *
     */
    public void displayInfoFilm()
    {
    	int sum = 0;
    	int i;
 	    for(i = 0; i < this.recensioni.size(); i++){	
 	    	sum = sum + recensioni.get(i).getVoto();
 	    }
 	    this.setVotoMedio(sum/i);
 	    
 	    this.showInfoFilm();
 	    
 	    this.displayReviews();
         
    }
    /**
     * Operation
     *
     * @return 
     */
    public void aggiungiRecensione (String commento , int voto  )
    {
        Recensione newRec = new Recensione();
        newRec.setCommento(commento);
        newRec.setVoto(voto);
        recensioni.add(newRec);
    }
    /**
     * Operation
     *
     * @return ArrayList<String>
     */
    public void showInfoFilm (  )
    {
    	System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Titolo : " + this.getTitolo());
        System.out.println("Categoria : " + this.getCategoria());
        System.out.println("Trama : " + this.getTrama());
        System.out.println("Durata : " + this.getDurata() + " min");
        System.out.println("Voto Medio : " + this.getVotoMedio());
        System.out.println("Prezzo del Biglietto : " + this.getPrezzo() + " €");
        System.out.println("Data Inizio Proiezione : " + this.getDataInizio().toString());
        System.out.println("Data Fine Proiezione : " + this.getDataFine().toString());
        System.out.println("---------------------------------------------------------------------------------");

    }
    /**
     * Operation
     *
     * @return boolean
     */
    public boolean isOutOfDate ()
    {
        Date now = new Date();
        System.out.println(now.toString());
        if(now.after(getDataFine()) || now.before(getDataInizio())){
        	return false;
        }else{
        	return true;
        } 
        	
    }
    
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getTrama() {
		return trama;
	}
	
	
	public Integer getDurata() {
		return durata;
	}
	
	
	public Float getVotoMedio() {
		return votoMedio;
	}
	
	public void setVotoMedio(float votoMedio) {
		this.votoMedio = votoMedio;
	}
	
	public Float getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public Date getDataInizio() {
		return dataInizio;
	}
	
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public Date getDataFine() {
		return dataFine;
	}
	
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}
	public void setRecensioni(ArrayList<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	
	
    
    
    
}

