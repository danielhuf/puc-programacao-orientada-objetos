public class Xpto {
    public static int constInt = 0;
    
    public Xpto() {
        constInt++;
    }
    
    public static int getQtdInst() {
        return constInt;
    }
}