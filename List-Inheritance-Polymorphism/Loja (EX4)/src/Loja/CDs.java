package Loja;

public class CDs extends Produtos {
	
	int quantidade;
	
	public CDs(String codigoBarras, String nome, int quantidade) {
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
