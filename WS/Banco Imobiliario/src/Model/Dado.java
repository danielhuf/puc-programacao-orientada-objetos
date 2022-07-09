package Model;
import java.util.Random;

class Dado {
	private static final int N_DADOS = 2;
	private static int dado[];
	private static Dado dd = null;
	
	private Dado () { dado = new int[N_DADOS]; }
	
	/**
	 * Implementacao do padrao singleton
	 * @return instancia de dado (objeto Dado)
	 */
	static Dado getDado() {
		if (dd == null) {
			dd = new Dado();
		}
		return dd;
	}
	
	/**
	 * Atribui um valor aletório entre 1 e 6 a cada elemento do array 'dado'
	 */
    static void lanca() {
    	for (int i=0; i<N_DADOS; i++) {
    		dado[i] = new Random().nextInt(6) + 1;
    	}
    }
    
	static void setValores(int valores[]) {
    	for (int i=0; i<N_DADOS; i++) {
    		dado[i] = valores[i];
    	}
	}
    
	/**
	 * Checa os valores dos dados
	 * @return true se todos os valores são iguais, false caso contrário
	 */
    static boolean isEqual() {
    	for (int i=1; i<N_DADOS; i++) {
    		if (dado[i] != dado[i-1])
    			return false;
    	}
    	return true;
    }
    
    static int sum() {
    	int soma = 0;
    	for (int i=0; i<N_DADOS; i++)
    		soma += dado[i];
    	return soma;
    }
    
    static int[] getValores() { return dado; }
}