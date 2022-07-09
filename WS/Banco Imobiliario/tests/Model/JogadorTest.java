package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class JogadorTest {

	Jogador j1 = new Jogador("cobaia");

    @Test
    public void testPrisao() {
        j1.solta();
        assertFalse("Jogador est� na pris�o", j1.inPrisao());
    	
        j1.prende();
        assertTrue("Jogador n�o foi para pris�o", j1.inPrisao() && j1.getPos() == 10);
        
        j1.solta();
        assertFalse("Jogador continua na pris�o", j1.inPrisao());
    }
    
    @Test
    public void testeMoveSimples() {
    	j1.setPosicao(20);
    	int posAntiga = j1.getPos();
    	j1.move(12);
    	assertEquals("Jogador n�o se moveu para a casa correta", posAntiga+12, j1.getPos());
    }
    
    @Test
    public void testeMovePassandoInicio() {
    	j1.setPosicao(38);
    	int posAntiga = j1.getPos();
    	int saldoAntigo = j1.getConta().getSaldo();
    	j1.move(5);
    	assertEquals("Jogador n�o passou pelo in�cio", (posAntiga+5)%40, j1.getPos());
    	assertEquals("Jogador n�o recebeu honor�rio do in�cio", saldoAntigo, j1.getConta().getSaldo()-200);
    }
}