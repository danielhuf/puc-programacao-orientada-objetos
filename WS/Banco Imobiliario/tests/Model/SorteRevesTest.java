package Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SorteRevesTest {
	
	@Before
	public void devolve() {
		SorteReves.devolveSaidaLivre();
	}

	@Test
	public void testTodasCartasUsadas() {
		int primeiraCarta = SorteReves.pickSorteReves(); //Se a carta for 8, n�o ser� mais tirada
		
		for (int i=0; i<29; i++) {
			SorteReves.pickSorteReves();
		}
		assertTrue("Baralho n�o foi rodado totalmente", (primeiraCarta == SorteReves.pickSorteReves()) || (primeiraCarta == 8));
	}
	
	@Test
	public void testSaidaLivre() {
		for (int i=0; i<30; i++) {  //Nas primeiras 30 retiradas, uma delas ser� a Sa�da Livre
			SorteReves.pickSorteReves();
		}
		
		for (int i=0; i<30; i++) {  //Nas pr�ximas 30 retiradas, nenhuma carta poder� ser a de Sa�da Livre
			if (SorteReves.pickSorteReves() == 8) {
				fail("Carta de Sa�da Livre continua no baralho");
			}
		}
	}
}
