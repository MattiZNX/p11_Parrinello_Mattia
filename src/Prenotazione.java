import java.util.Date;

public class Prenotazione 


{
	
    /** Attributes */
    private int idPrenotazione;
    private Date dataPagamento;
    private int nBiglietti;
    private int [] filaPosti;
    private int [] colPosti;
    private float costoTotale;
    
    /** Associations */
    private Pagamento pagamento;
    private Programmazione programmazione;
    private Sala sala;
    /**
     * Operation
     *
     * @param tipoPagamento
     * @param abb
     * @param cdc
     * @return boolean
     */
    public boolean pagaPrenotazione ( String tipoPagamento , Abbonamento abb , CartaDiCredito cdc )
    {
    	/*
    	 * il pagamento viene effettuato in questo modo : oltre a eseguire il pagamento stesso 
    	 * occorre fare l'update dei posti nella sala 
    	 */
    	
    	if(tipoPagamento == "Abbonamento" && abb != null){
    		if(abb.getnBigliettiRimanenti() >= nBiglietti){
    			System.out.println("Pago con abbonamento");
    			abb.aggiornaBiglietti(nBiglietti);
        		
        		int count = 0;
            	int[] filaposti = new int[nBiglietti];
            	int[] colposti = new int[nBiglietti];
            	boolean[][] temp = this.sala.getPosti();
            	if(verificaDisponibilitàPosti(nBiglietti)){
            		System.out.println("Biglietti nell'abbonamento : " + abb.getnBigliettiRimanenti());
            		System.out.println("Biglietti necessari : " + nBiglietti);
            		System.out.println("Inizio prenotazione");
        		
        			for(int i = 0; i < temp.length ; i++){
        	    		for(int k = 0; k < temp[i].length; k++){
        	    			if(temp[i][k] == false){
        	    				if(count < nBiglietti){
            	    				temp[i][k] = true;
            	    				filaposti[count] = i;
            	    				colposti[count] = k;
            	    				count = count +1;
            	    				System.out.print("(" + i + ";" + k + " )");
        	    				}
        	    			}
        	    		}
        	    	}
        			System.out.println("Fine Prenotazione");
        		
        		
            		this.setFilaPosti(filaPosti);
            		this.setColPosti(colPosti);
            		this.sala.setPosti(temp);
            		return true;
            	}
    			
    		}else{System.out.println("Non hai abbastanza biglietti in abbonamento");return false;}
    		
    		
    	}else if(tipoPagamento == "CartaDiCredito" && cdc != null){
    		if(cdc.pagamento(costoTotale)){
    			System.out.println("Pago con Carta");
    			int count = 0;
            	int[] filaposti = new int[nBiglietti];
            	int[] colposti = new int[nBiglietti];
            	boolean[][] temp = this.sala.getPosti();
            	if(verificaDisponibilitàPosti(nBiglietti)){
            		System.out.println("Inizio prenotazione");
        			for(int i = 0; i < temp.length ; i++){
        	    		for(int k = 0; k < temp[i].length; k++){
        	    			if(temp[i][k] == false){
        	    				if(count < nBiglietti){
	        	    				System.out.print("Prenotato il posto (" + i + ";" + k + " )");
	        	    				temp[i][k] = true;
	        	    				filaposti[count] = i; 
	        	    				colposti[count] = k;
	        	    				count = count +1; 
        	    				}
        	    			}
        	    		}
        	    	}
            		
            		this.setFilaPosti(filaPosti);
            		this.setColPosti(colPosti);
            		this.sala.setPosti(temp);
            		return true;
            	}
    		}else{System.out.println("Saldo insufficente "); return false;}
    		
    	}
    	System.out.println("Impossibile effettuare il pagamento");
    	return false;
    }
    /**
     * Operation
    
     * @return boolean
     */
    public boolean verificaOraCancellazione ()
    {
    	/* 
    	 * la prenotazione può essere cancellata al massimo 2 ore prima dello spettacolo prenotato 
    	 */
    	
    	final long HOUR = 3600*1000;
    	Date now = new Date();
    	Date temp = new Date(now.getTime() + 2 * HOUR);
    	if(this.programmazione.getGiorno().after(temp)){
    		return true;
    	}else{
    		return false;
    	}
    	
    }
    /**
     * Operation
     *
     * @param abb
     * @return boolean
     */
    public boolean cancellaPrenotazione (Abbonamento abb)
    {
      if(this.verificaOraCancellazione()){
    	  boolean[][] temp = this.sala.getPosti();
    	  int[] fila = this.getFilaPosti();
    	  int[] col = this.getColPosti();
    	  
    	  for(int i = 0 ; i < fila.length; i++ ){
    		  temp[fila[i]][col[i]] = false;
    		 // System.out.println("Eliminato il posto " + fila[i] +" ; "+ col[i]  );
    	  }
    	  abb.rimborsoBiglietti(nBiglietti);
    	  this.sala.setPosti(temp);
    	  return true;
      }else{
    	  return false;
      }
    }
    
    
    
    /**
     * Operation
     * @param cdc
     * @return boolean
     */
    public boolean cancellaPrenotazione (CartaDiCredito cdc)
    {
      if(this.verificaOraCancellazione()){
    	  boolean[][] temp = this.sala.getPosti();
    	  int[] fila = this.getFilaPosti();
    	  int[] col = this.getColPosti();
    	  
    	  for(int i = 0 ; i < fila.length; i++ ){
    		  temp[fila[i]][col[i]] = false;
    		  //System.out.println("Eliminato il posto " + fila[i] +" ; "+ col[i]  );
    	  }
    	  cdc.rimborso(costoTotale);
    	  this.sala.setPosti(temp);
    	  return true;
      }else{
    	  return false;
      }
    }
    
    
    
    
    /**
     * Operation
     *
     * @param nBiglietti
     * @return boolean
     */
    public boolean verificaDisponibilitàPosti ( int nBiglietti )
    {
    	boolean[][] temp = this.sala.getPosti();
    	int count = 0;
    	
    	for(int i = 0; i < temp.length ; i++){
    		for(int k = 0; k < temp[i].length; k++){
    			if(temp[i][k] == false){
    				count = count +1 ;
    			}
    		}
    	}
    	System.out.println("Posti disponibili : " + count);
    	
    	if(nBiglietti <= count){
    		
    		return true;
    	}else{return false;}
    }
    /**
     * Operation
     *
     * @param nBiglietti
     * @param prezzo
     * @return 
     */
    public void calcolaTotale ( int nBiglietti, float prezzo )
    {
    	this.setCostoTotale(prezzo*nBiglietti);
    }
    /**
     * Operation
     *
     * @return 
     */
    public void visualizzaErrore (  )
    {
       System.out.println("ERRORE nell'esecuzione dell'operazione");
    }
    
	
	
	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	
	
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	public int[] getFilaPosti() {
		return filaPosti;
	}
	
	public void setFilaPosti(int[] filaPosti2) {
		this.filaPosti = filaPosti2;
	}
	
	public int[] getColPosti() {
		return colPosti;
	}
	
	public void setColPosti(int[] colPosti) {
		this.colPosti = colPosti;
	}
	
	public float getCostoTotale() {
		return costoTotale;
	}
	
	public void setCostoTotale(float costoTotale) {
		this.costoTotale = costoTotale;
	}
	
	
	public void setProgrammazione(Programmazione programmazione) {
		this.programmazione = programmazione;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public void setnBiglietti(int nBiglietti) {
		this.nBiglietti = nBiglietti;
	}
	
	
  
    
}

