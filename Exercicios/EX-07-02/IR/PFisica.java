package IR;

public class PFisica extends Contribuinte {
    protected String cpf;
    public PFisica(String n,double r,String c) {
        nome = n;
        rendaBrt = r;
        cpf = c;
    }
    public double calcImposto() {
        if (rendaBrt <= 1400) 
            return 0.0;
        else if (rendaBrt <= 2100) 
            return 0.1*rendaBrt - 100;
        else if (rendaBrt <= 2800)
            return 0.15*rendaBrt - 270;
        else if (rendaBrt <= 3600)
            return 0.25*rendaBrt - 500;
        else
            return 0.3*rendaBrt - 700;
    }
}