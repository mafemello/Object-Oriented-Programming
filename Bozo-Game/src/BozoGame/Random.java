package BozoGame;
import java.util.Calendar;

public class Random {
	
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	private long xi;
	
	// Retorna um número aleatório no intervalo (0,1[
	public double getRand () {
		xi = (a + m * xi) % p;
		double d = xi;
		return d/p;
	}
	
	// Retorna um valor inteiro no intervalo (0,max[
	public int getIntRand (int max){
		double d = getRand()*max;
		return (int) d;
	}
	
	public int getIntRand (int min,int max) throws java.lang.IllegalArgumentException{
		if(max <= min) {
			throw new IllegalArgumentException("Parâmetros inválidos. Por favor, tente novamente.\n");
		}
        return min + getIntRand(max-min);
    }
	
	/*
	 * Construtor que permite criar o gerador, 
	 * especificando o valor inicial da semente.
	 */
	public Random (long semente) {
		xi = semente;
	}

	/*
	 * Construtor que usa uma semente aleatória, 
	 * adquerida usando o método Calendar.getTimeInMillis().
	 */
	public Random () {
		xi = Calendar.getInstance().getTimeInMillis()%10;
	}
}