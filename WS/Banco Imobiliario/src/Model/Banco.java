package Model;

class Banco {
  private static ContaBancaria conta;
  private static Banco bc = null;

  private Banco() { conta = new ContaBancaria(200000); }
  
  /**
   * Implementacao do padrao singleton
   * @return instancia de banco (objeto Banco)
   */
  static Banco getBanco() {
	  if (bc == null) {
		  bc = new Banco();
	  }
	  return bc;
  }
                   
  ContaBancaria getConta(){ return conta; }
  
  /**
   * Cria nova instancia de banco caso o saldo tenha se esgotado
   */
  void abastece() { conta = new ContaBancaria(200000); }
}