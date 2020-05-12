package FigurasGeometricas;

// Subclasse das figurasGeometricas
public class Retangulo extends figurasGeometricas {
	
	// Atributos referentes ao retangulo
	int lado1, lado2;
	
	// Construtor
	public Retangulo (String cor, boolean filled, int lado1, int lado2) {
		super (cor, filled);
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	// Getters
	public int getLado1 () {
		return lado1;
	}
	
	public int getLado2 () {
		return lado2;
	}
	
	// Setters
	public void setLado1 (int lado1) {
		this.lado1 = lado1;
	}
	
	public void setLado2 (int lado2) {
		this.lado2 = lado2;
	}
	
}
