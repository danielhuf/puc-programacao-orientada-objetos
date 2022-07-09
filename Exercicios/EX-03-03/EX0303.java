public class Main
{
	public static void EX0303(String[] args) {
		System.out.println(Matematica.pi(1000));
		//System.out.println(obtemPi.pi(1000));
		//erro porque um método de classe deve ser invocado por meio do nome da classe, e não de forma indireta.
		//A especificação da linguagem Java diz que um método de classe deve ser invocado sem referência para um objeto particular;
	}
	
	public double obtemPi(int n) {
	    return Matematica.pi(n);
	}
}
