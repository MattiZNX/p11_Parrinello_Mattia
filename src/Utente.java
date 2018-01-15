import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Utente

{
    /** Attributes */ 
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private boolean loggato;
    private String password;
    
    /**
     * Operation
     *
     * @return void
     */
    
    
    public void defUtente(String nome , String cognome , String email , String username , String password , int id){
    	/*
         * Funzione per definire i parametri dell'utente 
         */
    	this.nome = nome;
    	this.cognome = cognome;
    	this.email = email;
    	this.username = username;
    	this.password = password;
    	this.id = id;
    	this.loggato = false;
    }
    
	/**
     * Operation
     *
     * @return boolean
     */
    
    public boolean login ( String username , String password , ArrayList<Utente> regUserList){
    	for(Utente u : regUserList){
    		if(u.getUsername().equals(username) && u.getPassword().equals(password)){
    			this.loggato = true;
    			return true;
    		}else{System.out.println("Nome utente o password errati");}
    	}
    	return false;
    }
    
    /**
     * Operation
     *
     * @return boolean
     */
    public boolean registrazione(String username , String password , String nome , String cognome , String email , ArrayList<Utente> regUser , String repeatPass){
    	int count = 0;
    	for(Utente u : regUser){
    		if(u.getUsername().equals(username)){
    			System.out.println("L'utente esiste già");
    			return false;
    		}
    		count = count +1;
    	}
    	
    	if(!password.equals(repeatPass)){System.out.println("Le password non coincidono"); return false;}
    	
    	if(!email.contains(Character.toString('@'))){System.out.println("Formato mail non valido "); return false;}
    	
    	Utente nuovo = new Utente();
    	nuovo.defUtente(nome , cognome , email , username , password , count);
    	regUser.add(nuovo);
    	System.out.println("REGISTRAZIONE ESEGUITA !");
    	
    	return true;
    }
    
    /**
     * Operation
     *
     * @return boolean
     */
    public boolean logout ()
    {
		System.out.println("Logout Eseguito");
		this.loggato = false;
		return true;
    }

    /**
     * Operation
     *
     * @return boolean
     */
    public boolean modificaDatiPersonali (String newNome , String newCognome , String newEmail)
    {
	    	this.setNome(newNome);
	    	this.setCognome(newCognome);
	    	this.setEmail(newEmail);
	    	if(this.getNome() == "" || this.getCognome() == "" || this.getEmail() == ""){return false;}
	    	return true;
    }
    
   
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean getLoggato() {
		return loggato;
	}
	
	public void setLoggato(boolean loggato) {
		this.loggato = loggato;
	}
	public String getPassword() {
		return password;
	}
	
    
	
}

