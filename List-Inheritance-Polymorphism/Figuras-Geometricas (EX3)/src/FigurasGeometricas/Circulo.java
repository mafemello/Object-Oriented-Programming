package FigurasGeometricas;

// Subclasse das figurasGeometricas
public class Circulo extends figurasGeometricas {
	
	// Atributos referentes ao circulo
	int raio;
	
	// Construtor
	public Circulo(String cor, boolean filled, int raio) {
		super(cor, filled);
		this.raio = raio;
	}
	
	// Getter
	public int getRaio () {
		return raio;
	}
	
	// Setter
	public void setRaio (int raio) {
		this.raio = raio;
	}
	
	
}
