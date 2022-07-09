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
    	assertTrue("Transferência válida não foi efetuada", conta1.paga(conta2, 2000));
    	assertEquals("Saldo após transferência não está correto", 3000, conta1.getSaldo());
    	assertEquals("Saldo após transferência não está correto", 7000, conta2.getSaldo());
    }
    
    @Test
    public void testPagamentoInvalido() {
    	assertFalse("Transferência inválida foi efetuada", conta2.paga(conta1, 10000));
    	assertEquals("Saldo não se manteve igual após transferência inválida", 5000, conta2.getSaldo());
    }
}