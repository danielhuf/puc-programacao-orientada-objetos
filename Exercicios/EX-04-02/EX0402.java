public class EX0402
{
	public static void main(String[] args) {
	    Vetor v1 = new Vetor(3.0, 4.0);
	    Vetor v2;
		System.out.println(v1.toString());
		
		v2 = v1.clone();
		System.out.println(v2.toString());
		
		if (v1.equals(v2))
		    System.out.println("Os dois vetores sao IGUAIS");
		else
		     System.out.println("Os dois vetores sao DIFERENTES");
	}
}
