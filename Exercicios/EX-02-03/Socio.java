public class Socio {
    private String nome, endereco, dtNasc;
    private int matric;
    
    public Socio(int x) {
        matric = x;
    }
    
    public String getMatric() {
        return Integer.toString(matric / 10) + "-" + Integer.toString(matric % 10);
    }
}