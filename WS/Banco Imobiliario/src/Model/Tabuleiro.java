package Model;
import java.util.*;

class Tabuleiro {
	private static final int N_CASAS = 40;
    private static final CasaTabuleiro tabuleiro[]= new CasaTabuleiro[N_CASAS];
    private static Tabuleiro tab = null;
    
    /**
     * Implementacao do padrao singleton
     * @return instancia de tabuleiro (objeto Tabuleiro)
     */
    static Tabuleiro getTabuleiro() {
    	if (tab == null) {
    		tab = new Tabuleiro();
    	}
    	return tab;
    }

    private Tabuleiro() {
        tabuleiro[0] = new Passagem("Ponto de Partida", 0);
        tabuleiro[1] = new Terreno("Leblon", 100, 6, 30, 90, 270, 400, 500, 50);
        tabuleiro[2] = new SorteReves("Sorte Reves"); 
        tabuleiro[3] = new Terreno("Av. Presidente Vargas", 60, 2, 10, 30, 90, 160, 250, 50);
        tabuleiro[4] = new Terreno("Av. Nossa S. de Copacabana", 60, 4, 20, 60, 180, 320, 450, 50);
        tabuleiro[5] = new Companhia("Companhia Ferroviária", 200, 50);
        tabuleiro[6] = new Terreno("Av. Brig. Faria Lima", 240, 20, 100, 300, 750, 925, 1100, 150);
        tabuleiro[7] = new Companhia("Companhia de Viação", 200, 50);
        tabuleiro[8] = new Terreno("Av. Rebouças", 220, 18, 90, 250, 700, 875, 1050, 150);
        tabuleiro[9] = new Terreno("Av. 9 de julho", 220, 18, 90, 250, 700, 875, 1050, 150);
        tabuleiro[10] = new Passagem("Prisão", 0);
        tabuleiro[11] = new Terreno("Av. Europa", 200, 16, 80, 220, 600, 800, 1000, 100);
        tabuleiro[12] = new SorteReves("Sorte Reves"); 
        tabuleiro[13] = new Terreno("Rua Augusta", 180, 14, 70, 200, 550, 750, 950, 100);
        tabuleiro[14] = new Terreno("Av. Pacaembú", 180, 14, 70, 200, 550, 750, 950, 100);
        tabuleiro[15] = new Companhia("Companhia de Táxi", 150, 40);
        tabuleiro[16] = new SorteReves("Sorte Reves");
        tabuleiro[17] = new Terreno("Interlagos", 350, 35, 175, 500, 1100, 1300, 1500, 200);
        tabuleiro[18] = new Passagem("Lucros ou Dividendos", 200);
        tabuleiro[19] = new Terreno("Morumbi", 400, 50, 200, 600, 1400, 1700, 2000, 200);
        tabuleiro[20] = new Passagem("Parada Livre", 0);
        tabuleiro[21] = new Terreno("Flamengo", 120, 8, 40, 100, 300, 450, 600, 50);
        tabuleiro[22] = new SorteReves("Sorte Reves");
        tabuleiro[23] = new Terreno("Botafogo", 100, 6, 30, 90, 270, 400, 500, 50);
        tabuleiro[24] = new Passagem("Imposto de Renda", -200);
        tabuleiro[25] = new Companhia("Companhia de Navegação", 150, 40);
        tabuleiro[26] = new Terreno("Av. Brasil", 160, 12, 60, 180, 500, 700, 900, 100);
        tabuleiro[27] = new SorteReves("Sorte Reves");
        tabuleiro[28] = new Terreno("Av. Paulista", 140, 10, 50, 150, 450, 625, 750, 100);
        tabuleiro[29] = new Terreno("Jardim Europa", 140, 10, 50, 150, 450, 625, 750, 100);
        tabuleiro[30] = new Passagem("Vá para a Prisão", 0);
        tabuleiro[31] = new Terreno("Copacabana", 260, 22, 110, 330, 800, 975, 1150, 150);
        tabuleiro[32] = new Companhia("Companhia de Aviação", 200, 50);
        tabuleiro[33] = new Terreno("Av. Vieira Souto", 320, 28, 150, 450, 1000, 1200, 1400, 200);
        tabuleiro[34] = new Terreno("Av. Atlântica", 300, 26, 130, 390, 900, 1100, 1275, 200);
        tabuleiro[35] = new Companhia("Companhia de Táxi Aéreo", 200, 50);
        tabuleiro[36] = new Terreno("Ipanema", 300, 26, 130, 390, 900, 1100, 1275, 200);
        tabuleiro[37] = new SorteReves("Sorte Reves");
        tabuleiro[38] = new Terreno("Jardim Paulista", 280, 24, 120, 360, 850, 1025, 1200, 150);
        tabuleiro[39] = new Terreno("Brooklin", 260, 22, 110, 330, 800, 975, 1150, 150);
    }
    
