import lista.Lista;

class EX0403 {
  public static void main(String[] args) {
      Lista x = new Lista();
      Vetor v;

      // No aux = new No(new Vetor(2.0, 3.0), null);
      // System.out.println(aux.getElem().toString());
      // Tentei criar e não funcionou, pois eu só importo
      // a classe Lista para a Main

      x.insIni(new Vetor(2.0, 3.0));
      x.insFin(new Vetor(4.0, 5.0));
      x.insIni(new Vetor(6.0, 7.0));
      x.insFin(new Vetor(8.0, 9.0));

      x.posIni();
      v = (Vetor) x.prox();
      while(v != null) {
          System.out.printf("%s \n", v.toString());
          v = (Vetor) x.prox();
      }

      System.out.println();
      v = (Vetor) x.retIni();
      System.out.printf("%s foi retirado \n", v.toString());
      v = (Vetor) x.retFin();
      System.out.printf("%s foi retirado \n", v.toString());

      System.out.println();
      x.posIni();
      v = (Vetor) x.prox();
      while(v != null) {
          System.out.printf("%s \n", v.toString());
          v = (Vetor) x.prox();
      }

      System.out.println();
      x.retIni();
      x.retFin();
      if (x.vazio())
          System.out.println("A lista está vazia");
      else
          System.out.println("A lista não está vazia");
  }
}