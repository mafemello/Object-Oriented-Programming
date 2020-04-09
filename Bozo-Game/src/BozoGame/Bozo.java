/*
 	Aluna: Maria Fernanda Lucio de Mello
 	NºUSP: 11320860
 	author: @mafemello
 */

package BozoGame;
import java.io.IOException;

public class Bozo {
	
	/*
	 	Método inicial do programa. Ele cuida da execução do jogo e possui um laço, 
	 	no qual cada iteração representa uma rodada do jogo. Em cada rodada, o jogador 
	 	joga os dados até 3 vezes e depois escolhe a posição do placar que deseja preencher. 
	 	No final das rodadas a pontuação total é exibida.
	 */
	public static void main(java.lang.String[] args) throws java.io.IOException {
		
		// Inicializando os dados que serão lancados
		RolaDados dados = new RolaDados (5);
		Placar placar = new Placar ();
		
		String rolarDeNovo; // Recebe do usuário quais dados ele deseja rolar de novo
		int resultadosDadosSorteados[] = new int[5]; // Recebe os dados sorteados
		int numeroRodadas = 10;
		int posicao; // Posição usada para preencher o placar corretamente
		
		System.out.println ("\n********************** JOGO DE BOZÓ **********************");
		System.out.println (placar);
		
		// Inicia loop que representa as 10 rodadas
		for (int i = 0; i < numeroRodadas; i ++) {
			System.out.println ("*********** Rodada " + (i+1));
			System.out.println ("Pressione ENTER para lançar os dados");
			EntradaTeclado.leString();
			
			// Rola os dados e mostra pro usuario
			resultadosDadosSorteados = dados.rolar();
			System.out.println(dados.toString());
			System.out.println("Digite os números dos dados que quiser TROCAR, separados por espaços. Ou digite ENTER.");
			
			/*	
				Permite que usuário escolha se vai rolar os dados de novo ou nao.
				Se não for rolar (apertar ENTER), apresenta o placar; se escolher rolar, 
				o usuário escolhe quais dados são esses.
				Faz tratamento de exceção.
			*/
			while (true) {
				try {
					rolarDeNovo = EntradaTeclado.leString();
					break;
				} catch (Exception e) {
					System.out.println ("Entrada inválida. Por favor, tente novamente.");
				}
			}		
			
			if (!rolarDeNovo.equals ("")){
				resultadosDadosSorteados = dados.rolar(rolarDeNovo);
				System.out.println(dados.toString());
				
				System.out.println("Digite os números dos dados que quiser TROCAR, separados por espaços. Ou digite ENTER.");
				while (true) {
					try {
						rolarDeNovo = EntradaTeclado.leString();
						break;
					} catch (Exception e) {
						System.out.println ("Entrada inválida. Por favor, tente novamente.");
					}
				}			
				if (!rolarDeNovo.equals ("")) {
					resultadosDadosSorteados = dados.rolar(rolarDeNovo);
				}
				System.out.println(dados.toString());
			} else {
				System.out.println(dados.toString());
			}
			
			System.out.println("Seu placar atual:");
			System.out.println(placar.toString());
			System.out.println ("Escolha uma posição de 1 a 10 para ser ocupada ===>");
			
			// Tratamento de exceção para calcular a pontuação
			while (true) {
				try {
					posicao = EntradaTeclado.leInt();
					placar.add(posicao, resultadosDadosSorteados);
					break;
				} catch (Exception e) {
					System.out.println ("Posição inválida ou já preenchida. Por favor, tente novamente.");
				}
			}
			
			System.out.println("Seu placar atual:");
			System.out.println(placar.toString());
		}
		
		// Finaliza o programa e mostra o placar final :)
		System.out.println ("*********************************************");
		System.out.println ("***");
		System.out.println ("*** Seu score final foi: " + placar.getScore() + " pontos!!");
		System.out.println ("***");
		System.out.println ("*********************************************");
	}
}
