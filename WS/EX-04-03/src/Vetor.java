public class Vetor {
    private double x,y;
    
    public Vetor(double x,double y) {
        this.x=x;
        this.y=y;
    }
    
    private Vetor() {
    }
    
    public Vetor clone() {
        Vetor v = new Vetor();
        v.x = x;  //posso fazer isso porque estou acessando a variavel de instancia dentro da propria classe
        v.y = y;
        
        return v;
    }
    
    public String toString() {
        return String.format(" ( %.2f , %.2f )", x, y);
    }
    
    public boolean equals(Object o) {
        Vetor v = (Vetor) o;
        if (x == v.x && y == v.y)
            return true;
        else
            return false;
    }
}
