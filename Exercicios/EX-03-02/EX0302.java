public class EX0302
{
	public static void main(String[] args) {
	    Xpto t1 = new Xpto();
	    System.out.println(t1.getQtdInst());
	    Xpto t2 = new Xpto();
	    System.out.println(t2.getQtdInst());
	    Xpto t3 = new Xpto();
	    System.out.println(t3.getQtdInst());
	}
}

/* Resposta gabarito:
public class Main {
	public static void main(String[] args) {
		new Xpto();
		new Xpto();
		new Xpto();
		System.out.println(Xpto.getQtdInst());
	}
} */
