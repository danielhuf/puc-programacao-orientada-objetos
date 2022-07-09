package Lista;

public class NovaPilha extends Lista implements Pilha {
    public void push(Object x) {
        insIni(x);
    }
    public Object pop() {
        return retIni();
    }
}