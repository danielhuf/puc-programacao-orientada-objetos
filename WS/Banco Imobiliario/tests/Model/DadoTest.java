package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class DadoTest {
	
	Dado dd = Dado.getDado();

    @Test
    public void testSomaLancamentos() {
    	for (int i=0; i<100; i++) {
        	Dado.lanca();
            assertTrue("Soma dos valores dos dados n�o est� na faixa correta", 1 <= Dado.sum() && 12 >= Dado.sum());
    	}
    }

    @Test
    public void testaIgualdadeDados() {
    	Dado.setValores(new int[] {3, 3});
    	assertTrue("Dados n�o est�o retornando valores iguais", Dado.isEqual());
    	
    	Dado.setValores(new int[] {2,5});
    	assertFalse("Dados est�o retornando valores iguais", Dado.isEqual());
    }
}

