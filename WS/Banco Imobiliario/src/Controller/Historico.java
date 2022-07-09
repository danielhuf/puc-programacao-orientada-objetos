package Controller;

import java.io.*;
import java.util.*;
import Model.ModelFacade;

class Historico {
	
	/**
	 * Salvamento da partida
	 * @param linhas com as informações sobre a partida a ser salva
	 * @param path onde será salvo o arquivo
	 */
	private static void salvarArquivo(List<String> linhas, String path) {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path));
			for (int i=0; i<linhas.size(); i++) {
				outputStream.println(linhas.get(i));
			}
		}
		catch (IOException e) {
			System.out.println("Erro ao salvar a partida do Banco Imobiliário -> " + e.toString());
			System.exit(-1);
		}
		finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
	
	/**
	 * Carregamento da partida
	 * @param path de onde serão carregadas as informações sobre a partida
	 * @return
	 */
	private static List<String[]> carregarArquivo(File path) {
		BufferedReader inputStream = null;
		List<String[]> resp = new ArrayList<String[]>();
		try {
			inputStream = new BufferedReader(new FileReader(path));
			String l;
			while ((l = inputStream.readLine()) != null) {
				resp.add(l.split("_"));
			}
		}
		catch (IOException e) {
			System.out.println("Erro ao carregar a partida do Banco Imobiliário -> " + e.toString());
			System.exit(-1);
		}
		finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("Erro ao fechar arquivo de carregamento -> " + e.toString());
					System.exit(-1);
				}
			}
		}
		return resp;
	}
	
	/**
	 * Reúne as informações a serem salvas da partida
	 * @param path onde será salva a partida
	 * @param nJogadores
	 * @param godMode
	 */
    public static void salvarPartida(String path, int nJogadores, boolean godMode) {
    	
    	int saldosJogadores[], posicoesJogadores[];
    	String nomesJogadores[], nomes, saldos, posicoes, prisao, saidaLivre, falido, repeticoesJogada;
    	List<String> propriedadesTabuleiro, linhas;
    	ModelFacade api = ModelFacade.getAPI();
    	 	
    	nomesJogadores = api.getNomesJogadores();
    	nomes = nomesJogadores[0];
    	
    	saldosJogadores = api.getSaldoJogadores();
    	saldos = String.valueOf(saldosJogadores[0]);
    	
    	posicoesJogadores = api.getPosicaoJogadores();
    	posicoes = String.valueOf(posicoesJogadores[0]);
    	
    	prisao = String.valueOf((api.jogadorInPrisao(0)) ? 1 : 0);
    	saidaLivre = String.valueOf((api.jogadorHasSaidaLivre(0)) ? 1 : 0);
    	falido = String.valueOf((api.jogadorIsFalido(0)) ? 1 : 0);
    	repeticoesJogada = String.valueOf(api.getRepeticoesJogada(0));
    	
    	for (int i=1; i<nJogadores; i++) {
    		nomes += ("_" + nomesJogadores[i]);
    		saldos += ("_" + String.valueOf(saldosJogadores[i]));
    		posicoes += ("_" + String.valueOf(posicoesJogadores[i]));
    		prisao += ("_" + String.valueOf((api.jogadorInPrisao(i)) ? 1 : 0));
    		saidaLivre += ("_" + String.valueOf((api.jogadorHasSaidaLivre(i)) ? 1 : 0));
    		falido += ("_" + String.valueOf((api.jogadorIsFalido(i)) ? 1 : 0));
    		repeticoesJogada += ("_" + String.valueOf(api.getRepeticoesJogada(i)));
    	}
    	
    	linhas = new ArrayList<String>();
    	linhas.add("godMode_" + String.valueOf((godMode) ? 1 : 0));
    	linhas.add("nJogadores_" + String.valueOf(nJogadores));
    	linhas.add("jogadorDaVez_" + String.valueOf(api.getJogadorDaVez()));
    	linhas.add("nomes_" + nomes);
    	linhas.add("saldos_" + saldos);
    	linhas.add("posicoes_" + posicoes);
    	linhas.add("prisao_" + prisao);
    	linhas.add("saidaLivre_" + saidaLivre);
    	linhas.add("falido_" + falido);
    	linhas.add("repeticoesJogada_" + repeticoesJogada);
    	
    	propriedadesTabuleiro = api.getPropriedadesCasasHoteisTitulares();
    	for (int i=0; i<propriedadesTabuleiro.size(); i++) {
    		linhas.add("propriedade_" + propriedadesTabuleiro.get(i));
    	}
    	salvarArquivo(linhas, path);
    }
    
    /**
     * Reúne as informações a serem carregadas da partida
     * @param path onde estão registradas as informações
     * @return true se foi possível ler o arquivo, false caso contrário
     */
    public static boolean carregarPartida(File path) {
    	List<String[]> resp = carregarArquivo(path), propriedades = new ArrayList<String[]>();
    	boolean godMode, prisao[], saidaLivre[], falido[];
    	int nJogadores, jogadorDaVez, saldos[], posicoes[], repeticoesJogada[];
    	String nomes[];
    	
    	try {
        	godMode = resp.get(0)[1].equals("1");
        	nJogadores = Integer.parseInt(resp.get(1)[1]);
        	jogadorDaVez = Integer.parseInt(resp.get(2)[1]);
        	
    		nomes = new String[nJogadores];
    		saldos = new int[nJogadores];
    		posicoes = new int[nJogadores];
    		prisao = new boolean[nJogadores];
    		saidaLivre = new boolean[nJogadores];
    		falido = new boolean[nJogadores];
    		repeticoesJogada = new int[nJogadores];
    		
    		for (int i=0; i<nJogadores; i++) {
    			nomes[i] = resp.get(3)[i+1];
    			saldos[i] = Integer.parseInt(resp.get(4)[i+1]);
    			posicoes[i] = Integer.parseInt(resp.get(5)[i+1]);
    			prisao[i] =  resp.get(6)[i+1].equals("1");
    			saidaLivre[i] =  resp.get(7)[i+1].equals("1");
    			falido[i] =  resp.get(8)[i+1].equals("1");
    			repeticoesJogada[i] = Integer.parseInt(resp.get(9)[i+1]);
    		}
    		
    		for (int i=10; i<38; i++) {
    			propriedades.add(Arrays.copyOfRange(resp.get(i), 1, resp.get(i).length));
    		}
    		
        	Controller.getController().carregarPartidaSalva(nomes, nJogadores, jogadorDaVez, godMode, saldos, posicoes, prisao, saidaLivre, falido, repeticoesJogada, propriedades);
        	return true;
    	}
    	
    	catch (Exception e) {
    		System.out.println("Erro na formatação do arquivo -> " + e.toString());
    		return false;
    	}
    }
}
