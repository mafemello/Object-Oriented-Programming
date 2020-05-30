/*
 	Aluna: Maria Fernanda Lucio de Mello
 	NºUSP: 11320860
 	@author mafemello
 */

package BozoGame;
import static org.junit.Assert.*;
import org.junit.Test;

public class DadoTest {

	@Test //Testa dado vazio
	public void testDadoVazio () {
		Dado d = new Dado();
		int k = d.getLado();
		assertEquals(0, k); 
	}
	 
	@Test
	public void testGetLado() {
		Dado d = new Dado (6);
		int k = d.getLado();
		assertEquals(0, k);
	}
	
	
	@Test
	public void testRolar () {
		Dado d = new Dado ();
		int k = d.rolar();
		int flag  = 0;
		if ( k < 0 || k > 6) { // Verifica que o dado rola valores validos
			flag = 1;
		}
		assertEquals (flag, 0);
	}
	
	// Testagem dos dados
	@Test  
	public void testToString1 () { 	 
		Dado d = new Dado();
		int k  = 0;
		String dado = "+-----+" +
					  "|     |" +
					  "|  *  |" +
					  "|     |" +
					  "+-----+";
		while (k != 1) {
			k = d.rolar();
		}
		assertEquals (d.toString(), dado);
	}

	@Test 
	public void testToString2 () {		
		Dado d = new Dado();
		int k = 0;
		String dado =  "+-----+" +
					   "| *   |" + 
					   "|     |" +	
					   "|   * |" +
					   "+-----+";	
		while (k != 2) { 
			k = d.rolar();
		}
		assertEquals (d.toString(), dado);
	}
	
	@Test
	public void testToString3 () {		
		Dado d = new Dado();
		int k = 0;
		String dado =  "+-----+" +
					   "| *   |" +
					   "|  *  |" +
					   "|   * |" +
					   "+-----+";
		while (k != 3) {
			k = d.rolar();
		}
		assertEquals (d.toString(), dado);
	}
	
	@Test
	public void testToString4 () {	
		Dado d = new Dado();
		int k = 0;
		String dado = "+-----+" +
					  "| * * |" +
					  "|     |" +
					  "| * * |" +
					  "+-----+";
		while (k != 4) {
			k = d.rolar();
		}
		assertEquals (d.toString(), dado);
	}
	
	@Test
	public void testToString5 () {	
		Dado d = new Dado();
		int k = 0;
		String dado = "+-----+" +
				 	  "| * * |" +
				 	  "|  *  |" + 
				 	  "| * * |" +
				 	  "+-----+";
		while (k != 5) {
			k = d.rolar();
		}
		assertEquals (d.toString(), dado);
		
	}
	
	@Test
	public void testToString6 () {		
		Dado d = new Dado();
		int k = 0;
		String dado = "+-----+" +
					  "| *** |" +
					  "|     |" +
					  "| *** |" +
					  "+-----+";
		while (k != 6) {
			k = d.rolar();
		}
		assertEquals (d.toString(), dado);
	} 
	
	@Test // Testando default do switch
	public void testToStringDefault () {		
		Dado d = new Dado();
		String zero = "0";
		d.setLado(6);
		assertEquals (d.toString(), zero);
	}
	
}
