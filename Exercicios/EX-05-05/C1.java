public class C1 extends C {
    public C1() {
        v1=v2=10;
        s1+=10;
    }
    public static void ms1(int a) {
        s1+=2*a;
    }
    public int calcula(int b) {
        return b+10;
    }
    public int executa(int b) {
        ms1(b);
        return retorna(b);
    }
}