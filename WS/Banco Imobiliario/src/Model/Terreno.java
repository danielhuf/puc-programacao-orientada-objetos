package Model;

class Terreno extends CasaNegociavel{
    private int nCasas, nHoteis, cHotel, custoConstrucao, custoAluguel[];
    private static int totCasas, totHoteis;
    private static final int TOT_CASAS = 32;  //total de casas permitidas em todo o tabuleiro
    private static final int TOT_HOTEIS = 12; //total de hotéis permitidos em todo o tabuleiro
    private static final int N_CASAS = 4;
    private static final int N_HOTEIS = 1;

    Terreno(String nome, int preco, int aluguel, int c1casa, int c2casa, int c3casa, int c4casa, int cHotel, int custoConstrucao) {
        super(nome, preco);
        custoAluguel = new int[]{aluguel, c1casa, c2casa, c3casa, c4casa};
        this.cHotel = cHotel;
        this.custoConstrucao = custoConstrucao;
    }

    int getPrecoAluguel() { return nHoteis*cHotel + custoAluguel[nCasas]; }
    
    int getCustoConstrucao() { return custoConstrucao; }
    
    int getPrecoVendaForcada() { return (int) (0.9 * (this.getPreco() + custoConstrucao * (nCasas + nHoteis))); }
    
    int getPrecoMercado() { return (this.getPreco() + custoConstrucao * (nCasas + nHoteis)); }
    
    int getNCasas() { return nCasas; }
    
    void setNCasas(int val) { nCasas = val; }
    
    int getNHoteis() { return nHoteis; }
    
    void setNHoteis(int val) { nHoteis = val; }
    
    /**
     * Verificação da condição para comprar uma casa
     * @return true se pode comprar, false caso contrário
     */
    boolean verificaCasa() { return nCasas < N_CASAS && totCasas < TOT_CASAS; }
    
    /**
     * Verificação da condição para comprar um hotel
     * @return true se pode comprar, false caso contrário
     */
    boolean verificaHotel() { return nCasas >= 1 && nHoteis < N_HOTEIS && totHoteis < TOT_HOTEIS; }
    
    /**
     * Registra um novo imovel comprado em uma instância de Terreno
     * @param imovel 1 se for uma casa, caso contrário é um hotel
     */
    void imovelComprado(int imovel) {
    	if (imovel == 1) { //é uma casa
    		nCasas++;
    		totCasas++;
    	}
    	else {  //é um hotel
    		nHoteis++;
    		totHoteis++;
    	}
    }
    
    void devolve() {
    	this.transfereTitular(null);
    	totCasas -= nCasas;
    	totHoteis -= nHoteis;
    	nCasas = 0;
    	nHoteis = 0;
    }
}