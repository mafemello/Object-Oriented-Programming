package exercicios;
import java.io.IOException;

/*
 * Escreva um programa que leia v�rios n�meros de ponto flutuante, um de cada vez, at� que
seja digitado o valor zero. Seu programa deve identificar e mostrar qual � o menor e qual � o
maior de todos.
 */


public class ex6 {
	public static void main (String[] args) throws IOException {
		System.out.print("Digite um numero: ");
		
		int atual = EntradaTeclado.leInt();
		int maior = atual;
		int menor = atual;
		
		while (atual != 0) {
			System.out.print("Digite um numero: ");
			atual = EntradaTeclado.leInt();
			if (atual != 0) {
				if (atual < menor) {
					menor = atual;
				}
				if (atual > maior) {
					maior = atual;
				}
			}
		}	
			System.out.print ("Maior:" + maior);
			System.out.println();
			System.out.print ("Menor: " + menor);	
	}
}
