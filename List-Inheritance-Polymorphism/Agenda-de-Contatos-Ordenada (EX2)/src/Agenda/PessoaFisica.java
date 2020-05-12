package Agenda;

// Subclasse da classe Pessoa
public class PessoaFisica extends Contatos{
	
	private String CPF, estadoCivil, dataNascimento;
	
	// Construtor
	public PessoaFisica (String nomeContato, String endereco, String email, String CPF, String estadoCivil, String dataNascimento) {
		super (nomeContato, endereco, email);
		this.CPF = CPF;
		this.estadoCivil = estadoCivil;
		this.dataNascimento = dataNascimento;
	}
	
	// Getters dos atributos
	public String getCPF () {
		return CPF;
	}
	
	public String getEstadoCivil () {
		return estadoCivil;
	}
	
	public String getdataNascimento () {
		return dataNascimento;
	}
	
	
}
