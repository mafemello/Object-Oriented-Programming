/*
Use o método da bisseção para achar as raízes 
da equação x³ – x² – 13x + 8 com erro inferior a 10-7. 
Mostre o resultado e o número de iterações necessárias. 
O intervalo inicial deve ser fornecido pelo usuário.
*/

package exercicios;

import java.io.IOException;

public class Exercicio7 {

	public static void main(String[] args) throws IOException {
		
		double ini;
		double fim;		
		
		//pede para o usuario colocar o intervalo que sera pesquisado
		System.out.print("Qual o primeiro valor do intervalo? ");		
		//tratamento de excecao
		try {
			ini = EntradaTeclado.leDouble();
		} catch (Exception e) {
			System.out.print ("O valor que voce digitou nao eh valido. Tente novamente.");
			System.out.println();
			return;
		}
		
		System.out.print("Qual o valor final do intervalo? ");
		//tratamento de excecao
		while (true) {
			try {
				fim = EntradaTeclado.leDouble();
				break;
			} catch (Exception e) {
				System.out.print ("O valor que voce digitou nao eh invalido. Tente novamente.");
				System.out.println();
			}
		}
		double ponto_medio = 1; 
		int iteracoes = 0;
		
		//agora faz f(a), f(b), e f(c)
		//a funcao tem que chegar o mais prox possivel de 0
		double fini = (Math.pow (ini, 3) - Math.pow (ini, 2) - (13*ini) + 8);
		double ffim = (Math.pow (fim, 3) - Math.pow (fim, 2) - (13*fim) + 8);
		double fmeio = 1;
		
		//garante que a funcao passa pelo zero
		if (fini*ffim < 0) {
			while (Math.abs(fmeio) >= 0.0000001) {
				ponto_medio = ((ini+fim)/2);
				fmeio = (Math.pow (ponto_medio, 3) - Math.pow (ponto_medio, 2) - (13*ponto_medio) + 8);
				if (Math.abs(fmeio) <= 0.0000001) {
					break;
				}
				if (fini * fmeio < 0) {
					fim = ponto_medio;
				} else { 
					ini = ponto_medio;
				}
				iteracoes++;
			}
		}
		System.out.print ("O valor da raiz é: " + ponto_medio);
		System.out.println();
		System.out.print ("A quantidade de iterações é: " + iteracoes);
	}
}
