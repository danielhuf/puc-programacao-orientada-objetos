package Controller;

import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import Model.ModelFacade;
import View.*;

public class Controller {
	ModelFacade api;
	private int nJogadores;
	private boolean godMode;
	FrameInicial frameInicial;
	FrameNomes frameNomes;
	FrameTabuleiro frameTabuleiro;
	private static Controller ctrl = null;
	
	/**
	 * Implementação do padrão Singleton
	 * @return instância única do tipo Controller
	 */
    public static Controller getController() {
    	if (ctrl == null) {
    		ctrl = new Controller();
    	}
    	return ctrl;
    }
	
	private Controller() {
		Imagem.carregar();
		Coordenada.carregar();
        frameInicial = new FrameInicial();
        frameInicial.abrir();	
        api = ModelFacade.getAPI();
	}
	
	/**
	 * Chamada do frame de escolha de nomes, já com a informação do número de jogadores
	 * @param nJogadores
	 */
    public void iniciarEscolhaNomes(int nJogadores) {
        frameInicial.fechar();
        this.nJogadores = nJogadores;
        frameNomes = new FrameNomes(this.nJogadores);
        frameNomes.abrir();
    }
    
    /**
     * Fecha o frame de nomes, define o modo de jogo, instancia o frame do tabuleiro e registra os observadores para o mesmo
     * @param nomes Nomes dos jogadores
     * @param godMode Modo do jogo (jogar escolhendo os dados ou não)
     */
    public void iniciarPartida(String[] nomes, boolean godMode) {
    	frameNomes.fechar();
    	this.godMode = godMode;
    	api.iniciaPartida(nJogadores, nomes, -1);
    	setarTabuleiro();
    }
    
    void carregarPartidaSalva(String[] nomes, int nJogadores, int jogadorDaVez, boolean godMode, int[] saldos, int[] posicoes, boolean[] prisao, boolean[] saidaLivre, boolean[] falido, int[] repeticoesJogada, List<String[]> propriedades) {
    	frameInicial.fechar();
    	this.nJogadores = nJogadores;
    	this.godMode = godMode;
    	api.iniciaPartida(nJogadores, nomes, jogadorDaVez);
    	api.setCondicoesJogadores(saldos, posicoes, prisao, saidaLivre, falido, repeticoesJogada);
    	api.setCondicoesPropriedades(propriedades);
    	setarTabuleiro();
    }
    
    /**
     * Instancia o frame do tabuleiro e registra os observadores nele
     */
    private void setarTabuleiro() {
    	frameTabuleiro = new FrameTabuleiro(godMode, api.getPropriedades(), nJogadores, api.getNomesJogadores(), api.getSaldoJogadores(), api.getPosicaoJogadores(), api.getJogadorDaVez());
        api.registraObservador("novaPosJogador", frameTabuleiro);
        api.registraObservador("novoValorDados", frameTabuleiro);   
        api.registraObservador("usouSaidaLivre", frameTabuleiro);
        api.registraObservador("novoSaldoJogador", frameTabuleiro);
        api.registraObservador("passouVez", frameTabuleiro);
        api.registraObservador("fimDoJogo", frameTabuleiro);
        api.registraObservador("sucessoCompra", frameTabuleiro);
        api.registraObservador("falhaCompra", frameTabuleiro);
        api.registraObservador("sucessoVenda", frameTabuleiro);
        api.registraObservador("sorteReves", frameTabuleiro);
        api.registraObservador("prisao", frameTabuleiro);
        api.registraObservador("propriedadeComDono", frameTabuleiro);
        api.registraObservador("falencia", frameTabuleiro);
    	frameTabuleiro.abrir();
    }
    
    /**
     * Get patrimônio de cada jogador na api
     * @return array com os patrimônios dos jogadores
     */
	public int[] reunePatrimonios() {
		int patrimonios[] = new int[nJogadores];
		for (int i=0; i<nJogadores; i++) {
			patrimonios[i] = api.getPatrimonio(i);
		}
		return patrimonios;
	}
	
	/**
	 * Verificação da condição do jogador da vez ao lançar os dados e chamada do tratamento de sua posição após a verificação
	 * @param nJogador
	 */
	public void rolarDados(int nJogador) {
		
        if (api.jogadorInPrisao(nJogador)) {
            if (api.jogadorHasSaidaLivre(nJogador)) { 
            	api.usarSaidaLivre();
            	rolarDados(nJogador);
            }
            else {
            	if (godMode) {
    				api.setDados(frameTabuleiro.getValorDados());
            	}
            	else {
            		api.lancaDados(); 
            	}
            	if (api.dadosIguais()) {
            		api.solta();
            		api.moveJogador(api.getSomaDados());
            		trataPosicao(nJogador, api.getSomaDados(), false);
            	}
            	else {
            		api.passaVez(false);
            	}
            }
        }
        else {
        	if (godMode) {
				api.setDados(frameTabuleiro.getValorDados());
        	}
        	else {
        		api.lancaDados(); 
        	}
            if (api.dadosIguais()) {
            	api.aumentaRepeticoesJogada();
                if (api.getRepeticoesJogada(nJogador) == 3) {
                	api.prende();
                	api.passaVez(false);
                }
                else {
                	api.moveJogador(api.getSomaDados());
                	trataPosicao(nJogador, api.getSomaDados(), true);
                }
            }
            else {
            	api.zeraRepeticoes();
            	api.moveJogador(api.getSomaDados());
            	trataPosicao(nJogador, api.getSomaDados(), false);
            }
        }
	}
	
