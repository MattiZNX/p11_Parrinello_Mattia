import java.util.ArrayList;

public class Cinema

{
    /** Attributes */
    private String nome;
    private String citta;
    private String indirizzo;
    
    /** Associations */
    private ArrayList<Programmazione> programmazione;
    private ArrayList<Sala> sale;
    
    
    
    public Cinema(String nome, String citta, String indirizzo, ArrayList<Programmazione> programmazione,
			ArrayList<Sala> sale) {
		super();
		this.nome = nome;
		this.citta = citta; 
		this.indirizzo = indirizzo; 
		this.programmazione = programmazione;
		this.sale = sale;
	}
	/**
     * Operation
     *
     * @param s
     * @return boolean
     */
    public boolean aggiungiSala ( Sala s )
    {
       for(Sala r : sale ){
    	   if(r.getId() == (s.getId())){ 
    		   System.out.println("Impossibile aggiungere la sala , ne esiste già una con lo stesso id");
    		   return false ;
    	   }
       }
       sale.add(s);
       return true;
       
    }
    /**
     * Operation
     *
     * @param id
     * @return  boolean
     */
    public boolean rimuoviSala ( int id )
    {
    	for(int i = 0; i < this.sale.size(); i++){
    		if (sale.get(i).getId() == id){
    			sale.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * Operation
     *
     * @param p
     * @return boolean
     */
    public boolean aggiungiProgrammazione ( Programmazione p )
    {
        if(!isSovrapposto(p)){
        	programmazione.add(p);
        	return true;
        }
        return false;
        
    }
    /**
     * Operation
     *
     * @param id
     * @return boolean
     */
    public boolean rimuoviProgrammazione ( int id )
    {
        for(int i = 0 ; i < this.programmazione.size(); i++){
        	if(programmazione.get(i).getIdProgramazione() == id){
        		programmazione.remove(i); 
        		return true;
        	}
        }
        return false;
    }
    /**
     * Operation
     *
     * @param p
     * @return boolean
     */
    public boolean isSovrapposto ( Programmazione p )
    {
    	for(Programmazione pr : programmazione){
        	if(pr.getGiorno().equals(p.getGiorno()) && pr.getSala().equals(p.getSala())){ 
        		return true;
        	}       	
        }
        return false;
    }
    
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public ArrayList<Programmazione> getProgrammazione() {
		return programmazione;
	}
	
	public void setProgrammazione(ArrayList<Programmazione> programmazione) {
		this.programmazione = programmazione;
	}
	
	public ArrayList<Sala> getSale() {
		return sale;
	}
	
	public void setSale(ArrayList<Sala> sale) {
		this.sale = sale;
	}
    
}

