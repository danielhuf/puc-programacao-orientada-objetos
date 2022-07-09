package Model;

class Companhia extends CasaNegociavel {
    private int taxa;

    protected Companhia(String nome, int preco, int taxa) {
        super(nome, preco);
        this.taxa = taxa;
    }

    /**
     * Calcula a taxa a ser paga ao parar em uma companhia com dono
     * @param nDados número dos dados lançados
     * @return número dos dados vezes a taxa da companhia
     */
    int getTaxa(int nDados){ return nDados * taxa; }
    
    int getPrecoVendaForcada() { return (int) (0.9 * this.getPreco()); }
    
    int getPrecoMercado() { return (this.getPreco()); }
    
    void devolve() { this.transfereTitular(null); }
}