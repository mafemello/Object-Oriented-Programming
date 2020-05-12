package Agenda;

public class Agenda {

	private Contatos contatos[] = new Contatos[100];
	private int numContatos = 0;
	private int numPF = 0; // Quantidade de pessoa física

	// Função principal	
	public static void main (String[] args) throws Exception {
		int opcao = 0;
		Agenda a = new Agenda();
		
		System.out.println ("Bem vindo a agenda eletronica!!!!!\n");
		
		// Loop principal
		while (opcao != 6) {
			opcao = Agenda.leOpcao();
			
			switch (opcao) {
				case 1 : // INSERE PESSOA FÍSICA
					
					// Leitura dos dados para inserção
					System.out.println ("Nome do contato: ");
					String nome = EntradaTeclado.leString();
					System.out.println ("Endereço: ");
					String endereco = EntradaTeclado.leString();
					System.out.println ("Email: ");
					String email = EntradaTeclado.leString();
					System.out.println ("CPF: ");
					String cpf = EntradaTeclado.leString();
					System.out.println ("Estado civil: ");
					String estadoCivil = EntradaTeclado.leString();					
					System.out.println ("Data de nascimento: ");
					String data = EntradaTeclado.leString();					
					
					PessoaFisica pf = new PessoaFisica (nome, endereco, email, cpf, estadoCivil, data); // Cria novo contato
					a.add (pf); // Adiciona na agenda
					System.out.println ("\n####### Contato adicionado #######\n");
					
					break;
					
					
				case 2: // INSERE PESSOA JURÍDICA
					
					// Leitura dos dados para inserção
					System.out.println ("Nome da empresa: ");
					nome = EntradaTeclado.leString();
					System.out.println ("Endereço: ");
					endereco = EntradaTeclado.leString();
					System.out.println ("Email: ");
					email = EntradaTeclado.leString();					
					System.out.println ("CNPJ: ");
					String cnpj = EntradaTeclado.leString();					
					System.out.println ("Inscrição estadual: ");
					String inscricao = EntradaTeclado.leString();										
					System.out.println ("Razão social: ");
					String razao = EntradaTeclado.leString();	
					
					PessoaJuridica pj = new PessoaJuridica (nome, endereco, email, cnpj , inscricao, razao); // Cria novo contato
					a.add (pj); // Adiciona na agenda 
					System.out.println ("\n####### Contato adicionado #######\n");
					
					break;
				
				case 3: // REMOVE QUALQUER CONTATO
					
					System.out.println ("Qual contato deseja remover? Digite o nome:");
					String removerContato = EntradaTeclado.leString();
					Contatos pesquisaContato = a.pesquisaContato(removerContato); // Procura o contato desejado na agenda
					
					if (pesquisaContato != null) {
						pesquisaContato.setAgenda(false);
						System.out.println ("\n####### Contato removido #######\n");
					} else {
						System.out.println ("\n####### Contato NÃO existe #######\n");
					}
					
					break;
			
				case 4: // Procura um contato na agenda

					System.out.println ("Qual contato deseja procurar? Digite o nome: ");
					String qualContato = EntradaTeclado.leString();
					pesquisaContato = a.pesquisaContato(qualContato);
					
					if (pesquisaContato != null) {
						a.printaContatos (pesquisaContato);
					} else {
						System.out.println ("\n####### Contato NÃO existe #######\n");
					}
					
					break;
					
				case 5: // Visualiza todos os contatos
					a.printaContatos();
					break;
			
				case 6: // Finaliza o programa
					System.out.println("Terminando o programa....\n");
					return;
					
			} // fim do switch
			
			System.out.println("Digite ENTER para continuar... ");
			EntradaTeclado.leString();
			System.out.println("\n");
		
		} //fim do while
	} //fim da main
	
	
	// Função que lê a opção desejada e trata casos de exceção
	private static int leOpcao () {
		System.out.println ("Digite '1' para adicionar contatos de PESSOA FÍSICA. \nDigite '2' para adicionar contatos de PESSOA JURÍDICA. \nDigite '3' remover um contato. \nDigite '4' para pesquisar um contato. \nDigite '5' para visualizar todos os contatos");
		System.out.println ("\n*** PARA SAIR DA AGENDA DIGITE '6' ***\n");		
		int op = -1;
		
		while (true) {
			System.out.println ("Digite a opção desejada: ");
			try { // Tratamento de exceções
				op = EntradaTeclado.leInt();
				if (op > 0 && op < 7) {
					return op;
				}
			} catch (Exception e) {
				;
			}
		}		
	}
	
	
	// Função que adiciona contatos na agenda
	private void add (Contatos c) {
		contatos[numContatos++] = c;	
		if (c instanceof PessoaFisica) {
			++numPF;
		}
		ordenaAgenda();
	}
	
	
	// Função que percorre todos os contatos para imprimir
	private void printaContatos () {
		for (Contatos c : contatos) { // Percorre todos os contatos da agenda
			if (c == null) {
				break; 
			}
			printaContatos (c); // Imprime cada um dos contatos
		}
	}
	
	
	// Função printa todos os contatos
	private void printaContatos (Contatos c) {
		
		if (c != null && c.estaNaAgenda()) {	// Se o contato tem a flag true, então imprime
			System.out.println ("Nome do contato: " + c.getNomeContato());
			System.out.println ("Email: " + c.getEmail());
			System.out.println ("Endereço: " + c.getEndereco());
			if (c instanceof PessoaFisica) { // Se pessoa fisica: 
				System.out.println("CPF: "+((PessoaFisica)c).getCPF());
				System.out.println("Estado Civil: "+((PessoaFisica)c).getEstadoCivil());
				System.out.println("Data de nascimento: "+((PessoaFisica)c).getdataNascimento());
			} else if (c instanceof PessoaJuridica) { // Se pessoa jurídica: 
				System.out.println("CNPJ: "+((PessoaJuridica)c).getCNPJ());
				System.out.println("Inscrição estadual: "+((PessoaJuridica)c).getInscricaoEstadual());
				System.out.println("Razão social: "+((PessoaJuridica)c).getRazaoSocial());
			}
			System.out.println();
		}
	}
	
	
	// Função que pesquisa os contatos
	private Contatos pesquisaContato (String removerContato) {
		
		for (Contatos c : contatos) { // Percorre todos os contatos 
			if (c == null) break; // Se igual a null, para
			if (c.estaNaAgenda()) { // Se existe, imprime
				if (c.getNomeContato().equals(removerContato)) {
					return c;
				}
				if (c instanceof PessoaFisica) {
					if(((PessoaFisica)c).getCPF().equals(removerContato)) 
						return c;
				}
				if (c instanceof PessoaJuridica) {
					if(((PessoaJuridica)c).getCNPJ().equals(removerContato)) 
						return c;
				}
			}
		}
		return null;
	}
	
	
	
