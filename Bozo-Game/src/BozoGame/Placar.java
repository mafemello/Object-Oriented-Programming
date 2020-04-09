/*
 	Aluna: Maria Fernanda Lucio de Mello
 	NºUSP: 11320860
 	author: @mafemello
 */

package BozoGame;
import java.util.Arrays;

/*
 	Esta classe representa o placar de um jogo de Bozó. Permite que combinações de dados 
 	sejam alocadas às posições e mantém o score de um jogador.
 */
public class Placar {

	int placar[] = new int[10]; // Vetor que vai guardar o valor da pontuação em cada posição do placar.
	
	// Método que inicializa o placar ==> todas posições começam com -1 pontos.
	public Placar() {
		for (int i = 0; i < 10; i++) {
			placar[i] = -1;
		}
	}
	
	/*
	 	Adiciona uma sequencia de dados em uma determinada posição do placar. 
	 	Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
	 */
	public void add (int posicao, int[] dados) throws java.lang.IllegalArgumentException {
		
		// Se os paramentos forem invalidos ou se a posicao ja estiver ocupada, existe erro.
		if (posicao < 1 || posicao > 10 || placar[posicao-1] != -1) {
			throw new IllegalArgumentException ("Parâmetros inválidos ou a posição escolhida já está ocupada. Por favor, tente novamente.\n"); 
		}
		
		// A frequência de dados será utilizada para calcular os pontos da quadra e da quina
		int frequenciaDados[] = {0, 0, 0, 0, 0, 0}; 
		int quadra = 0;
		int quina = 0;

		// Índice de frequência dos dados
		for (int i = 0; i < dados.length; i++) {
			int pos = dados[i] - 1; // Referente a cada dado
			frequenciaDados[pos]++;
			
			if (frequenciaDados[pos] == 4) {
				quadra ++;
			} else if (frequenciaDados[pos] == 5) {
				quina ++;
			}
		}
		
		// Contagem de pontos para cada posição
		switch (posicao) {

		 	//De 1 a 5 = faz contagem normal dos pontos ==> quantiadae de dados com o número da posição * posição.		 		 
			case 1:
				int contador1 = 0;
				int dadoAtual1 = 1;
				for (int i = 0; i < 5; i++) {
					if (dados[i] == dadoAtual1) {
						contador1++;
					}
				}
				placar[0] = dadoAtual1*contador1;
				break;

			case 2:
				int contador2 = 0;
				int dadoAtual2 = 2;
				for (int i = 0; i < 5; i++) {
					if (dados[i] == dadoAtual2) {
						contador2++;
					}
				}
				placar[1] = dadoAtual2*contador2;
				break;

			case 3:
				int contador3 = 0;
				int dadoAtual3 = 3;
				for (int i = 0; i < 5; i++) {
					if (dados[i] == dadoAtual3) {
						contador3++;
					}
				}
				placar[2] = dadoAtual3*contador3;
				break;

			case 4:
				int contador4 = 0;
				int dadoAtual4 = 4;
				for (int i = 0; i < 5; i++) {
					if (dados[i] == dadoAtual4) {
						contador4++;
					}
				}
				placar[3] = dadoAtual4*contador4;
				break;

			case 5:
				int contador5 = 0;
				int dadoAtual5 = 5;
				for (int i = 0; i < 5; i++) {
					if (dados[i] == dadoAtual5) {
						contador5++;
					}
				}
				placar[4] = dadoAtual5*contador5;
				break;

			case 6:
				int contador6 = 0;
				int dadoAtual6 = 6;
				for (int i = 0; i < 5; i++) {
					if (dados[i] == dadoAtual6) {
						contador6++;
					}
				}
				placar[5] = dadoAtual6*contador6;
				break;

			case 7: // FULL HAND
				Arrays.sort(dados); // Ordena os valores dos dados para compara-los facilmente
				boolean flagFullHand = false;

				// Se a trinca estiver no começo do array ordenado
				if (dados[0] == dados[1] && dados[0] == dados[2] && dados[3] == dados[4]) {
					flagFullHand = true;
				}

				// Se a dupla estiver no começo do array ordenado
				if (dados[0] == dados[1] && dados[2] == dados[3] && dados[2] == dados[4]) {
					flagFullHand = true;
				}

				if (flagFullHand == true) {
					placar[6] = 15;
				} else {
					placar[6] = 0;
				}
				break;

			case 8: // SEQUENCIA (de 1 a 5 ou de 2 a 6)
				int contador8 = 0;
				
				// Compara se os números são diferentes
				for (int i = 0; i < 5; i ++) {
					for (int j = 0; j < 5; j++) {
						if (dados[i] == dados[j]){
							contador8++;
						}
					}
				}

				if (contador8 == 5) {
					placar[7] = 20;
				} else {
					placar[7] = 0;
				}
				break;

			case 9: // QUADRA
				if (quadra >= 1) {
					placar[8] = 30;
				} else {
					placar[8] = 0;
				}
				break;

			case 10: // QUINA
				if (quina >= 1) {
					placar[9] = 40;
				} else {
					placar[9] = 0;
				}
				break;
		}
	}


