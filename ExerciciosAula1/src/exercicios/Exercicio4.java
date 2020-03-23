package exercicios;
import java.io.IOException;

/*
 * Escreva um programa que leia um número inteiro, verifique se ele é primo e caso ele não
seja, exiba qual o seu menor divisor
 */

public class ex4 {
	
	public static void main (String[] args) throws IOException {
		int num = 0;
		
		while (true) {
			try {
				System.out.print ("Qual numero voce deseja verificar?");
				num = EntradaTeclado.leInt();
				break;
			} catch (Exception e) {
				System.out.print ("Valor nao eh um int. Tente novamente!");
				System.out.println();
			}
		}
		
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				System.out.print("Divisor é: " + i);
				return;
			}
		}
		System.out.print("Primo!");
	}
}
