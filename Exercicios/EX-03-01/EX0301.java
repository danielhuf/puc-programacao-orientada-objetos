public class EX0301
{
	public static void main(String[] args) {
		Vetor v1 = new Vetor(3.0, 4.0);
		Vetor v2 = new Vetor(7.0, 6.0);
		
		v1.soma(v2);
		v1.exibe();
		v2.exibe();
		v2.soma(v1);
		v1.exibe();
		v2.exibe();
		Vetor.soma(v1, v2).exibe();
	}
}
