/*
 	Aluna: Maria Fernanda Lucio de Mello
 	NºUSP: 11320860
 	@author mafemello
 */

package BozoGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlacarTest {

	@Test // Testa o caso em que o placar deve ser zero 
	public void testGetScoreVazio() {
		Placar pl = new Placar();
		int k = pl.getScore();
		assertEquals(0, k);
	}

	@Test // Testa caso de placar arbitrário
	public void testGetScoreCheio() {
		Placar pl = new Placar();
		pl.add(1, new int[] {1, 2, 3, 4, 5} );
		pl.add(2, new int[] {1, 2, 3, 4, 5} );
		pl.add(3, new int[] {1, 2, 3, 4, 5} );
		pl.add(4, new int[] {1, 2, 3, 4, 5} );
		pl.add(5, new int[] {1, 2, 3, 4, 5} );
		pl.add(6, new int[] {1, 2, 3, 4, 5} );
		pl.add(7, new int[] {1, 2, 3, 4, 5} );
		pl.add(8, new int[] {1, 2, 3, 4, 5} );
		pl.add(9, new int[] {1, 2, 3, 4, 5} );
		pl.add(10, new int[] {1, 2, 3, 4, 5});
		int k = pl.getScore();
		assertEquals(35, k);
	}
	 
	// Teste com exceção
	@Test (expected = IllegalArgumentException.class)
	public void testADDPosicaoInvalida () {
		Placar p1 = new Placar ();
		p1.add (-1, new int[] {1, 2, 3, 4, 5} );
	}
	
	// Teste com exceção
	@Test (expected = IllegalArgumentException.class)
	public void testADDPosicaoInvalida2 () {
		Placar p1 = new Placar ();
		p1.add (12, new int[] {1, 2, 3, 4, 5} );
	}
	
	// Teste com exceção
	@Test (expected = IllegalArgumentException.class)
	public void testADDPosicaoJAOcupada() {
		Placar p1 = new Placar ();
		p1.add (1, new int[] {1, 2, 3, 4, 5} );
		p1.add(1, new int [] {1, 2, 4, 4, 3} );
	}
	
	
	@Test // Testa Quadra
	public void testADDQuadra () {
		Placar p1 = new Placar ();
		p1.add (9, new int[] {2, 2, 2, 2, 3} );
		int k = p1. getScore ();
		assertEquals (30, k);	
	}
	
	@Test // Testa quina
	public void testADDQuina () {
		Placar p1 = new Placar ();
		p1.add (10, new int[] {2, 2, 2, 2, 2} );
		int k = p1. getScore ();
		assertEquals (40, k);	
	}
	
	@Test // Testa fullhand
	public void testADDFullHandComeco () {
		Placar p1 = new Placar ();
		p1.add (7, new int[] {2, 3, 2, 3, 3} );
		int k = p1. getScore ();
		assertEquals (15, k);	
	}
	
	@Test // Testa fullhand
	public void testADDFullHandFinal () {
		Placar p1 = new Placar ();
		p1.add (7, new int[] {3, 4, 4, 3, 4} );
		int k = p1. getScore ();
		assertEquals (15, k);	
	}
	
	@Test // Testa caso 6
	public void testADD6 () {
		Placar p1 = new Placar ();
		p1.add (6, new int[] {2, 3, 4, 5, 6} );
		int k = p1. getScore ();
		assertEquals (6, k);	
	}
	
	@Test
	public void testSeq () {
		Placar p = new Placar ();
		p.add(8, new int [] {5, 3, 2, 4, 6});
		int k = p.getScore();
		assertEquals (20, k);
	}
	
	@Test // Testa sequencia que nao funciona
	public void testNotSeq () {
		Placar p = new Placar ();
		p.add(8, new int [] {5, 4, 2, 4, 6});
		int k = p.getScore();
		assertEquals (0, k);
	}
	
	@Test
	public void testToString () {
		Placar p = new Placar ();
		p.add(8, new int [] {5, 3, 2, 4, 6});
		String mostrarPlacar = "\n (1)     |     (7)     |     (4)  \n" + 
								"--------------------------------\n" + 
								" (2)     |     20     |     (5)  \n" + 
								"--------------------------------\n" + 
								" (3)     |     (9)     |     (6)  \n" + 
								"--------------------------------\n" + 
								"         |    (10)     |         \n" + 
								"         +-------------+        \n\n";
	assertEquals (p.toString(), mostrarPlacar);
	}
	
	@Test
	public void testToString1 () {
		Placar pl = new Placar ();
		pl.add(1, new int[] {1, 2, 3, 4, 5} );
		pl.add(2, new int[] {1, 2, 3, 4, 5} );
		pl.add(3, new int[] {1, 2, 3, 4, 5} );
		pl.add(4, new int[] {1, 2, 3, 4, 5} );
		pl.add(5, new int[] {1, 2, 3, 4, 5} );
		pl.add(6, new int[] {1, 2, 3, 4, 5} );
		pl.add(7, new int[] {1, 2, 3, 4, 5} );
		pl.add(8, new int[] {1, 2, 3, 4, 5} ); 
		pl.add(9, new int[] {1, 2, 3, 4, 5} );
		pl.add(10, new int[] {1, 2, 3, 4, 5});
		String mostrarPlacar = "\n" + 
				" 1     |     0     |     4    \n" + 
				"--------------------------------\n" + 
				" 2     |     20     |     5  \n" + 
				"--------------------------------\n" + 
				" 3     |     0     |     0  \n" + 
				"--------------------------------\n" + 
				"         |    0    |        \n" + 
				"         +-------------+        \n\n";
		assertEquals (pl.toString(), mostrarPlacar);
	}
	
	@Test
	public void testToString2 () {
		Placar p = new Placar ();
		p.add(9, new int [] {2, 2, 2, 2, 6});
		String mostrarPlacar = "\n" + 
				" (1)     |     (7)     |     (4)  \n" + 
				"--------------------------------\n" + 
				" (2)     |     (8)     |     (5)  \n" + 
				"--------------------------------\n" + 
				" (3)     |     30     |     (6)  \n" + 
				"--------------------------------\n" + 
				"         |    (10)     |         \n" + 
				"         +-------------+        \n" + 
				"\n" ;
	assertEquals (p.toString(), mostrarPlacar);
	}
}
