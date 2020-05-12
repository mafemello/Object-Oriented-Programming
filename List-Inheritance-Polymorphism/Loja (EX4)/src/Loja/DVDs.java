package Loja;

public class DVDs extends Produtos {

	// Caracteristicas do DVD
	int quantidade;
	
	public DVDs(String codigoBarras, String nome, int quantidade) {
		super(codigoBarras, nome);
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
