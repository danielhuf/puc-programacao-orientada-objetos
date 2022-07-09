package Model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TerrenoTest {
	
	static Terreno t, t2, t3, t4, t5, t6, t7, t8, t9;
	
	@BeforeClass
	public static void inicia() {
		Tabuleiro.getTabuleiro();
		t = (Terreno)Tabuleiro.getCasa(1);
		t2 = (Terreno)Tabuleiro.getCasa(3);
		t3 = (Terreno)Tabuleiro.getCasa(4);
		t4 = (Terreno)Tabuleiro.getCasa(6);
		t5 = (Terreno)Tabuleiro.getCasa(8);
		t6 = (Terreno)Tabuleiro.getCasa(9);
		t7 = (Terreno)Tabuleiro.getCasa(11);
		t8 = (Terreno)Tabuleiro.getCasa(13);
		t9 = (Terreno)Tabuleiro.getCasa(14);
	}
	
	@Before
	public void devolve() {
		t.devolve();
	}
	
	@Test
	public void testVerificaImoveis() {
		assertTrue("Casa verificada incorretamente", t.verificaCasa());
		assertFalse("Hotel verificado incorretamente", t.verificaHotel());
	}

	@Test
	public void testCompraVendaImoveis() {
		for (int i=0; i<4; i++) {
			t.imovelComprado(1); //Comprou 4 casas
		}
		assertFalse("Casa verificada incorretamente", t.verificaCasa());
		assertTrue("Hotel verificado incorretamente", t.verificaHotel());
		
		t.imovelComprado(-1);  //Comprou1 hotel
		assertFalse("Hotel verificado incorretamente", t.verificaHotel());
	}

	@Test
	public void testVerificaNumeroLimiteCasas() {
		for (int i=0; i<4; i++) { //Comprando total de 32 casas em 8 terrenos diferentes
			t.imovelComprado(1);
			t2.imovelComprado(1);
			t3.imovelComprado(1);
			t4.imovelComprado(1);
			t5.imovelComprado(1);
			t6.imovelComprado(1);
			t7.imovelComprado(1);
			t8.imovelComprado(1);
		}
		
		assertFalse("Casa verificada incorretamente", t9.verificaCasa());
	}
}