	/**
	 * Tratamento do que acontece com o jogador a depender da casa em que parou
	 * @param nJogador
	 * @param nDados soma dos dados que foram lançados
	 * @param repeteJogada saber se o jogador deve repetir a jogada ou não
	 */
	void trataPosicao(int nJogador, int nDados, boolean repeteJogada) {
    	int resp;
    	int posCasa = api.getPosJogador(nJogador);
		
    	if (api.ehCasaNegociavel(posCasa)) {
    		
    		if (api.casaDesocupada(posCasa)) {
    			resp = frameTabuleiro.exibeCompraProp(posCasa);
    			if (resp == 0) {
    				api.tentativaCompraPropriedade(posCasa);
    			}
    		}
    		
    		else if (api.jogadorEhDonoPropriedade(posCasa)) {
    			boolean podeCasa = api.verificaCasa(posCasa);
    			boolean podeHotel = api.verificaHotel(posCasa);
    			resp = frameTabuleiro.exibeDonoProp(posCasa, podeCasa, podeHotel);
    			if (resp == 1) {
    				api.realizaVenda(nJogador, posCasa, false);
    			}
    			else if (resp == 2 && podeCasa) {
    				api.tentativaCompraImovel(posCasa, 1);
    			}
    			else if ((resp == 2 && podeHotel) || (resp == 3)) {
    				api.tentativaCompraImovel(posCasa, -1);
    			}
    		}
    		
    		else { //casa esta ocupada por outro jogador
    			while (!(api.tentativaPagaPropriedade(posCasa, nDados, false) || api.jogadorIsFalido(nJogador))) {
    				if (!vendaForcada(nJogador)) {
    					api.tentativaPagaPropriedade(posCasa, nDados, true);
    					break;
    				}
    			}
    		}
    	}
    	
    	else if (api.ehPassagem(posCasa)) {
    		if (api.ehPrisao(posCasa)) {
    			api.prende();
    			api.passaVez(false);
    			return;
    		}
    		
    		while (!(api.tentativaPagaPassagem(posCasa, false) || api.jogadorIsFalido(nJogador))) {
    			if (!vendaForcada(nJogador)) {
    				api.tentativaPagaPassagem(posCasa, true);
    				break;
    			}
    		}
    	}
    	
    	else if (api.ehSorteReves(posCasa)) {
    		int carta = api.pickSorteReves();
    		if (carta == 10) {  //carta especial em que todos pagam ao jogador da vez
    			for (int i=0; i<nJogadores; i++) {
    				if (i != nJogador) {
    					while (!(api.tentativaPagaSorteReves(i, carta, false) || api.jogadorIsFalido(i))) {
    	        			if (!vendaForcada(i)) {
    	        				api.tentativaPagaSorteReves(i, carta, true);
    	        				break;
    	        			}
    					}
    				}
    			}
    		}
    		else {
        		while (!(api.tentativaPagaSorteReves(nJogador, carta, false) || api.jogadorIsFalido(nJogador))) {
        			if (!vendaForcada(nJogador)) {
        				api.tentativaPagaSorteReves(nJogador, carta, true);
        				break;
        			}
        		}
    		}
    	}
    	
        else {
            throw new RuntimeException();
        }
		api.passaVez(repeteJogada);
	}
    
	/**
	 * Chamada no frame do tabuleiro para a venda forçada em caso de saldo insuficiente
	 * @param nJogador
	 * @return true se jogador vendeu uma propriedade, false se ele faliu
	 */
    private boolean vendaForcada(int nJogador) {
    	
    	String propriedades[] = api.getPropriedadesJogador(nJogador);
    	
		if (propriedades == null) {
			api.decretarFalenciaJogador(nJogador);
			return false;
		}
		else {
			String propriedadeEscolhida = frameTabuleiro.exibeVendaForcada(propriedades, api.getNomesJogadores()[nJogador]);
			api.realizaVenda(nJogador, api.getPosCasa(propriedadeEscolhida), true);    
			return true;
		}
    }
    
    public void salvarPartida() {
    	JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    	fileChooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
    	fileChooser.setDialogTitle("Salvar partida");
    	fileChooser.setSelectedFile(new File("partida_salva"));
    	int userSelection = fileChooser.showSaveDialog(frameTabuleiro);
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    		Historico.salvarPartida(fileChooser.getSelectedFile() + ".txt", nJogadores, godMode);
        	JOptionPane.showMessageDialog(frameTabuleiro, "Partida salva com sucesso!", "PARTIDA SALVA", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
    
    public void carregarPartida() {
    	JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    	fileChooser.setDialogTitle("Carregar partida");
    	int userSelection = fileChooser.showOpenDialog(frameInicial);
    	if (userSelection == JFileChooser.APPROVE_OPTION) {
    		if (!Historico.carregarPartida(fileChooser.getSelectedFile())) {
    			frameInicial.exibeErroCarregar();
    		}
    	}
    }
    
    // Métodos de passagem
    public int getPosCasa(String p) { return api.getPosCasa(p); }
    
    public String[] getDescricao(int pos) { return api.getDescricao(pos); }
	
	public int[] getDados() { return api.getDados(); }
}