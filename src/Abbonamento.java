
public class Abbonamento

{
    /** Attributes */
    private String tipo;
    private int nBigliettiRimanenti;
    private float costo;
    private Cliente cliente; 
    /**
     * Operation
     *
     * @param nBiglietti
     * @return 
     */
    public void aggiornaBiglietti (int nBiglietti ) 
    {
    	if(nBiglietti <= nBigliettiRimanenti){
    		this.nBigliettiRimanenti = this.nBigliettiRimanenti - nBiglietti;
    	}else {
    		System.out.println(" Non hai abbastanza biglietti nell'abbonamento per saldare la prenotazione");
    	}
    }
    /**
     * Operation
     *
     * @param nBiglietti
     * @return 
     */
    public void rimborsoBiglietti (int nBiglietti )
    { 
        this.nBigliettiRimanenti = this.nBigliettiRimanenti + nBiglietti;
    }
    
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getnBigliettiRimanenti() {
		return nBigliettiRimanenti;
	}
	
	public void setnBigliettiRimanenti(int nBigliettiRimanenti) {
		this.nBigliettiRimanenti = nBigliettiRimanenti;
	}
	
	public float getCosto() {
		return costo;
	}
	
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
   
}


