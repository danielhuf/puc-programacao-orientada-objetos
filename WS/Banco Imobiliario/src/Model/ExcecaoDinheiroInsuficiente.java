package Model;

@SuppressWarnings("serial")
class ExcecaoDinheiroInsuficiente extends Exception {
    public ExcecaoDinheiroInsuficiente() {}
    
    public ExcecaoDinheiroInsuficiente (String mensagem) { super(mensagem); }
}