	/*
	 	Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
	 */
	public int getScore () {
		int resultadoSomaFinal = 0;

		for (int i = 0; i < 10; i++) {
			resultadoSomaFinal += placar[i];
		}
		return resultadoSomaFinal;
	}

	/*
	 	A representação na forma de string, mostra o placar completo, 
	 	indicando quais são as posições livres (com seus respectivos números) e 
	 	o valor obtido nas posições já ocupadas. 
	 */
	@Override
	public java.lang.String toString () {
/*		String mostrarPlacar = " (1)    |    (7)    |    (4)  "+
								"-----------------------------"+
							   " (2)    |    (8)    |    (5)  "+
								"-----------------------------"+	
							   " (3)    |    (9)    |    (6)  "+
								"-----------------------------"+
							   "        |    (10)   |         "+
							   "        +-----------+         ";

*/

		String placarPronto = "\n";
		getScore();

		if (placar[0] == -1) {
			placarPronto += " (1)    ";
		} else {
			placarPronto += " " + placar[0] + "    ";
		}
		placarPronto += " | ";

		if (placar[6] == -1) {
			placarPronto += "    (7)    ";
		} else {
			placarPronto += "    " + placar[6] + "    ";
		}
		placarPronto += " | ";

		if (placar[3] == -1) {
			placarPronto += "    (4)  ";
		} else {
			placarPronto += "    "+ placar[3] +"    ";
		}
		placarPronto += "\n";
		placarPronto += "--------------------------------\n";

		
		
		if (placar[1] == -1) {
			placarPronto += " (2)    ";
		} else {
			placarPronto += " "+ placar[1] +"    ";
		}
		placarPronto += " | ";

		if (placar[7] == -1) {
			placarPronto += "    (8)    ";
		} else {
			placarPronto += "    "+ placar[7] +"    ";
		}
		placarPronto += " | ";

		if (placar[4] == -1) {
			placarPronto += "    (5)  ";
		} else {
			placarPronto += "    "+ placar[4] +"  ";
		}
		placarPronto += "\n";
		placarPronto += "--------------------------------\n";

		
		
		if (placar[2] == -1) {
			placarPronto += " (3)    ";
		} else {
			placarPronto += " "+ placar[2] +"    ";
		}
		placarPronto += " | ";

		if (placar[8] == -1) {
			placarPronto += "    (9)    ";
		} else {
			placarPronto += "    "+ placar[8] +"    ";
		}
		placarPronto += " | ";

		if (placar[5] == -1) {
			placarPronto += "    (6)  ";
		} else {
			placarPronto += "    "+ placar[5] +"  ";
		}
		placarPronto += "\n";
		placarPronto += "--------------------------------\n";

		
		
		if (placar[9] == -1) {
			placarPronto += "         |    (10)     |         ";
		} else {
			placarPronto += "         |"+"    "+ placar[9] +"    "+"|        ";
		}
		placarPronto += "\n";
		placarPronto += "         +-------------+        \n\n";

		return placarPronto;
	}
}
