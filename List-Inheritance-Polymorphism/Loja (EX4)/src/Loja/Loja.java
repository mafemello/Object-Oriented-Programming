package Loja;

public class Loja {

	private Produtos produtos[] = new Produtos[100];
	private int numProdutos = 0;
	private static int numCD = 0;
	private static int numDVD = 0;
	private static int numLivros = 0;
	
	// Construtor
	public Loja () {
		Loja.numCD = 0;
		Loja.numDVD = 0;
		Loja.numLivros = 0;
	}
	
	public static int getNumCD () {
		return numCD;
	}
	
	public static int getNumDVD () {
		return numDVD;
	}
	
	public static int getNumL () {
		return numLivros;
	}
	
	public void setNumCD (int numCD) {
		Loja.numCD = numCD;
	}
	
	public void setNumDVD (int numDVD) {
		Loja.numDVD = numDVD;
	}
	
	public void setNumL (int numLivros) {
		Loja.numLivros = numLivros;
	}
	
	public static void main (String[] args) throws Exception {
		int opcao = 0;
		Loja l = new Loja();
		
		System.out.println ("Bem vindo a loja digital!!!!!\n");
		
		while (opcao != 7) {
			opcao = Loja.leOpcao();
			
			switch (opcao) {
				case 1 : // Adicionar CD
					System.out.println ("Nome do CD: ");
					String nome = EntradaTeclado.leString();
					System.out.println ("Quantidade: ");
					int quantidade = EntradaTeclado.leInt();
					System.out.println ("Código de barra: ");
					String CB = EntradaTeclado.leString();
					
					CDs cd = new CDs (CB, nome, quantidade);
					l.add (cd, quantidade);
					System.out.println ("\n####### Produto adicionado #######\n");
					break;
					
				case 2: // Adicionar DVD
					System.out.println ("Nome do DVD: ");
					nome = EntradaTeclado.leString();
					System.out.println ("Quantidade: ");
					quantidade = EntradaTeclado.leInt();
					System.out.println ("Código de barra: ");
					CB = EntradaTeclado.leString();
					
					DVDs dvd = new DVDs (CB, nome, quantidade);
					l.add (dvd, quantidade);
					System.out.println ("\n####### Produto adicionado #######\n");
					break;
					
				case 3: // Adicionar Livro
					System.out.println ("Nome do livro: ");
					nome = EntradaTeclado.leString();
					System.out.println ("Quantidade: ");
					quantidade = EntradaTeclado.leInt();
					System.out.println ("Código de barra: ");
					CB = EntradaTeclado.leString();
					
					Livros lv = new Livros (CB, nome, quantidade);
					l.add (lv, quantidade);
					System.out.println ("\n####### Produto adicionado #######\n");
					break;
					
				case 4: // Pesquisar um produto
					System.out.println ("Qual produto deseja pesquisar? Digite o nome ou código de barras: ");
					String prod = EntradaTeclado.leString();
					Produtos pesquisaProduto = l.pesquisaProduto(prod);			
					
					if (pesquisaProduto != null) {
						l.printaProdutos (pesquisaProduto);
					} else {
						System.out.println ("\n####### Produto NÃO existe #######\n");
					}					
					break;
				
				case 5: // Vender produto
					System.out.println ("Qual produto deseja vender? Digite o código de barras: ");
					prod = EntradaTeclado.leString();
					System.out.println ("Quantidade de produtos que deseja vender: ");
					int qntd = EntradaTeclado.leInt();
					pesquisaProduto = l.pesquisaProduto(prod, qntd); // Procura o produtos desejado no estoque
					
					if (pesquisaProduto != null) {
						if (pesquisaProduto instanceof CDs) {
							CDs p1 = (CDs)pesquisaProduto;
							if (p1.getQuantidade() == qntd) {
								pesquisaProduto.setProduto(false);
								System.out.println("#### Produto vendido com sucesso! ####");
							}
							if (p1.getQuantidade() == 0) {
								System.out.println ("Erro! Não existem mais CDs no estoque.\n");
							}
							if (p1.getQuantidade() < qntd) {
								System.out.println ("Erro! Não existem produtos suficientes no estoque para efetuar a venda.\n");
							} else if (p1.getQuantidade() > qntd) {
								p1.setQuantidade(p1.getQuantidade() - qntd);
								int resto = p1.getQuantidade();
								System.out.print ("Foram vendidos " + qntd);
								System.out.println (" produtos. Restam no estoque: " + resto);
								System.out.println();
							}
						}
						if (pesquisaProduto instanceof DVDs) {
							DVDs p1 = (DVDs)pesquisaProduto;
							if (p1.getQuantidade() == qntd) {
								pesquisaProduto.setProduto(false);
								System.out.println("#### Produto vendido com sucesso! ####");
							}
							if (p1.getQuantidade() == 0) {
								//pesquisaProduto.setProduto(false);
								System.out.println ("Erro! Não existem mais CDs no estoque.\n");
							}
							if (p1.getQuantidade() < qntd) {
								//pesquisaProduto.setProduto(false);
								System.out.println ("Erro! Não existem produtos suficientes no estoque para efetuar a venda.\n");
							} else if (p1.getQuantidade() > qntd) {
								p1.setQuantidade(p1.getQuantidade() - qntd);
						
								int resto = p1.getQuantidade();
								System.out.print ("Foram vendidos " + qntd);
								System.out.println (" produtos. Restam no estoque: " + resto);
								System.out.println();
							}
						}
						if (pesquisaProduto instanceof Livros) {
							Livros p1 = (Livros)pesquisaProduto;
							if (p1.getQuantidade() == qntd) {
								pesquisaProduto.setProduto(false);
								System.out.println("#### Produto vendido com sucesso! ####");
							}
							if (p1.getQuantidade() == 0) {
								System.out.println ("Erro! Não existem mais CDs no estoque.\n");
							}
							if (p1.getQuantidade() < qntd) {
								System.out.println ("Erro! Não existem produtos suficientes no estoque para efetuar a venda.\n");
							} else if (p1.getQuantidade() > qntd) {
								p1.setQuantidade(p1.getQuantidade() - qntd);
						
								int resto = p1.getQuantidade();
								System.out.print ("Foram vendidos " + qntd);
								System.out.println (" produtos. Restam no estoque: " + resto);
								System.out.println();
							}
						}					
					} else if (pesquisaProduto == null){
						System.out.println ("\n####### Produto NÃO existe ou entrada inválida #######\n");
					}
					break;
					
				case 6: // Visualiza todos os produtos em estoque
					l.printaProdutos ();					
					break;
					
				case 7: // Finaliza o programa
					System.out.println("Terminando o programa....\n");
					return;				
					
			} //switch
			System.out.println("Digite ENTER para continuar... ");
			EntradaTeclado.leString();
			System.out.println("\n");
		} // while
	} // main
	
