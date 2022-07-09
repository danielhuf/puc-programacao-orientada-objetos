import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double nota, soma = 0.0;
		int i;
		
		System.out.println("Informe uma nota");
		nota = s.nextDouble();
		
		for (i=0; nota>=0.0 && nota<=10.0; i++) {
			soma += nota;
			System.out.println("Informe uma nota");
			nota = s.nextDouble();
		}
		
		s.close();
		
		System.out.printf("Media da turma = %.1f\n", soma/i);
	}

}
