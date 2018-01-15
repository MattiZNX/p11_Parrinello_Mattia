import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Utente


{

	/** Attributes */
    private String nTelefono;
    private String genere;
   
    /** Associations */
    private CartaDiCredito cartaDiCredito;
    private ArrayList<Prenotazione> prenotazioni;
    private Abbonamento abbonamento;
    
    /**
     * Operation
     *
     * @param p
     * @return boolean
     */
    
    
    public boolean prenotaBiglietto ( Programmazione p )
    {
    	Prenotazione prenotazioneOdierna = new Prenotazione();
    	prenotazioneOdierna.setProgrammazione(p); 
    	prenotazioni.add(prenotazioneOdierna); 
    	 
        return true;
    }
    
    
    /**
     * Operation
     *
     * @param Cinema[*]
     * @param città
     * @param data
     * @return Programmazione[*]
     */
    public ArrayList<Programmazione> ricercaPerCittà ( ArrayList<Cinema> cinema , String citta, Date data )
    {
    	ArrayList<Programmazione> prenTemp = new ArrayList<Programmazione>();
        for(Cinema c : cinema){
        	if(c.getCitta() == citta){ 
        		// Siamo nella città scelta , andiamo a controllare le programmazioni 
        		for(Programmazione prog : c.getProgrammazione()){
        			if(prog.getGiorno() == data){
        				prenTemp.add(prog);
        			}
        		}
        	}
        }
        return prenTemp;
    }
    /**
     * Operation
     *
     * @param Cinema[*]
     * @param città
     * @param data
     * @param nomeCinema
     * @return Programmazione[*]
     */
    public ArrayList<Programmazione> ricercaPerCinema ( ArrayList<Cinema> cinema , String citta, Date data, String nomeCinema )
    {
    	ArrayList<Programmazione> prenTemp = new ArrayList<Programmazione>();
        for(Cinema c : cinema){
        	if(c.getCitta() == citta && c.getNome() == nomeCinema){
        		// Siamo nella città scelta , andiamo a controllare le programmazioni 
        		for(Programmazione prog : c.getProgrammazione()){
        			if(prog.getGiorno() == data){
        				prenTemp.add(prog);
        			}
        		}
        	}
        }
        return prenTemp;
    }
    /**
     * Operation
     *
     * @param Cinema[*]
     * @param città
     * @param data
     * @param nomeCinema
     * @param titolo
     * @return Programmazione [*]
     */
    public ArrayList<Programmazione> ricercaPerFilm ( ArrayList<Cinema> cinema ,String citta, Date data, String nomeCinema, String titolo )
    {
    	ArrayList<Programmazione> prenTemp = new ArrayList<Programmazione>();
        for(Cinema c : cinema){
        	if(c.getCitta() == citta && c.getNome() == nomeCinema){
        		// Siamo nella città scelta , andiamo a controllare le programmazioni 
        		for(Programmazione prog : c.getProgrammazione()){
        			if(prog.getGiorno() == data && prog.getFilm().getTitolo() == titolo){
        				prenTemp.add(prog);
        			}
        		}
        	}
        }
        return prenTemp;
    }
    /**
     * Operation
     *
     * @param tipo
     * @return 
     */
    public void acquistaAbbonamento ( Abbonamento tipo  )
    {
    	if(cartaDiCredito.pagamento(tipo.getCosto())){ 
    		abbonamento.rimborsoBiglietti(tipo.getnBigliettiRimanenti());
    	}
    	return;
    }
    	
	public CartaDiCredito getCartaDiCredito() {
		return cartaDiCredito;
	}
	
	public void setCartaDiCredito(CartaDiCredito cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}
	
	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	
	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
	public Abbonamento getAbbonamento() {
		return abbonamento;
	}
	
	public void setAbbonamento(Abbonamento abbonamento) {
		this.abbonamento = abbonamento;
	}
   
    
}

