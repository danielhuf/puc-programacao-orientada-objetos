package Model;

abstract class CasaNegociavel extends CasaTabuleiro{
    private Jogador titular;
    private int preco;

    CasaNegociavel(String nome, int preco){
        super(nome);
        this.preco = preco;
        this.titular = null;
    }
      
    int getPreco() { return preco; }

    Jogador getTitular() { return titular; }

    void transfereTitular(Jogador comprador){ titular = comprador; }
    
    abstract int getPrecoVendaForcada();
    abstract int getPrecoMercado();
    abstract void devolve();
}