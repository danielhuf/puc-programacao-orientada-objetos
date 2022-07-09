public abstract class C {
    public int v1=10,v2=20;
    public static int s1=30;
    public C() {
        v1*=2;
        v2*=2;
        s1+=10;
    }
    public static void ms1(int a) {
        s1+=a;
    }
    public int retorna(int b) {
        return v1+v2+s1+calcula(b);
    }
    public int calcula(int b) {
        return 2*b;
    }
    public abstract int executa(int b);
}
