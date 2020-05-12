package Loja;

// Superclasse
public class Produtos {
	
	String codigoBarras; 
	String nome; // Caracteristica comum de todos os produtos da loja
	private boolean existe;
	
	// Construtor
	public Produtos (String codigoBarras, String nome) {
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.existe = true;
	}
	
	// Setter para marcar que o contato está na agenda
	public void setProduto(boolean existe){
		this.existe = existe;
	}
	
	// Getters
	public boolean getEstaNaLoja (){
		return existe;
	}
	
	// Getters
	public String getCB () {
		return codigoBarras;
	}
	
	public String getNome () {
		return nome;
	}
	
	// Setter
	public void setCB (String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
}
