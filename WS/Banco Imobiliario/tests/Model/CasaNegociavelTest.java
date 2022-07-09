package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CasaNegociavelTest {

    @Test
    public void testTitularidade() {
    	
    	Terreno casaTeste = new Terreno("Av. Brig. Faria Lima", 240, 20, 100, 300, 750, 925, 1100, 150);
        Jogador j1 = new Jogador("cobaia1");
        Jogador j2 = new Jogador("cobaia2");
        assertNull("Casa Negociavel foi inicializada com algum dono", casaTeste.getTitular());
        
        casaTeste.transfereTitular(j1);
        assertSame("Titular da casa não é o jogador designado na transferência", j1, casaTeste.getTitular());
        
        casaTeste.transfereTitular(null);
        assertNull("Casa Negociavel tem dono", casaTeste.getTitular());
        
        casaTeste.transfereTitular(j2);
        assertSame("Titular da casa não é o jogador designado na transferência", j2, casaTeste.getTitular());

    }
}