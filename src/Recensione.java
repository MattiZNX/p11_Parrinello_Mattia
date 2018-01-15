
public class Recensione

{
    /** Attributes */
    private int voto;
    private String commento;
    
    

    public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		if(voto >= 1 && voto <=5){
			this.voto = voto;
		}
	}
	public String getCommento() {
		return commento;
	}
	public void setCommento(String commento) {
		this.commento = commento;
	}
	/**
     * Operation
     *
     * @return void
     */
    public void displayError (  )
    {
    	System.out.println("ERRORE!!! Recensione non valida"); 
    }
    /**
     * Operation
     *
     * @return boolean
     */
    public boolean isValid () 
    {
    	int voto = this.getVoto();
    	if(voto >1 && voto <= 5){ 
    		if(this.getCommento() != null){
    			return true;
    		}
    	}
    	return false;
    }

}
