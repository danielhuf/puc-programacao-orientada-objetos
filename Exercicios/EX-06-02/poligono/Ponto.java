package poligono;
import java.lang.Math;

public class Ponto {
	private double x,y;
	
	public Ponto(double x,double y) {
		this.x = x;
        this.y = y;
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
		
	public double dist(Ponto p) {
		return Math.sqrt(Math.pow(x - p.getX(), 2.0) + Math.pow(y - p.getY(), 2.0));
	}
}