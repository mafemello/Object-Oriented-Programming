package Agenda;

// Subclasse da classe pessoa
public class PessoaJuridica extends Contatos {

	private String CNPJ, inscricaoEstadual, razaoSocial;
	
	// Construtor
	public PessoaJuridica (String nomeContato, String endereco, String email, String CNPJ, String inscricaoEstadual, String razaoSocial) {
		super (nomeContato, endereco, email);
		this.CNPJ = CNPJ;
		this.inscricaoEstadual = inscricaoEstadual; 
		this.razaoSocial = razaoSocial;
	}
	
	// Getters dos atributos
	public String getCNPJ () {
		return CNPJ;
	}
	
	public String getInscricaoEstadual () {
		return inscricaoEstadual;
	}

	public String getRazaoSocial () {
		return razaoSocial;
	}	
}
