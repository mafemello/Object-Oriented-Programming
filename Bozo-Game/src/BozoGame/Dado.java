/*
 	Aluna: Maria Fernanda Lucio de Mello
 	NºUSP: 11320860
 	@author mafemello
 */

package BozoGame;

/*
 	Simula um dado de número de lados variados. Ao criar o objeto é possível estabelecer o 
 	número de lados. A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
 */
public class Dado {

	public int lado; // Representa a quantidade de lados
	public int faceAtual; // Representa a face rolada
	Random auxiliar; // Cria numero aleatorio

	// Cria objeto com numero qualquer de lados.
	public Dado (int n) {
		this.lado = n;
		auxiliar = new Random();
	}

	// Cria um dado com 6 lados (um cubo).
	public Dado () { 
		this.lado = 6;
		auxiliar = new Random();
	} 

	// Recupera (retorna) o último número selecionado.
	public int getLado () {
		return faceAtual;
	}
	
	 public void setLado (int lado) {
	        this.lado = lado;
	 }

	/* 
	 	Simula a rolagem do dado por meio de um gerador aleatório. 
	 	O número selecionado pode posteriormente ser recuperado com a chamada a getLado().
	 	Retorna o número que foi sorteado.
	*/
	public int rolar () {
		faceAtual = (auxiliar.getIntRand(1, this.lado+1)); //this.lados = 6 ==> escolhe numeros aleatorios de 1 a 6
		return faceAtual;
	}

	/* 
	  	Transforma representação do dado em String. É mostrada uma representação 
	  	do dado que está para cima. Note que só funciona corretamente para dados de 6 lados.
	*/
	@Override
	public java.lang.String toString () {

		switch (faceAtual) {
			case 1:
				return  "+-----+" +
						"|     |" +
						"|  *  |" +
						"|     |" +
						"+-----+";
			case 2:
				return  "+-----+" +
						"| *   |" +
						"|     |" +
						"|   * |" +
						"+-----+";
			case 3:
				return  "+-----+" +
						"| *   |" +
						"|  *  |" +
						"|   * |" +
						"+-----+";
			case 4:
				return  "+-----+" +
						"| * * |" +
						"|     |" +
						"| * * |" +
						"+-----+";
			case 5:
				return  "+-----+" +
						"| * * |" +
						"|  *  |" +
						"| * * |" +
						"+-----+";
			case 6:
				return  "+-----+" +
						"| *** |" +
						"|     |" +
						"| *** |" +
						"+-----+";
			
			default: 
				return ""+faceAtual;
		}	
	}
}