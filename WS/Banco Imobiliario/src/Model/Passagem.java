package Model;

class Passagem extends CasaTabuleiro {
    private int valor;

    Passagem(String nome, int valor) {
        super(nome);
        this.valor = valor;
    }

    int getValor() { return valor; }
}