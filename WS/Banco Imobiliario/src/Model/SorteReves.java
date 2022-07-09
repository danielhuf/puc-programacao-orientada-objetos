package Model;
import java.util.*;

class SorteReves extends CasaTabuleiro {

    private static final int N_SORTE_REVES = 30;
    private static List<Integer> cartasSorteReves = new ArrayList<Integer>();
    private static int posCartaCorrente = 0; // carta corrente a ser pega do baralho de Sorte ou Reves
    private static boolean SaidaLivreInDeck = true;
    private static final int valoresCartas[] = 
    {25, 150, 80, 200, 50, 50, 100, 100, 0, 200, -50, 45, 100, 100, 20,
     -15, -25, -45, -30, -100, -100, -40, 0, -30, -50, -25, -30, -45, -50, -50};
    
    static {  // lista com Sorte ou Reves será embaralhada 1 vez no inicio do jogo
        for (int i=0; i<N_SORTE_REVES; i++)
            cartasSorteReves.add(i);
        java.util.Collections.shuffle(cartasSorteReves);
    }

    SorteReves(String nome) { super(nome); }
    
    static void tomaSaidaLivre() { SaidaLivreInDeck = false; }

    static void devolveSaidaLivre() { SaidaLivreInDeck = true; }
    
    static int getValor(int carta) { return valoresCartas[carta]; }
    
    /**
     * Seleciona a carta corrente do baralho
     * @return número da carta
     */
    static int pickSorteReves() {
    	int carta = cartasSorteReves.get(posCartaCorrente);
    	if (carta == 8) { //trata a seleção da carta de Saída Livre
            if (SaidaLivreInDeck) {
            	tomaSaidaLivre();
            }
            else {
                posCartaCorrente++;
                posCartaCorrente %= N_SORTE_REVES;
                return pickSorteReves();
            }
    	}
        posCartaCorrente++;
        posCartaCorrente %= N_SORTE_REVES;
        return carta;
    }
}