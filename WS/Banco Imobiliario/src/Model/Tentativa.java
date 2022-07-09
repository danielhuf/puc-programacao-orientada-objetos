package Model;

class Tentativa {
	static ModelFacade api = ModelFacade.getAPI();
	
	/**
	 * Tentativa genérica de transferência de valor entre um jogador e o banco
	 * @param j Jogador que irá participar da transferência
	 * @param valor Valor de transferência
	 * @return true caso a transferência tenha sido efetuada, false caso contrário
	 */
	public static boolean PagaValor(Jogador j, int valor) {
		if (valor == 0) {
			return true;
		}
		else if (valor > 0) {
			while (!Banco.getBanco().getConta().paga(j.getConta(), valor)) {
				Banco.getBanco().abastece();
			}
			api.notifica("novoSaldoJogador", j.getId(), j.getConta().getSaldo() - valor, j.getConta().getSaldo());
			return true;
		}
		else { //valor < 0
			if (j.getConta().paga(Banco.getBanco().getConta(), -valor)) {
				api.notifica("novoSaldoJogador", j.getId(), j.getConta().getSaldo() - valor, j.getConta().getSaldo());
				return true;
			}
			return false;
		}
	}
	
	/**
	 * Tentativa de comprar uma propriedade sem dono
	 * @param posCasa Posição da propriedade no tabuleiro
	 * @param j Jogador que irá tentar fazer a compra
	 */
	public static void CompraPropriedade(int posCasa, Jogador j) {
		CasaNegociavel c = (CasaNegociavel)Tabuleiro.getCasa(posCasa);
		if (PagaValor(j, -c.getPreco())) {
			c.transfereTitular(j);
			api.notifica("sucessoCompra");
		}
		else {
			api.notifica("falhaCompra");
		}
	}
	
	/**
	 * Tentativa de comprar uma casa ou hotel em um terreno
	 * @param posCasa Posição da propriedade no tabuleiro
	 * @param imovel Numero que identifica se o imovel é uma casa ou hotel
	 * @param j Jogador dono do terreno, que irá tentar fazer a compra
	 */
	public static void CompraImovel(int posCasa, int imovel, Jogador j) {
		Terreno t = (Terreno)Tabuleiro.getCasa(posCasa);
		if (PagaValor(j, -t.getCustoConstrucao())) {
			t.imovelComprado(imovel);
			api.notifica("sucessoCompra");
		}
		else {
			api.notifica("falhaCompra");
		}
	}
	
	/**
	 * Tentativa de pagar o aluguel de uma propriedade que já possua um dono
	 * @param posCasa Posição da propriedade no tabuleiro
	 * @param nDados Número dos dados lançados
	 * @param falencia true se o jogador estiver falido, false caso contrário
	 * @param j Jogador que irá tentar pagar o aluguel
	 * @return true se o pagamento foi efetuado, false caso contrário
	 */
	public static boolean PagaPropriedade(int posCasa, int nDados, boolean falencia, Jogador j) {
		CasaNegociavel c = (CasaNegociavel)Tabuleiro.getCasa(posCasa);
		int pagamento;
        if (c instanceof Terreno) {
        	pagamento = ((Terreno)c).getPrecoAluguel();
        }
        else { // c é instancia de Companhia
        	pagamento = ((Companhia)c).getTaxa(nDados);
        }
        if (falencia) {  //jogador da vez paga tudo que tem ao jogador credor
        	int saldoFalencia = j.getConta().getSaldo();
        	j.getConta().paga(c.getTitular().getConta(), saldoFalencia);
        	api.notifica("novoSaldoJogador", j.getId(), j.getConta().getSaldo() + saldoFalencia, j.getConta().getSaldo());
        	api.notifica("novoSaldoJogador", c.getTitular().getId(), c.getTitular().getConta().getSaldo() - saldoFalencia, c.getTitular().getConta().getSaldo());
        	return true;
        }
        else {
        	api.notifica("propriedadeComDono");
        }
        if (j.getConta().paga(c.getTitular().getConta(), pagamento)) {
        	api.notifica("novoSaldoJogador", j.getId(), j.getConta().getSaldo() + pagamento, j.getConta().getSaldo());
        	api.notifica("novoSaldoJogador", c.getTitular().getId(), c.getTitular().getConta().getSaldo() - pagamento, c.getTitular().getConta().getSaldo()); 
        	return true;
        }
        return false;
	}
	
	public static boolean PagaPassagem(int posCasa, boolean falencia, Jogador j) {
		Passagem p = (Passagem)Tabuleiro.getCasa(posCasa);
		int valorPassagem = p.getValor();
		
		if (falencia) { //Jogador falido pagará apenas o que resta do seu saldo
			int saldoFalencia = j.getConta().getSaldo();
			return PagaValor(j, -saldoFalencia);
		}
		else {
			return PagaValor(j, valorPassagem);
		}
	}
	
	public static boolean PagaSorteReves(int carta, boolean falencia, Jogador jVez, Jogador jOutro) {
		int valorCarta = SorteReves.getValor(carta);
		if (falencia) {
			int saldoFalencia = jOutro.getConta().getSaldo();
			PagaValor(jOutro, -saldoFalencia);
			if (carta == 10) { //carta 10 = todos os jogadores pagam ao jogador que tirar a carta (vulgo jVez)
				PagaValor(jVez, saldoFalencia);
			}
			return true;
		}
		if (PagaValor(jOutro, valorCarta)) {
			if (carta == 10) {
				PagaValor(jVez, -valorCarta);  //jogador da vez irá receber 50 de nJogador
			}
			return true;
		}
		return false;
	}
}
