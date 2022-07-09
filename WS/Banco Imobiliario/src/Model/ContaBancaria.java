package Model;

class ContaBancaria {
    private int saldo;

    ContaBancaria(int saldo) { this.saldo = saldo; }

    void depositar(int valor) { saldo += valor; }

    void sacar(int valor) throws ExcecaoDinheiroInsuficiente{
        if (saldo - valor < 0){
          throw new ExcecaoDinheiroInsuficiente("Dinheiro Insuficiente");
        }
        saldo -= valor;
    }

    boolean paga(ContaBancaria destino, int valor) {
    	try {
    		this.sacar(valor);
    		destino.depositar(valor);
    		return true;
    	}
        catch (ExcecaoDinheiroInsuficiente e){
        	return false;
        }
    }

    int getSaldo() { return saldo; }
    
    void setSaldo(int val) { saldo = val; }
} 