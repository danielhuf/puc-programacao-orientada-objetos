package Model;

import java.util.*;
import Controller.Observer.*;

public class ModelFacade implements ObservadoAPI {
	Map<String, List<ObservadorAPI>> observadores = new HashMap<>();
	private static ModelFacade mf = null;
	private Jogador[] arrJogadores;
	private int nJogadores, jogadorDaVez;
	
	/**
	 * Implementação do padrão Singleton
	 * @return instância única do tipo ModelFacade
	 */
	public static ModelFacade getAPI() {
		if (mf == null) {
			mf = new ModelFacade();
		}
		return mf;
	}
	
	private ModelFacade() {
		String[] operacoes = new String[] {"novaPosJogador", "novoValorDados", "usouSaidaLivre", "novoSaldoJogador", "passouVez", "fimDoJogo", "sucessoCompra", "falhaCompra", "sucessoVenda", "sorteReves", "prisao", "propriedadeComDono", "falencia"};
		for (String operacao : operacoes) {
            this.observadores.put(operacao, new ArrayList<>());
		}
	}
	
	/**
	 * Implementação do padrão Observer
	 */
	public void registraObservador(String evento, ObservadorAPI observador) {
        List<ObservadorAPI> users = observadores.get(evento);
        users.add(observador);
    }
	
    public void removeObservador(String evento, ObservadorAPI observador) {
        List<ObservadorAPI> users = observadores.get(evento);
        users.remove(observador);
    }
    
    public void notifica(String evento) {
        List<ObservadorAPI> users = observadores.get(evento);
        for (ObservadorAPI observador : users) {
            observador.atualiza(evento);
        }
    }
    
    public void notifica(String evento, String nome, int saldoAntes, int saldoDepois) {
        List<ObservadorAPI> users = observadores.get(evento);
        for (ObservadorAPI observador : users) {
            observador.atualiza(evento, nome, saldoAntes, saldoDepois);
        }
    }
    
    public void notifica(String evento, int n) {
        List<ObservadorAPI> users = observadores.get(evento);
        for (ObservadorAPI observador : users) {
            observador.atualiza(evento, n);
        }
    }
	
    /**
     * Invoca algumas classes referentes à partida, inicializa o array com os jogadores e determina o jogador da vez
     * @param nJogadores Número de jogadores na partida
     * @param nomes Nomes dos jogadores
     * @param jogadorDaVez Número do jogador da vez referente ao array de jogadores
     */
	public void iniciaPartida(int nJogadores, String[] nomes, int jogadorDaVez) {
		Tabuleiro.getTabuleiro();
		Banco.getBanco();
		Dado.getDado();
		this.nJogadores = nJogadores;
        
        //Array com os jogadores da partida é inicializado
		arrJogadores = new Jogador[nJogadores];
        for (int i=0; i<nJogadores; i++) {
            arrJogadores[i] = new Jogador(nomes[i]);
        }
        
        if (jogadorDaVez < 0) {  // Significa que trata-se de uma nova partida
    		this.jogadorDaVez = new Random().nextInt(nJogadores) + 1; //Acho que a seed nao estava atualizando sem esse +1
    		this.jogadorDaVez -= 1;
        }
        else {
        	this.jogadorDaVez = jogadorDaVez;
        }
	}
	
	public void passaVez(boolean repeteJogada) {
		if (fimDoJogo()) {
			notifica("fimDoJogo");
		}
		else {
			if (!repeteJogada) {
				jogadorDaVez = (jogadorDaVez + 1) % nJogadores;
			}
			while (arrJogadores[jogadorDaVez].isFalido()) {
				jogadorDaVez = (jogadorDaVez + 1) % nJogadores;
			}
			notifica("passouVez", jogadorDaVez);
		}
	}
	
	public void usarSaidaLivre() {
		solta();
		notifica("usouSaidaLivre");
		SorteReves.devolveSaidaLivre();
	}
	
	public void lancaDados() {
		Dado.lanca();
		notifica("novoValorDados");
	}
	
	public void prende() {
		arrJogadores[jogadorDaVez].prende();
		int pos = arrJogadores[jogadorDaVez].getPos();
		notifica("novaPosJogador", Tabuleiro.getCasa(pos).getNome(), pos, -1);
		notifica("prisao");
	}
	
	public void solta() { arrJogadores[jogadorDaVez].solta(); }
	
	public void moveJogador (int nAndarCasas) {
		arrJogadores[jogadorDaVez].move(nAndarCasas);
		int posicaoAtual = arrJogadores[jogadorDaVez].getPos();
    	notifica("novaPosJogador", Tabuleiro.getCasa(posicaoAtual).getNome(), posicaoAtual, -1);
	}
	
	public boolean verificaCasa(int posCasa) {
		CasaTabuleiro casa = Tabuleiro.getCasa(posCasa);
		try {
			Terreno terreno = (Terreno)casa;
			return terreno.verificaCasa();
		}
		catch (Exception e){
			return false;
		}
	}
	
