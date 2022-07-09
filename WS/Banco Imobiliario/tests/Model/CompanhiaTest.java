package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CompanhiaTest {

	@Test
	public void testDevolve() {
    	Companhia casaTeste = new Companhia("Companhia de Avia��o", 200, 50);
        Jogador j1 = new Jogador("cobaia1");
        Jogador j2 = new Jogador("cobaia2");
        
        casaTeste.transfereTitular(j1);
        assertSame("Titular da casa n�o � o jogador designado na transfer�ncia", j1, casaTeste.getTitular());
        
        casaTeste.devolve();
        assertNull("Casa Negociavel tem dono", casaTeste.getTitular());
        
        casaTeste.transfereTitular(j2);
        assertSame("Titular da casa n�o � o jogador designado na transfer�ncia", j2, casaTeste.getTitular());
	}
}
