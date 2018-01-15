import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class Manager extends Utente

{
    /** Attributes */
    private  int nDipendenti;
    private  int stipendio;
    private ArrayList<Programmazione> programmazione;
    private ArrayList<Cassiera> cassiere;
    private Circuito circuito;
    
    
    
    public Manager(){  
    	programmazione = new ArrayList<Programmazione>();
    	cassiere = new ArrayList<Cassiera>(); 
    }
    
    /**
     * Operation
     *
     * @param newp
     * @param cin
     * @return boolean
     */
    public boolean modificaProgrammazione ( Programmazione newp , Cinema cin)
    {
    	for(int i = 0 ; i < circuito.getCinema().size(); i++){
    		if(circuito.getCinema().get(i).getNome().equals(cin.getNome())){
    			// Controllo Sovrapposizioni
		    	for(Programmazione prog : circuito.getCinema().get(i).getProgrammazione()){ 
		    		if(prog.getGiorno().equals(newp.getGiorno()) && 
		    				prog.getOra() == newp.getOra() &&
		    				prog.getMinuti() == newp.getMinuti() &&
		    				prog.getSala() == newp.getSala()){
		    				System.out.println("C'è Sovrapposizione con una programmazione");
		    			return false;
		    		}
		    	}
		       for(Programmazione prog : circuito.getCinema().get(i).getProgrammazione()){
		    	   // se i due film hanno lo stesso titolo e lo stesso giorno di riproduzione 
		    	   // allora possiamo cambiare
		    	   // orario , ricordando che non è possibile anticiparla
		    	   if(( prog.getFilm().getTitolo().equals(newp.getFilm().getTitolo())) && (prog.getGiorno().before(newp.getGiorno()))){
		    		   	prog.setOra(newp.getOra()); 
		    		   	prog.setMinuti(newp.getMinuti());    
		    		   	prog.setGiorno(newp.getGiorno()); 
		    		   	prog.setSala(newp.getSala()); 
		    		   	sendEmailToUsers();   
		    		   	System.out.println("Spettacolo Posticipato"); 
		    		   	return true;
		    		    
		    	   }else{this.displayError();return false;}
		       }
    		}
    	}
    	return false;
    }
    /**
     * Operation
     *
     * @param f
     * @return boolean
     */
    public boolean modificaFilm (Film f )
    {
       for(Programmazione p : programmazione){
    	   // scorro tutte le mie programmazioni nel cinema e ogni volta che incontro un film con lo stesso titolo
    	   // ne cambio la categoria , il prezzo a biglietto 
    	   if(p.getFilm().getTitolo() == f.getTitolo()){
    		   // una volta individuato il film dal titolo occorre modificare tutti i campi necessari 
    		   p.getFilm().setCategoria(f.getCategoria());
    		   p.getFilm().setPrezzo(f.getPrezzo());
    		   return true; 
    	   }
       }
       return false;
    }
    /**
     * Operation
     *
     * @param c
     * @return boolean
     */
    public boolean aggiungiCassiera (Cassiera c )
    {
    	// controllo se la cassiera esiste già nel sistema 
    	for(Cassiera cas : cassiere){
    		if(c.getId() == cas.getId()){ 
    			System.out.println("ID già esistente , inserimento non valido ");
    			return false;
    		}else if(c.getUsername().equals(cas.getUsername()) 
    					&& c.getNome().equals(cas.getNome()) 
    					&& c.getCognome().equals(cas.getCognome())){
    				System.out.println("Utente già esistente");
    				return false;
    		}else if (c.getNome().equals("") || c.getCognome().equals("") || c.getId() == 0){
    			System.out.println("Uno dei campi non è stato inserito oppure non valido");
    			return false;
    		}
    	}
	    cassiere.add(c);
	    return true;
	    	
    }
        
    
    /**
     * Operation
     *
     * @param id
     * @return boolean
     */
    public boolean eliminaCassiera (int id )
    {
        // ricerca la cassiera e la elimina dalla lista 
    	for(int i = 0; i< cassiere.size(); i++){
    		if(cassiere.get(i).getId() == id){
    			// cassiera trovata 
    			cassiere.remove(i);
    			return true;
    		}
    	}
    	System.out.println("Cassiera non esiste nel sistema");
    	return false;
    	
    }
    /**
     * Operation
     *
     * @param f
     * @return boolean
     */
    public boolean aggiungiFilm ( Film f  , Programmazione p , Cinema c1)
    {
    	p.setFilm(f);
    	for(int i = 0 ; i < c1.getProgrammazione().size(); i++){
    		if(c1.getProgrammazione().get(i).getFilm().equals(f)){
    			System.out.println("Film già presente nel sistema");
    			return false;
    		}
    	}
    	programmazione.add(p);
    	return true;
    }
    /**
     * Operation
     *
     * @param titolo
     * @return boolean
     */
    public boolean eliminaFilm (String titolo )
    {
    	Calendar myCal = Calendar.getInstance();
    	Date today = myCal.getTime();
    	int countFilmElim = 0;
    	
    	for(int k = 0; k < this.circuito.getCinema().size(); k++){
    		// controllo in tutti i cinema che ho i film che sono fuori produzione
	    	for(int i = 0; i < this.circuito.getCinema().get(k).getProgrammazione().size(); i++){
	    		// Se ha lo stesso titolo ed è fuori proiezione viene eliminato 
				if(this.circuito.getCinema().get(k).getProgrammazione().get(i).getFilm().getTitolo() ==  titolo 
						&& this.circuito.getCinema().get(k).getProgrammazione().get(i).getGiorno().before(today)){
					
					countFilmElim = countFilmElim +1;
	    		}
	    	}
	    	if(countFilmElim == 0){System.out.println("Non ci sono film da cancellare"); return false;}
	 
	        // ricerca tra le programmazioni tutti i film con quel titolo e ne elimina le rispettive programmazioni
	    	for(int i = 0; i < this.programmazione.size(); i++){
	    		// Se ha lo stesso titolo ed è fuori proiezione viene eliminato 
				if(this.circuito.getCinema().get(k).getProgrammazione().get(i).getFilm().getTitolo() ==  titolo 
						&& this.circuito.getCinema().get(k).getProgrammazione().get(i).getGiorno().before(today)){
					this.circuito.getCinema().get(k).getProgrammazione().remove(i);
	    		}
	    	}
    	}
    	return true;
    }
    /**
     * Operation
     *
     * @return 
     */
    public void visualizzaCassiere (  )
    {
    	for(Cassiera cas : cassiere){
    		System.out.println("----------------------------------------------------------------------");
    		System.out.println("Nome : " + cas.getNome());
    		System.out.println("Cognome : " + cas.getCognome());
    		System.out.println("Id : " + cas.getId());
    		System.out.println("Username : " + cas.getUsername());
    		System.out.println("Data Assunzione : " + cas.getDataAssunzione().toString());
    		System.out.println("----------------------------------------------------------------------");
    	}
    }
    /**
     * Operation
     *
     * @return 
     */
    public void displayError()
    {
       System.out.println("Error di sistema , Film non trovato o errore nell'orario,"
       		+ " Si ricorda che il film non può essere anticipato ");
    }
    
    /**
     * Operation
     *
     * @return 
     */
    public void sendEmailToUsers(){
    	// funzione esterna che si occupa di mandare una mail agli utenti 
    	// qui espressa con un semplice print
    	
    	System.out.println("Cambio programmazione inviato");
    }
	
	public ArrayList<Programmazione> getProgrammazione() {
		return programmazione;
	}
	public void setProgrammazione(ArrayList<Programmazione> programmazione) {
		this.programmazione = programmazione;
	}
	public ArrayList<Cassiera> getCassiere() {
		return cassiere;
	}
	public void setCassiere(ArrayList<Cassiera> cassiere) {
		this.cassiere = cassiere;
	}
	public Circuito getCircuito() {
		return circuito;
	}
	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}
	
    
	
    
    
}