	public boolean verificaHotel(int posCasa) {
		CasaTabuleiro casa = Tabuleiro.getCasa(posCasa);
		try {
			Terreno terreno = (Terreno)casa;
			return terreno.verificaHotel();
		}
		catch (Exception e){
			return false;
		}
	}
	
	/**
	 * Retira uma carta de Sorte ou Revés e trata alguns casos de cartas tiradas
	 * @return Número da carta
	 */
	public int pickSorteReves() {
		int carta = SorteReves.pickSorteReves();
		notifica("sorteReves", carta+1);
		if (carta == 8) {
			arrJogadores[jogadorDaVez].ganhaSaidaLivre();
		}
		else if (carta == 9) {
	    	arrJogadores[jogadorDaVez].setPosicao(0);
	    	notifica("novaPosJogador", Tabuleiro.getCasa(0).getNome(), 0, -1);
		}
    	else if (carta == 22) {
    		prende();
    	}
		return carta;
	}
	
	public void realizaVenda(int nJogador, int nPropriedade, boolean vendaForcada) {
		CasaNegociavel c = (CasaNegociavel)Tabuleiro.getCasa(nPropriedade);
		int precoVenda;
		if (vendaForcada) {
			precoVenda = c.getPrecoVendaForcada();
		}
		else {
			precoVenda = c.getPrecoMercado();
		}
		Tentativa.PagaValor(arrJogadores[nJogador], precoVenda);
		c.devolve();
		notifica("sucessoVenda");
	}
	
	public void tentativaCompraPropriedade(int posCasa) { Tentativa.CompraPropriedade(posCasa, arrJogadores[jogadorDaVez]); }
	
	public void tentativaCompraImovel(int posCasa, int imovel) { Tentativa.CompraImovel(posCasa, imovel, arrJogadores[jogadorDaVez]); }
	
	public boolean tentativaPagaPropriedade(int posCasa, int nDados, boolean falencia) { return Tentativa.PagaPropriedade(posCasa, nDados, falencia, arrJogadores[jogadorDaVez]); }
	
	public boolean tentativaPagaPassagem(int posCasa, boolean falencia) { return Tentativa.PagaPassagem(posCasa, falencia, arrJogadores[jogadorDaVez]); }
	
	public boolean tentativaPagaSorteReves(int nJogador, int carta, boolean falencia) { return Tentativa.PagaSorteReves(carta, falencia, arrJogadores[jogadorDaVez], arrJogadores[nJogador]); }
	
	public int[] getDados() { return Dado.getValores(); }
	
	public int getJogadorDaVez() { return jogadorDaVez; }
	
	public int getSomaDados() { return Dado.sum(); }
	
	public int getRepeticoesJogada(int nJogador) { return arrJogadores[nJogador].getRepeticoesJogada(); }
	
	public int getPosJogador (int nJogador) { return arrJogadores[nJogador].getPos(); }
	
	public int getPosCasa(String p) { return Tabuleiro.getPos(p);}
	
	public List<String> getPropriedadesCasasHoteisTitulares() { return Tabuleiro.getPropriedadesCasasHoteisTitulares(); }
	
	public boolean jogadorInPrisao(int nJogador) { return arrJogadores[nJogador].inPrisao(); }
	
	public boolean jogadorHasSaidaLivre(int nJogador) { return arrJogadores[nJogador].hasSaidaLivre(); }
	
	public boolean dadosIguais() { return Dado.isEqual(); }
	
	public boolean ehCasaNegociavel(int posCasa) { return Tabuleiro.getCasa(posCasa) instanceof CasaNegociavel; }
	
	public boolean ehPassagem(int posCasa) { return Tabuleiro.getCasa(posCasa) instanceof Passagem; }
	
	public boolean ehSorteReves(int posCasa) { return Tabuleiro.getCasa(posCasa) instanceof SorteReves; }
	
	public boolean ehPrisao(int posCasa) { return (posCasa == getPosCasa("Vá para a Prisão")); }
	
	public boolean jogadorIsFalido(int nJogador) { return arrJogadores[nJogador].isFalido(); }
	
	public void aumentaRepeticoesJogada() { arrJogadores[jogadorDaVez].aumentaRepeticoesJogada(); }
	
	public void zeraRepeticoes () { arrJogadores[jogadorDaVez].zeraRepeticoes(); }
	
	public String[] getPropriedades() { return Tabuleiro.getPropriedades(); }
	
	public String[] getDescricao(int pos) { return Tabuleiro.getDesc(pos); }
	
	public int[] getSaldoJogadores() {
		int saldos[] = new int[nJogadores];
		for (int i=0; i<nJogadores; i++) {
			saldos[i] = arrJogadores[i].getConta().getSaldo();
		}
		return saldos;
	}
	
	public int[] getPosicaoJogadores() {
		int posicoes[] = new int[nJogadores];
		for (int i=0; i<nJogadores; i++) {
			posicoes[i] = arrJogadores[i].getPos();
		}
		return posicoes;
	}
	
