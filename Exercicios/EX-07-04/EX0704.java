import security.*;
import validation.*;
import java.util.*;

class EX0704 {
  public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      DBAuthorization.carregaDB();
      int cod;
      String psw;
      Checker c = new Checker();

      System.out.println("Informe o código");
      cod  = s.nextInt();
      while (cod > 0) {
          s.nextLine();
          System.out.println("Informe a password");
          psw = s.nextLine();
          if (c.check(cod, psw))
              System.out.println("Porta aberta!");
          else
              System.out.println("Código ou password inválido!");
          System.out.println("Informe o código");
          cod = s.nextInt();
      }
  }
}