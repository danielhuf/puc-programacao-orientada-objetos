package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TabuleiroTest {
	
	Jogador j1 = new Jogador("cobaia");
	Tabuleiro t = Tabuleiro.getTabuleiro();

    @Test
    public void testCasaInexistente() {
        assertEquals("Tabuleiro retornou a posi��o de uma casa inexistente", -1, Tabuleiro.getPos("###"));
    }
    
    @Test
    public void testPropriedadesJogador() {
    	assertEquals("Jogador foi inicializado j� tendo alguma propriedade", 0, Tabuleiro.getPropriedadesJogador(j1).size());
    	
    	((CasaNegociavel)Tabuleiro.getCasa(1)).transfereTitular(j1);
    	assertEquals("Propriedade do jogador n�o foi atualizada", 1, Tabuleiro.getPropriedadesJogador(j1).size());
    	
    	((CasaNegociavel)Tabuleiro.getCasa(1)).devolve();
    	assertEquals("Propriedade do jogador n�o foi atualizada", 0, Tabuleiro.getPropriedadesJogador(j1).size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testLimiteNumeroCasas() {
    	Tabuleiro.getCasa(40);  //40 j� excede o limite do n�mero de casas no tabuleiro
    }
    
    @Test(expected = ClassCastException.class)
    public void testConversaoTipo() {
    	Terreno t = (Terreno)Tabuleiro.getCasa(0);
    }
    
    @Test
    public void testNomeCorreto() {
    	assertEquals("Tabuleiro n�o retornou o nome da posi��o escolhida", "Ipanema", Tabuleiro.getCasa(36).getNome());
    }
}

