package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CompanhiaTest {

	@Test
	public void testDevolve() {
    	Companhia casaTeste = new Companhia("Companhia de Aviação", 200, 50);
        Jogador j1 = new Jogador("cobaia1");
        Jogador j2 = new Jogador("cobaia2");
        
        casaTeste.transfereTitular(j1);
        assertSame("Titular da casa não é o jogador designado na transferência", j1, casaTeste.getTitular());
        
        casaTeste.devolve();
        assertNull("Casa Negociavel tem dono", casaTeste.getTitular());
        
        casaTeste.transfereTitular(j2);
        assertSame("Titular da casa não é o jogador designado na transferência", j2, casaTeste.getTitular());
	}
}
