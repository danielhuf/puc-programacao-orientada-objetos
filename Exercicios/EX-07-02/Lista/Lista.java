package Lista;

public class Lista implements Pilha{
    private int tam=0;
    private No ini=null;
    private No fin=null;
    private No corr=null;
    
    public boolean vazio() {
        if (tam == 0)
            return true;
        else
            return false;
    }
    
    public void insIni(Object x) {
        No aux = new No(x, ini);
        ini = aux;
        if (tam == 0)
                fin = ini;
        tam++;
    }
    
    public void insFin(Object x) {
        if (tam == 0) {
            insIni(x);
            return;
        }
        No aux = new No(x, null);
        fin.setProx(aux);
        fin = aux;
        tam++;
    }
    
    public Object retIni() {
        if (tam == 0)
            return null;
        Object ret = ini.getElem();
        ini = ini.getProx();
        tam--;
        if (tam == 0)
            fin = null;
        return ret;
    }
    
    public Object retFin() {
        if (tam == 0)
            return null;
        if (tam == 1) {
            Object ret = ini.getElem();
            ini = fin = null;
            tam = 0;
            return ret;
        }
        No p = ini, ant=null;
        while (p != fin) {
            ant = p;
            p = p.getProx();
        }
        Object ret = p.getElem();
        ant.setProx(null);
        tam--;
        fin = ant;
        return ret;
    }
    
    public void posIni() {
        corr = ini;
    }
    
    public Object prox() {
        if (corr == null)
            return null;
        Object o = corr.getElem();
        corr = corr.getProx();
        return o;
    }
}
