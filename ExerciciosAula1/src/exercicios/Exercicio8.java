package exercicios;
import java.io.IOException;

public class Exercicio8 {
	public static void main(String[] args) throws IOException {
		
		double aprox;
		int iteracoes = 0;
		
		System.out.print("Digite uma aproximicao para o valor da raiz: ");
		//tratamento de excecao
		while (true) {	
			try {
				aprox = EntradaTeclado.leDouble();
				break;
			} catch (Exception e) {
				System.out.print("Valor invalido. Tente Novamente.");
				System.out.println();
			}
		}
		
		//calcula f(x) com x = aproximacao dada pelo usuario
		double faprox = (Math.pow (aprox, 3) - Math.pow (aprox, 2) - (13*aprox) + 8);
		
		//calcula f'(x) com x = aproximacao dada pelo usuario (tangente no ponto)
		double ftgaprox = 3*(Math.pow(aprox, 2)) - (2*aprox) - 13;
		
		double inicial = (faprox/ftgaprox);		
		
		while (inicial >= 0.0000001) {
			faprox = (Math.pow (aprox, 3) - Math.pow (aprox, 2) - (13*aprox) + 8);
			ftgaprox = 3*(Math.pow(aprox, 2)) - (2*aprox) - 13;
			inicial = (faprox/ftgaprox);
			aprox = aprox - inicial;
			iteracoes ++;
		}	
		System.out.print("O valor da raiz eh: " + aprox);
		System.out.println();
		System.out.print("Numero de iteracoes: " + iteracoes);		
	}
}