	// Função que ordena os contatos em ordem crescente de CPF e CNPJ
	public void ordenaAgenda () {
		for (int i = 0; i < numContatos; i++) { // Loop percorre todos os contatos
			for (int j = 0; j < (numContatos -i -1); j++) { // Loop compara todos os contatos
				if (contatos[j+1] instanceof PessoaFisica) { // Se for Pessoa Física, aparece antes que Pessoa Jurídica na agenda
					Contatos aux = contatos[j+1]; // Faz a troca
					contatos[j+1] = contatos[j];
					contatos[j] = aux;
				}
			}
		}
		
		for (int i = 0; i < numPF; i ++) { // Loop percorre todos os contatos de Pessoa Fisica
			for (int j = 0; j < (numPF -i -1); j++) { // Loop compara
				if(((PessoaFisica)contatos[j+1]).getCPF().compareTo(((PessoaFisica)contatos[j]).getCPF()) < 0) { // Compara os CPFs
					Contatos aux = contatos[j+1]; // Faz a troca
					contatos[j+1] = contatos[j];
					contatos[j] = aux;
				}
			}
		}
		
		int k = 0; // Variavel auxiliar para troca
		for (int i = numPF; i < numContatos; i++) { // Loop percorre todos os contatos de Pessoa Jurídica
			for (int j = numPF; j < (numContatos -k -1); j ++) { // Loop compara
				if(((PessoaJuridica)contatos[j+1]).getCNPJ().compareTo(((PessoaJuridica)contatos[j]).getCNPJ()) < 0){ // Compara os CNPJs
					Contatos aux = contatos[j+1]; // Faz a troca
					contatos[j+1] = contatos[j];
					contatos[j] = aux;
				}
			}
			k++;
		}
		
	}
	
	
}
