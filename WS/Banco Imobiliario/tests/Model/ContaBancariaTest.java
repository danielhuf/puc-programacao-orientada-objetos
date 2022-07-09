package Model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ContaBancariaTest {
	
	ContaBancaria conta1 = new ContaBancaria(0);
	ContaBancaria conta2 = new ContaBancaria(0);
	
	@Before
	public void setaSaldos() {
    	conta1.setSaldo(5000);
    	conta2.setSaldo(5000);
	}

    @Test(expected = ExcecaoDinheiroInsuficiente.class)
    public void testSaqueIndevido() throws ExcecaoDinheiroInsuficiente{
        conta1.sacar(10000);
    }
    
    @Test
    public void testPagamentoValido() {
    	assertTrue("Transfer�ncia v�lida n�o foi efetuada", conta1.paga(conta2, 2000));
    	assertEquals("Saldo ap�s transfer�ncia n�o est� correto", 3000, conta1.getSaldo());
    	assertEquals("Saldo ap�s transfer�ncia n�o est� correto", 7000, conta2.getSaldo());
    }
    
    @Test
    public void testPagamentoInvalido() {
    	assertFalse("Transfer�ncia inv�lida foi efetuada", conta2.paga(conta1, 10000));
    	assertEquals("Saldo n�o se manteve igual ap�s transfer�ncia inv�lida", 5000, conta2.getSaldo());
    }
}