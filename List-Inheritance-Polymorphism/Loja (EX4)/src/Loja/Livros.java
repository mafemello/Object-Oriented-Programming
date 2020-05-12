package Loja;

public class Livros extends Produtos {

int quantidade;
	
	public Livros (String codigoBarras, String nome, int quantidade) {
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
