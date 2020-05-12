package FigurasGeometricas;

// Subclasse das figurasGeometricas
public class Quadrado extends figurasGeometricas {

	// Atributos referentes ao quadrado
	int lado;
	
	// Construtor
	public Quadrado (String cor, boolean filled, int lado) {
		super (cor, filled);
		this.lado = lado;
	}
	
	// Getter
	public int getLado () {
		return lado;
	}
	
	// Setter
	public void setLado (int lado) {
		this.lado = lado;
	}
	
}
