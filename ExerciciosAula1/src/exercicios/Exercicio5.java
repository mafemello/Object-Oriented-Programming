package exercicios;
import java.io.IOException;

/*
 * Escreva um programa que leia um número inteiro e exiba o primeiro número primo menor
que o número informado.
 */

public class ex5 {
	public static void main (String[] args) throws IOException {
		int num = 0;
		
		while (true) {
			try {
				System.out.print ("Qual o numero? ");
				num = EntradaTeclado.leInt();
				break;
			} catch (Exception e) {
				System.out.print("Valor nao eh um int. Tente novamente");
				System.out.println();
			}
		}

		for (int i = num - 1; i>0; i --) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}
				if (j == i-1) {
					System.out.print("Primo mais proximo: " + i);
					return;
				}
			}		
		}
	}
}
