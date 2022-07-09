package Model;

class Jogador {
    private boolean inPrisao, hasSaidaLivre, falido;
    private int posicao, repeticoesMesmaJogada;
    private ContaBancaria conta;
    private String id;

    Jogador(String nome){
      conta = new ContaBancaria(4000);
      this.id = nome;
    }

    void prende() {
        inPrisao = true;
        this.setPosicao(10);
        this.zeraRepeticoes();
    }

    void solta(){
        inPrisao = false;
        hasSaidaLivre = false;
        this.zeraRepeticoes();
    }
    
    void move(int nAndarCasas) {
    	int posicaoAtual = this.posicao + nAndarCasas;
    	if (posicaoAtual >= Tabuleiro.getNumCasas()) {
    		Tentativa.PagaValor(this, 200);
			posicaoAtual %= Tabuleiro.getNumCasas();
    	}
    	this.setPosicao(posicaoAtual);
    }
    
    void zeraRepeticoes() { repeticoesMesmaJogada = 0; }
    
    void aumentaRepeticoesJogada() { repeticoesMesmaJogada++; }

    void ganhaSaidaLivre() { hasSaidaLivre = true; }
    
    boolean hasSaidaLivre() { return hasSaidaLivre; }
    
    ContaBancaria getConta() { return conta; }
    
    String getId() { return id; }

    int getPos() { return posicao; }
    
    void setPosicao(int posicao) { this.posicao = posicao; }
    
    boolean inPrisao() { return inPrisao; }
    
    boolean isFalido() { return falido; }
    
    void setFalido() { this.falido = true; }
    
    int getRepeticoesJogada() { return repeticoesMesmaJogada; }
    
    void setRepeticoesJogada(int val) { repeticoesMesmaJogada = val; }
}
