public class Vetor {
    // variaveis
    private double x;
    private double y;
    
    // metodos
    public Vetor(double a) {
        x = a;
    }
    
    public Vetor(double a, double b) {
        x = a;
        y = b;
    }
    
    public Vetor() {
        this(0.0, 0.0);
    }
    
    {
        System.out.printf("x=%f y=%f\n", x, y);
    }
    
    public void soma(Vetor v) {
        x += v.x;
        y += v.y;
    }
    
    public static Vetor soma(Vetor v1, Vetor v2) {
        return new Vetor(v1.x + v2.x, v1.y + v2.y);
    }
    
    public void exibe() {
         System.out.printf("x=%f y=%f\n", x, y);
    }
}