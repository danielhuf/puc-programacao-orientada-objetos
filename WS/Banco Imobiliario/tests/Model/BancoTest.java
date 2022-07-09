package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class BancoTest {

     @Test
     public void testAbastece() {   
    	 Banco b = Banco.getBanco();
    	 assertEquals("Banco não iniciou com o saldo de 200k", 200000, b.getConta().getSaldo());
    	 
    	 Jogador j = new Jogador("cobaia");
    	 Tentativa.PagaValor(j, 199000);
    	 assertEquals("Banco não pagou ao jogador", 1000, b.getConta().getSaldo());
    	 
    	 Tentativa.PagaValor(j, 5000);
    	 assertEquals("Banco não abasteceu", 195000, b.getConta().getSaldo());
     }

}