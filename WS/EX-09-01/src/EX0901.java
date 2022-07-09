import erro.*;

public class EX0901 {
	public static void main(String[] args) /* throws SalarioZerado */ {
		Contribuinte []lst;
		
		lst=Contribuinte.listaContr();
		
		System.out.printf("NOME                       IMPOSTO\n");
		System.out.printf("====================       =======\n\n");
		
		for(Contribuinte c:lst) {
			try {
				System.out.printf("%-20s     %9.2f\n",c.getNome(),c.calcImposto());
			}
			catch (SalarioZerado e) {  // catch (Excpetion e)
				if (e instanceof SalarioZeradoPF)
						System.out.println("O contribuinte " + e.getMessage() + " est� com o sal�rio zerado");
				else
					System.out.println("O contribuinte " + e.getMessage() + " est� com a renda bruta zerada");
				//throw e; // se eu relan�o a exce��o, sou obrigado a colocar throws l� em cima
			}
		}
	}
}
