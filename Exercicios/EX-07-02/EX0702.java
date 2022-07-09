import Lista.*;
import IR.*;

public class EX0702 {
    public static void main(String[] args) {
        Pilha x=new Lista();
        Contribuinte c;
        c=new PFisica("Joao Santos",3000.00,"11111");
        x.insIni(c);
        c=new PJuridica("Lojas AA",150000.00,"10055");
        x.insIni(c);
        c=new PFisica("Maria Soares",5000.00,"22222");
        x.insIni(c);
        c=new PJuridica("Supermercados B",2000000.00,"10066");
        x.insIni(c);
        c=new PFisica("Carla Maia",1500.00,"33333");
        x.insIni(c);
        c=new PJuridica("Posto XX",500000.00,"10077");
        x.insIni(c);
        while(!x.vazio()) {
            c=(Contribuinte) x.retIni();
            System.out.printf("%s %9.2f\n",c.getNome(),c.calcImposto());
        }
    }
}