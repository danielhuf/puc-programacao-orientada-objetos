import java.util.*;

public class EX0705 {
    public static void main(String[] args) {
        Sala []ls;
        Scanner e=new Scanner(System.in);
        Sala sala;
        int s,i;
        String lugar;
        boolean resp;
        ls = new Sala[2];  
        ls[0] = new Sala(410);  //numero da primeira sala
        ls[1] = new Sala(516);  //numero da primeira sala
        
        System.out.println("Informe a sala");
        s=e.nextInt();
        for (i=0; i<ls.length && ls[i].getNum()!=s; i++);
        
        if (i == ls.length)
            System.out.println("Sala Inexistente");
        else {
            e.nextLine();
            System.out.println("Informe o lugar");
            lugar=e.nextLine();   // Também poderia ser lugar=e.next(); sem colocar o nextLine() sozinho antes
            resp = ls[i].reserva(lugar);
            if (resp)
                System.out.println("Reserva Efetuada");
            else
                System.out.println("Reserva Não Efetuada");
        }
    }
}
