public class Lugar {
    private String cod; //código do lugar - EX: A1
    private boolean livre; //livre-TRUE ocupado-FALSE 
    
    public String getCod() {
        return cod;
    }
    
    public boolean getLivre() {
        return livre;
    }
    
    public void reserva() {
        livre = false;
    }
    
    public Lugar(String s, boolean b) {
        cod = s;
        livre = b;
    }
}
