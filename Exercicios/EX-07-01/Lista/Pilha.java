package Lista;

public class Pilha {
    Lista ls = new Lista();

    public boolean vazio() {
        return ls.vazio();
    }

    public void push(Object x) {
        ls.insIni(x);
    }

    public Object pop() {
        return ls.retIni();
    }
}