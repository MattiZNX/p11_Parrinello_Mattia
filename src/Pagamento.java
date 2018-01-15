import java.util.Date;

public class Pagamento

{
    /** Attributes */
    private int idTransizione;
    private Date dataPagamento;
    private String tipoDiPagamento;
    private boolean avvenuto;
    
    
    public Pagamento(int id, Date d , String tipo , boolean avv){
    	this.idTransizione = id ;
    	this.dataPagamento = d;
    	this.tipoDiPagamento = tipo;
    	this.avvenuto = avv;
    }
    /**
     * Operation
     *
     * @param tipoPagamento
     * @return boolean
     */
    public boolean eseguiPagamento ( String tipoPagamento )
    {
    	System.out.println("Pagamento Eseguito");
    	this.avvenuto = true;
    	return true;
    }

	
    
    

}

