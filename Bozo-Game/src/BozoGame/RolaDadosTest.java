/*
 	Aluna: Maria Fernanda Lucio de Mello
 	NºUSP: 11320860
 	@author mafemello
 */

package BozoGame;
import static org.junit.Assert.*;
import org.junit.Test;
public class RolaDadosTest {

	@Test //(expected = IllegalArgumentException.class)
	public void testRolar() {
		RolaDados d = new RolaDados(5);	
		int [] vetDados = d.rolar();
		int k = 0;
		int flag = 0;
		for (int i = 0; i < 5; i ++) {
			k = vetDados[i];
			if (k < 0 || k > 6) {
				flag = 1;
			}
		}
		assertEquals (flag, 0);
	}

	@Test
	public void testRolarAlgunsDados () {
		RolaDados d = new RolaDados (5);
		int[] vetDados = d.rolar(" 1 2 3 4 5 ");
		int k = 0;
		int flag = 0;
		for (int i = 0; i < 5; i++) {
			k = vetDados [i];
			if (k < 0 || k > 6) {
				flag = 1;
			}
		}
		assertEquals (flag, 0);
	}
	
	@Test
	public void testRolarBooleans () {
		RolaDados d = new RolaDados (5);
		boolean[] dados = new boolean[5];
		int flag = 0;
		d.rolar();
		dados[0] = true;
		dados[1] = true;
		int k = 0;
		int[] vetDados = d.rolar(dados);
		for (int i = 0; i < 5; i ++) {
			k = vetDados[i];
			if (k < 0 || k > 6) {
				flag = 1;
			}
		}
		assertEquals (flag, 0);
	}
	
	@Test
	public void testToStringTodas () {
		RolaDados d = new RolaDados(6);
		int[] vetDados = d.rolar ("1 2 3 4 5 ");

		while (!(vetDados[0] == 1 && vetDados[1] == 2 && vetDados[2] == 3 && vetDados[3] == 4 && vetDados[4] == 5)) {
			vetDados = d.rolar("1 2 3 4 5 ");
		}  
		
		String dadoS = " 1        2        3        4        5\n" + 
				"+-----+  +-----+  +-----+  +-----+  +-----+\n" + 
				"|     |  |*    |  |*    |  |*   *|  |*   *|  \n" + 
				"|  *  |  |     |  |  *  |  |     |  |  *  |  \n" + 
				"|     |  |    *|  |    *|  |*   *|  |*   *|  \n" + 
				"+-----+  +-----+  +-----+  +-----+  +-----+\n";
		assertEquals (d.toString(), dadoS); 
	}
	
	@Test
	public void testToString6 () {
		RolaDados d = new RolaDados (5);
		int[] vetDados = d.rolar ("1 2 3 4 5 ");
		
		while (!(vetDados[0] == 6 && vetDados[1] == 6 && vetDados[2] == 6 && vetDados[3] == 6 && vetDados[4] == 6)) {
			vetDados = d.rolar("1 2 3 4 5 ");
		}  
		
		String dadoS = " 1        2        3        4        5\n" + 
				"+-----+  +-----+  +-----+  +-----+  +-----+\n" + 
				"|*   *|  |*   *|  |*   *|  |*   *|  |*   *|  \n" + 
				"|*   *|  |*   *|  |*   *|  |*   *|  |*   *|  \n" + 
				"|*   *|  |*   *|  |*   *|  |*   *|  |*   *|  \n" + 
				"+-----+  +-----+  +-----+  +-----+  +-----+\n";
		assertEquals (d.toString(), dadoS); 
	}
	  	 
}
