package Model;

abstract class CasaTabuleiro {
    private String nome;
    
    CasaTabuleiro(String nome) { this.nome = nome; }
    
    String getNome() { return nome; }
}