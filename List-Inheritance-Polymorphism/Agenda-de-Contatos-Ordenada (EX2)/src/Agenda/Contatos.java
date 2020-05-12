package Agenda;

// Superclasse ==> guarda nome do contato, endereço e email
public class Contatos {
	
	private String nomeContato, endereco, email;
	private boolean existe; // Flag que indica se o contato está ou não na agenda
	
	// Construtor da classe 
	public Contatos (String nomeContato, String endereco, String email) {
		this.nomeContato = nomeContato;
		this.endereco = endereco;
		this.email = email;
		this.existe = true;
	}

	// Setter para marcar que o contato está na agenda
	public void setAgenda(boolean existe){
		this.existe = existe;
	}
	
	// Getters
	public boolean estaNaAgenda (){
		return existe;
	}
	
	public String getNomeContato () {
		return nomeContato;
	}
	
	public String getEndereco () {
		return endereco;
	}
	
	public String getEmail () {
		return email;
	}
}
