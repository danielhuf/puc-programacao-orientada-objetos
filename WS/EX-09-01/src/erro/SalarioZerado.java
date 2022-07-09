package erro;

public class SalarioZerado extends Exception {
	public SalarioZerado() {
	}
	
	public SalarioZerado (String mensagem) {
		super(mensagem);
	}
}
