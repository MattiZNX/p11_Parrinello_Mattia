
public class CartaDiCredito

{
    /** Attributes */
    private String nCarta;
    private float saldo;
    /**
     * Operation
     *
     * @param importo
     * @return 
     */
    public boolean pagamento ( float importo ) 
    {
        if (this.saldo >= importo ){
        	this.saldo = this.saldo - importo;
        	return true; 
        }else {
        	System.out.println("Credito sulla carta insufficiente per saldare la prenotazione");
        	return false;
        }
    }
    /**
     * Operation
     *
     * @param importo
     * @return 
     */
    public void rimborso ( float importo )
    {
        this.saldo = this.saldo + importo;
    }
    
	
	public String getnCarta() {
		return nCarta; 
	}
	public void setnCarta(String nCarta) {
		this.nCarta = nCarta;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public Float getSaldo() {
		return saldo;
	}
	
    
}


