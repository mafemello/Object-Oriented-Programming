/*
 	Aluna: Maria Fernanda Lucio de Mello
 	NºUSP: 11320860
 	@author mafemello
 */
 
package BozoGame;
import java.lang.Integer;
import java.lang.String;

/*
 	Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente. 
 	Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
 */ 
public class RolaDados{

	public int quantidadeDados; // Quantidade de dados a serem rolados
	public Dado vetDados[]; // Vetor de dados que serão rolados

	/*
	 	Construtor que cria e armazena vários objetos do tipo Dado. 
	 	Usa para isso o construtor padrão daquela classe, ou seja, um dado de 6 lados e 
	 	gerando sempre uma semente aleatória para o gerador de números aleatórios. 
	 	Os dados criados podem ser referenciados por números, entre 1 e n.
	 */
	public RolaDados (int n) {
		this.quantidadeDados = n;
		vetDados = new Dado[n];
		
		for (int i = 0; i < n; i++) {
			vetDados[i] = new Dado();
			try {
				Thread.sleep (100/3*7); // Usado para que a semente seja diferente e aumente a randomização dos dados
			} catch (Exception e) {
				System.out.println (e);
			}
		}
	}

	/* Rola todos os dados*/
	public int[] rolar () {
		int facesMostrar[] = new int [quantidadeDados];

		for (int i = 0; i < quantidadeDados; i++) {
			facesMostrar[i] = vetDados[i].rolar();
		}
		return facesMostrar;
	} 

	// Rola alguns dos dados (escolhidos pelo usuário).
	public int[] rolar (boolean[] quais) {
		int facesMostrar [] = new int [quantidadeDados];
		
		for (int i = 0; i < quantidadeDados; i ++) {
			if (quais[i] == true) { // rolar de novo os dados escolhidos
				facesMostrar[i] = vetDados[i].rolar();
			} else { // apenas exibir o valor antigo dos dados nao escolhidos
				facesMostrar[i] = vetDados[i].getLado();
			} 
		}
		return facesMostrar;
	}


	/* Rola alguns dos dados*/
	public int[] rolar (java.lang.String s) {
		int facesMostrar[] = new int [quantidadeDados];
		String espacos[] = s.split(" ");
		int auxiliar; 
		
		// Transforma a String passa em int
		for (int i = 0; i < espacos.length; i ++) {
			try {
				auxiliar = Integer.parseInt(espacos[i]);
				if (auxiliar > 0 && auxiliar <= quantidadeDados) {
					vetDados[auxiliar-1].rolar();
				}
			} catch (NumberFormatException e) {
			}
		}

		// Todos os valores são atribuidos para o vetor
		for (int i = 0; i < quantidadeDados; i ++) {
			facesMostrar[i] = vetDados[i].getLado();
		}
		return facesMostrar;
	}
	
	
	/*
	 	Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto. 
	 	Exibe os dados horisontalmente.
	 */
	@Override
	public java.lang.String toString () {  
		
		// Exibe para o usuário os dados e os índices que o representam
		String mostraDados = " 1        2        3        4        5\n+-----+  +-----+  +-----+  +-----+  +-----+\n";
	 
		// Imprime cada dado de acordo com o número sorteado
		for (int i = 0; i < 5; i ++) {
			
			switch (vetDados[i].getLado()) { 
				case 1:
					mostraDados += "|     |  ";
					break;
				case 2: 
					mostraDados += "|*    |  ";
					break;
				case 3:
					mostraDados += "|*    |  ";
					break;
				case 4:
					mostraDados += "|*   *|  ";
					break;
				case 5:
					mostraDados += "|*   *|  ";
					break;
				case 6:
					mostraDados += "|*   *|  ";
					break;
			} 			
			if (i == 4) {
				mostraDados += "\n";
			}
		}

		for (int i = 0; i < 5; i ++) {
			
			switch (vetDados[i].getLado()) {
				case 1:
					mostraDados += "|  *  |  ";
					break;
				case 2:
					mostraDados += "|     |  ";
					break;
				case 3:
					mostraDados += "|  *  |  ";
					break;
				case 4:
					mostraDados += "|     |  ";
					break;
				case 5:
					mostraDados += "|  *  |  ";
					break;
				case 6:
					mostraDados += "|*   *|  ";
					break;
			
			}
			if (i == 4) {
				mostraDados += "\n";
			}
		}

		for (int i = 0; i < 5; i ++) {
			
			switch (vetDados[i].getLado()) {
				case 1:
					mostraDados += "|     |  ";
					break;
				case 2:
					mostraDados += "|    *|  ";
					break;
				case 3:
					mostraDados += "|    *|  ";
					break;
				case 4:
					mostraDados += "|*   *|  ";
					break;
				case 5:
					mostraDados += "|*   *|  ";
					break;
				case 6:
					mostraDados += "|*   *|  ";
					break;
			
			}			
			if (i == 4) {
				mostraDados += "\n";
			}
		}

		mostraDados += "+-----+  +-----+  +-----+  +-----+  +-----+\n";
        return mostraDados;
	}
}