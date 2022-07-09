public class Sala {
    private int num; //número da sala EX: 1
    private Lugar []lugares; //relação de lugares de uma sala
    
    public int getNum() {
        return num;
    }
    
    public Sala(int n) {
        lugares = new Lugar[4];
        lugares[0] = new Lugar("A1", true);
        lugares[1] = new Lugar("A2", true);
        lugares[2] = new Lugar("A3", false);
        lugares[3] = new Lugar("A4", false);
        num = n;
    }
    
    public boolean reserva(String c) {
        for (Lugar l:lugares) {
            if (l.getCod().compareTo(c) == 0) {
                if (l.getLivre()) {
                    l.reserva();
                    return true;
                }
                else 
                    break;
            }
        }
        return false;
    }
}