	public String[] getNomesJogadores() {
		String nomes[] = new String[nJogadores];
		for (int i=0; i<nJogadores; i++) {
			nomes[i] = arrJogadores[i].getId();
		}
		return nomes;
	}
	
	public void setDados(int valores[]) {
		Dado.setValores(valores);
		notifica("novoValorDados");
	}
	
	public boolean casaDesocupada(int posCasa) {
		CasaTabuleiro casa = Tabuleiro.getCasa(posCasa);
		CasaNegociavel casaNegociavel = (CasaNegociavel)casa;
		return (casaNegociavel.getTitular() == null);
	}
	
	public boolean jogadorEhDonoPropriedade(int posCasa) {
		CasaTabuleiro casa = Tabuleiro.getCasa(posCasa);
		CasaNegociavel casaNegociavel = (CasaNegociavel)casa;
		return (casaNegociavel.getTitular() == arrJogadores[jogadorDaVez]);
	}
	
	public String[] getPropriedadesJogador(int nJogador) {
		List<CasaNegociavel> propriedades = Tabuleiro.getPropriedadesJogador(arrJogadores[nJogador]);
		if (propriedades.isEmpty()) {
			return null;
		}
		String resp[] = new String[propriedades.size()];
		for (int i=0; i<propriedades.size(); i++) {
			resp[i] = propriedades.get(i).getNome() + " ($" + Integer.toString(propriedades.get(i).getPrecoVendaForcada()) + ")";
		}
		return resp;
	}
	
	public void decretarFalenciaJogador(int nJogador) {
		arrJogadores[nJogador].setFalido();
		notifica("falencia");
	}
	
	/**
	 * Checa se o jogo está no fim
	 * @return true se só resta 1 jogador não falido, false caso contrário
	 */
	private boolean fimDoJogo() {
		int nJogando = 0;
		for (Jogador j: arrJogadores) {
			if(!j.isFalido()) {
				nJogando++;
			}
		}
		return (nJogando == 1);
	}
	
	/**
	 * Calcula o patrimônio de um jogador (método chamado quando a partida é encerrada)
	 * @param nJogador posição do jogador no array de jogadores
	 * @return patrimônio do jogador = saldo + valor de mercado de suas propriedades
	 */
	public int getPatrimonio(int nJogador) {
		int patrimonio = arrJogadores[nJogador].getConta().getSaldo();
		List<CasaNegociavel> propriedades = Tabuleiro.getPropriedadesJogador(arrJogadores[nJogador]);
		for (int i=0; i<propriedades.size(); i++) {
			patrimonio += propriedades.get(i).getPrecoMercado();
		}
		return patrimonio;
	}
	
	/**
	 * Atualiza as condições dos jogadores quando uma partida é carregada
	 * @param saldos
	 * @param posicoes
	 * @param prisao
	 * @param saidaLivre
	 * @param falido
	 * @param repeticoesJogada
	 */
	public void setCondicoesJogadores(int[] saldos, int[] posicoes, boolean[] prisao, boolean[] saidaLivre, boolean[] falido, int[] repeticoesJogada) {
		for (int i=0; i<nJogadores; i++) {
			arrJogadores[i].getConta().setSaldo(saldos[i]);
			arrJogadores[i].setPosicao(posicoes[i]);
			if (prisao[i]) {
				arrJogadores[i].prende();
			}
			if (saidaLivre[i]) {
				arrJogadores[i].ganhaSaidaLivre();
				SorteReves.tomaSaidaLivre();
			}
			if (falido[i]) {
				arrJogadores[i].setFalido();
			}
			arrJogadores[i].setRepeticoesJogada(repeticoesJogada[i]);
		}
	}
	
	/**
	 * Atualiza as condições das propriedades quando a partida é carregada
	 * @param propriedades
	 */
	public void setCondicoesPropriedades(List<String[]> propriedades) {
		String nomePropriedade, nomeTitular;
		int nCasas, nHoteis;
		
		for (int i=0; i<propriedades.size(); i++) {
			nomePropriedade = propriedades.get(i)[0];
			nomeTitular = propriedades.get(i)[1];
			for (int j=0; j<nJogadores; j++) {
				if (!nomeTitular.equals("null") && arrJogadores[j].getId().equals(nomeTitular)) {
					((CasaNegociavel)Tabuleiro.getCasa(Tabuleiro.getPos(nomePropriedade))).transfereTitular(arrJogadores[j]);
					break;
				}
			}
			if (propriedades.get(i).length == 4) {  //setar Casas e Hoteis do terreno
				nCasas = Integer.parseInt(propriedades.get(i)[2]);
				nHoteis = Integer.parseInt(propriedades.get(i)[3]);
				((Terreno)Tabuleiro.getCasa(Tabuleiro.getPos(nomePropriedade))).setNCasas(nCasas);
				((Terreno)Tabuleiro.getCasa(Tabuleiro.getPos(nomePropriedade))).setNHoteis(nHoteis);
			}
		}
	}
}