    static int getNumCasas() { return N_CASAS; }

    static CasaTabuleiro getCasa(int pos) { return tabuleiro[pos]; }
    
    /**
     * 
     * @param p Nome da carta
     * @return Posição da carta no array 'tabuleiro'
     */
    static int getPos(String p) {
    	int pos = 0;
    	for (CasaTabuleiro c: tabuleiro) {
    		if (p.startsWith(c.getNome())) {
    			return pos;
    		}
    		pos++;
    	}
    	return -1;
    }
    
    /**
     * Cria uma descrição de uma casa do tabuleiro
     * @param pos posição da casa no array 'tabuleiro'
     * @return array com descrições sobre a casa
     */
    static String[] getDesc(int pos) {
    	String[] descricao;
    	CasaTabuleiro c = tabuleiro[pos];
    	if (c instanceof Terreno) {
    		Terreno t = (Terreno) c;
    		descricao = new String[4];
    		descricao[0] = "Preço: $" + Integer.toString(t.getPreco());
    		if (t.getTitular() == null) {
    			descricao[1] = "Titular: sem titular";
    		}
    		else {
    			descricao[1] = "Titular: " + t.getTitular().getId();
    		}
    		descricao[2] = "Casas: " + Integer.toString(t.getNCasas());
    		descricao[3] = "Hoteis: " + Integer.toString(t.getNHoteis());
    	}
    	else if (c instanceof Companhia) {
    		Companhia cp = (Companhia) c;
    		descricao = new String[2];
    		descricao[0] = "Preço: $" + Integer.toString(cp.getPreco());
    		if (cp.getTitular() == null) {
    			descricao[1] = "Titular: sem titular";
    		}
    		else {
    			descricao[1] = "Titular: " + cp.getTitular().getId();
    		}
    	}
    	else {
    		descricao = new String[] {""};
    	}
    	return descricao;
    }
    
    /**
     * 
     * @param j 
     * @return Lista de propriedades a serem exibidas na combo box de venda forçada
     */
    static List<CasaNegociavel> getPropriedadesJogador(Jogador j) {
    	List<CasaNegociavel> propriedades = new ArrayList<CasaNegociavel>();
    	for (CasaTabuleiro c: tabuleiro){
    		if(c instanceof CasaNegociavel && ((CasaNegociavel) c).getTitular() == j) {
    			propriedades.add((CasaNegociavel) c);
    		}
    	}
    	return propriedades;
    }
    
    /**
     * 
     * @return Lista de propriedades a serem exibidas na combo box de seleção de propriedades
     */
    static String[] getPropriedades() {
    	List<String> propriedades = new ArrayList<String>();
    	for (CasaTabuleiro c: tabuleiro){
    		if(c instanceof CasaNegociavel) {
    			propriedades.add(c.getNome());
    		}
    	}
    	return propriedades.toArray(new String[propriedades.size()]);
    }
    
    /**
     * 
     * @return Lista com os dados sobre as propriedades a serem escritos no arquivo de salvamento
     */
    static List<String> getPropriedadesCasasHoteisTitulares() {
    	List<String> resp = new ArrayList<String>();
    	String titular;
    	
    	for (CasaTabuleiro c: tabuleiro) {
    		if(c instanceof CasaNegociavel) {
    			if (((CasaNegociavel)c).getTitular() == null) {
    				titular = "null";
    			}
    			else {
    				titular = ((CasaNegociavel)c).getTitular().getId();
    			}
    			if (c instanceof Companhia) {
    				resp.add(c.getNome() + "_" + titular);
    			}
    			else {  //é terreno
    				resp.add(c.getNome() + "_" + titular + "_" + String.valueOf(((Terreno)c).getNCasas()) + "_" + String.valueOf(((Terreno)c).getNHoteis()));
    			}
    		}
    	}
    	return resp;
    }
}