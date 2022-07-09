import java.util.*;
import poligono.*;

public class EX0602 {
	public static void main(String[] args) {
		Retangulo r;
		double x1,y1,x2,y2;
		Scanner s= new Scanner(System.in);
		
		System.out.println("Forneça um ponto");
		x1=s.nextDouble();
		y1=s.nextDouble();
		
		System.out.println("Forneça outro ponto");
		x2=s.nextDouble();
		y2=s.nextDouble();
		
		r=Retangulo.create(new Ponto(x1,y1),new Ponto(x2,y2));
				
		if(r==null)
			System.out.println("Pontos inválidos");
		else {
			r.tipo();
			System.out.println(r.perimetro());
		}
	}
}