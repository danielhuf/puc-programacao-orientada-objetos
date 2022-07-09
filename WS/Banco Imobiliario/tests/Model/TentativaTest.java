package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class TentativaTest {
	
	Jogador j1 = new Jogador("cobaia");
	Banco b = Banco.getBanco();
	Tabuleiro t = Tabuleiro.getTabuleiro();

	@Test
	public void testPagaValorNulo() {
		assertTrue("Pagamento nulo não foi efetuado", Tentativa.PagaValor(j1, 0));
	}
	
	@Test
	public void testPagamentoBanco() {
		j1.getConta().setSaldo(4000);
		int saldoAntigoJogador = j1.getConta().getSaldo();
		int saldoAntigoBanco = b.getConta().getSaldo();
		int valTransferencia = 2000;
		
		assertTrue("Banco não pagou ao jogador", Tentativa.PagaValor(j1, valTransferencia));
		assertEquals("Saldo do banco não foi debitado", saldoAntigoBanco, b.getConta().getSaldo() + valTransferencia);
		assertEquals("Saldo do jogador não foi creditado", saldoAntigoJogador, j1.getConta().getSaldo() - valTransferencia);
	}

	@Test
	public void testPagamentoJogador() {
		j1.getConta().setSaldo(4000);
		int saldoAntigoJogador = j1.getConta().getSaldo();
		int saldoAntigoBanco = b.getConta().getSaldo();
		int valTransferencia1 = 50000;
		int valTransferencia2 = 1000;
		
		assertFalse("Jogador pagou o que não tinha ao banco", Tentativa.PagaValor(j1, -valTransferencia1));
		assertTrue("Jogador não pagou ao banco", Tentativa.PagaValor(j1, -valTransferencia2));
		assertEquals("Saldo do banco não foi creditado", saldoAntigoBanco, b.getConta().getSaldo() - valTransferencia2);
		assertEquals("Saldo do jogador não foi debitado", saldoAntigoJogador, j1.getConta().getSaldo() + valTransferencia2);
	}
	
	@Test
	public void testCompraPropriedadeEImovel() {
		Terreno t = (Terreno)Tabuleiro.getCasa(1);
		
		j1.getConta().setSaldo(10);
		Tentativa.CompraPropriedade(1, j1);
		assertNull("Jogador comprou propriedade sem ter dinheiro para tal", t.getTitular());
		
		j1.getConta().setSaldo(4000);
		Tentativa.CompraPropriedade(1, j1);
		assertSame("Jogador não comprou propriedade desocupada tendo dinheiro para tal", j1, t.getTitular());
		
		j1.getConta().setSaldo(10);
		Tentativa.CompraImovel(1, 1, j1);
		assertEquals("Jogador comprou imovel sem ter dinheiro para tal", 0, t.getNCasas());
		
		j1.getConta().setSaldo(4000);
		Tentativa.CompraImovel(1, 1, j1);
		Tentativa.CompraImovel(1, 1, j1);
		Tentativa.CompraImovel(1, -1, j1);
		assertTrue("Jogador não comprou imoveis tendo dinheiro para tal", (t.getNCasas() == 2) && (t.getNHoteis() == 1));
	}
	
	@Test
	public void pagaPassagemFalido() {
		j1.getConta().setSaldo(100);
		Tentativa.PagaPassagem(24, true, j1);
		assertEquals("Jogador falido não pagou tudo que tinha na casa de passagem", 0, j1.getConta().getSaldo());
	}
}