	// Função que le opcao
	private static int leOpcao () {
		System.out.println ("Digite '1' para adicionar CDs. \nDigite '2' para adicionar DVDs. \nDigite '3' adicionar Livros. \nDigite '4' para pesquisar um produto. \nDigite '5' para vender produto. \nDigite '6' para visualizar todos os produtos disponíveis em estoque.\n");
		System.out.println ("\n*** PARA SAIR DA LOJA DIGITE '7' ***\n");		
		int op = -1;
		
		while (true) {
			System.out.println ("Digite a opção desejada: ");
			try { // Tratamento de exceções
				op = EntradaTeclado.leInt();
				if (op > 0 && op < 8) {
					return op;
				}
			} catch (Exception e) {
				;
			}
		}		
	}
	
	// Função que adiciona produtos no sistema
	private void add (Produtos p, int qntd) {
		if (qntd < 0 ) {
			System.out.println ("Erro! Insira uma quantidade inteira e maior que zero.");
		}
		produtos[numProdutos++] = p;	
		if (p instanceof CDs) {
			CDs p1 = (CDs)p;
			p1.setQuantidade(p1.getQuantidade());
			this.setNumCD(Loja.getNumCD());
		}
		if (p instanceof DVDs) {
			DVDs p1 = (DVDs)p;
			p1.setQuantidade(p1.getQuantidade());
			this.setNumDVD(Loja.getNumDVD());
		}
		if (p instanceof Livros) {
			Livros p1 = (Livros)p;
			p1.setQuantidade(p1.getQuantidade());
			this.setNumL(Loja.getNumL());
		}	
	}
	
	
	// Função que percorre todos os produtos para imprimir
	private void printaProdutos () {
		for (Produtos p : produtos) { // Percorre todos os produtos em estoque
			if (p == null) {
				break; 
			}
			printaProdutos (p); // Imprime cada um dos produtos
		}
	}
	
	
	// Função printa todos os produtos
	private void printaProdutos (Produtos p) {
		
		if (p != null && p.getEstaNaLoja()) {
			System.out.println ("Nome do produto: " + p.getNome());
			System.out.println ("Código de Barra: " + p.getCB());
			
			if (p instanceof CDs) {
				CDs p1 = (CDs)p;
				this.setNumCD(Loja.getNumCD());
				System.out.println ("Quantidade de CDs no estoque: " + ((CDs)p1).getQuantidade());
			} else if (p instanceof DVDs) {
				System.out.println ("Quantidade de DVDs no estoque: " + ((DVDs)p).getQuantidade());
			} else if (p instanceof Livros) {
				System.out.println ("Quantidade de livros no estoque: " + ((Livros)p).getQuantidade());
			}
		}
		System.out.println();
	}

	// Função que pesquisa os produtos
	private Produtos pesquisaProduto (String prod) {
		
		for (Produtos p : produtos) { // Percorre todos os produtos 
			if (p == null) break; // Se igual a null, para
			if (p.getEstaNaLoja()) { // Se existe, imprime
				if (p.getNome().equals(prod) || p.getCB().contentEquals(prod)) {
					return p;
				}
			}
		}
		return null;
	}
	
	private Produtos pesquisaProduto (String prod, int qntd) {
		if (qntd < 0 ) {			
			System.out.println ("Erro! Insira uma quantidade inteira e maior que zero.");
			return null;
		}
	
		for (Produtos p : produtos) { // Percorre todos os produtos 
			if (p == null) break; // Se igual a null, para
			if (p.getEstaNaLoja()) { // Se existe, imprime
				if (p.getNome().equals(prod) || p.getCB().contentEquals(prod)) {
					if (p instanceof CDs) {
						numCD = ((CDs)p).getQuantidade() - qntd;
					}
					if (p instanceof DVDs) {
						numDVD = ((DVDs)p).getQuantidade() - qntd;
					}
					if (p instanceof Livros) {
						numLivros = ((Livros)p).getQuantidade() - qntd;
					}	
			
					return p;
				}
			}
		}
		return null;
	}
}
