package poligono;
import java.lang.Math;

public class Retangulo {
	protected Ponto[] vert;

	public static Retangulo create(Ponto p1,Ponto p3) {
        Ponto p2, p4; //p2 estará do lado de p1 e p4 do lado de p3
		if (p1.getX() == p3.getX() | p1.getY() == p3.getY())
            return null;

        p2 = new Ponto(p3.getX(), p1.getY());
        p4 = new Ponto(p1.getX(), p3.getY());

        if (p1.dist(p2) == p1.dist(p4))
            return new Quadrado(p1, p2, p3, p4);
        else
            return new Retangulo(p1, p2, p3, p4);
	}
	
	protected Retangulo(Ponto p1,Ponto p2,Ponto p3,Ponto p4) {
		vert = new Ponto[4];
        vert[0] = p1;
        vert[1] = p2;
        vert[2] = p3;
        vert[3] = p4;
	}
	
	public double perimetro() {
		return 2.0 * Math.abs(vert[0].getX() - vert[2].getX()) + 2.0 * Math.abs(vert[0].getY() - vert[2].getY());
	}

	public void tipo() {
		System.out.println("Sou um Retângulo");
	}
}