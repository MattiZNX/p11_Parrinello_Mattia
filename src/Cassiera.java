import java.util.Date;

public class Cassiera extends Utente


{
    /** Attributes */
	private String nome;
	private String cognome;
	private String email;
	private String username;
    private Date dataAssunzione;
    private int stipendio;
    private int id;
   
    /** Association **/
    private Manager manager; 
    
    
    
    public Cassiera(Date dataAssunzione, int stipendio, Manager manager ,
    		String nome , String cognome , String email, String user , int id) {
    	
		this.dataAssunzione = dataAssunzione;
		this.stipendio = stipendio;
		this.manager = manager;
		this.nome = nome; 
		this.cognome = cognome;
		this.email = email; 
		this.username = user;
		this.id = id;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

    public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	public String getUsername() {
		return username;
	}

	public int getId() {
		return id;
	}


	/**
     * Operation
     *
     * @return 
     */
    public void showInfo (  )
    {
    	System.out.println("Nome : " + this.getNome() 
    			+ "Cognome : " + this.getCognome() 
    			+ "Stipendio : " + this.stipendio
    			+ "Email : " + this.getEmail()
    			+ "Username : " + this.getUsername()
    			);
    }
    
}


