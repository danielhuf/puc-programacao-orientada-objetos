public class Voo {
    private Assento assentos[][];
    private int nFila;
    private int nAssentos;
    
    public Voo(int nf,int na) {
        char as;
        nFila=nf;
        nAssentos=na;
        assentos=new Assento[nf][na]; //alocação dinâmica da matriz
        for (int i = 0; i < nf; i++) {
            //as = 'A';
            for (int j = 0; j < na; j++) {
                assentos[i][j] = new Assento(i, (char)(j + 'A')); //no gabarito, está: new Assento(i+1, as); as++;
            }
        }
    }
    
    public boolean reserva(int f, char a) {
        if (f < 0 || f > nFila || (a - 'A' + 1) < 0 || (a - 'A' + 1) > nAssentos)
            return false;
        Assento ass = assentos[f-1][a - 'A'];
        if (ass.getEstado()) { //assento está livre
            ass.reserva();
            return true;
        }
        else
            return false;
    }
    
    public void imprimeMapa() {
        System.out.print("   ");
        for (int i = 0; i < nAssentos; i++)
            System.out.print(" " + String.valueOf((char)(i + 'A')));
        System.out.println();
        for (int i = 0; i < nFila; i++) {
            System.out.print(String.format("%02d- " , i+1));
            for (int j = 0; j < nAssentos; j++) {
                if (assentos[i][j].getEstado())
                    System.out.print("L ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }
}