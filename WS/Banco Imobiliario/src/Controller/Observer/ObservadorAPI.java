package Controller.Observer;

public interface ObservadorAPI {
	// Sobrecargas do m�todo atualiza
    void atualiza(String eventType);
    void atualiza(String eventType, int quant1);
    void atualiza(String eventType, String name, int quant1, int quant2);
}
