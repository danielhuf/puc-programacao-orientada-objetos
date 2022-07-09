package poligono;

public class Quadrado extends Retangulo {
	Quadrado(Ponto p1,Ponto p2,Ponto p3,Ponto p4) {
        super(p1, p2, p3, p4);
	}
	
	public double perimetro() {
		return 4.0 * vert[0].dist(vert[1]);
	}
	
	public void tipo() {
		System.out.println("Sou um Quadrado");
	}
}