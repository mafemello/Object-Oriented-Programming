package FigurasGeometricas;

// Superclasse das figuras geometricas
public class figurasGeometricas {

	// Caracteristicas principais
	private String cor;
	private boolean filled;
	
	// Construtor
	public figurasGeometricas (String cor, boolean filled) {
		this.cor = cor;
		this.filled = true;
	}
	
	// Getters
	public String getCor () {
		return cor;
	}
	
	public boolean isFilled () {
		return filled;
	}
	
	// Setters
	public void setCor (String cor) {
		this.cor = cor;
	}
	
	public void setFilled (boolean filled) {
		this.filled = filled;
	}
	
	
	
	// Função que calcula perimetro de um circulo
	public static double calculaPerimetro (Circulo c) {
		double per = 2*3.14*c.getRaio();
		return per;
	}
	
	// Função que calcula perimetro de um retangulo
	public static int calculaPerimetro (Retangulo r) {
		int per = (2*r.getLado1() + 2*r.getLado2());
		return per;
	}
	
	// Função que calcula perimetro de um quadrado
	public static int calculaPerimetro (Quadrado q) {
		int per = (4*q.getLado());
		return per;
	}

	
	
	// Função que calcula area de um circulo
	public static double calculaArea (Circulo c) {
		double area = (3.14*(c.getRaio())*c.getRaio());
		return area;
	}
	
	// Função que calcula area de um retangulo
	public static int calculaArea (Retangulo r) {
		int area = (r.getLado1()*r.getLado2());
		return area;
	}
	
	// Função que calcula area de um quadrado
	public static int calculaArea (Quadrado q) {
		int area = (q.getLado()*q.getLado());
		return area;
	}
}
