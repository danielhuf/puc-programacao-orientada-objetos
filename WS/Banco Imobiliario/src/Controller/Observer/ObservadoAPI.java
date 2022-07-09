package Controller.Observer;

public interface ObservadoAPI {
	void registraObservador(String evento, ObservadorAPI o);   
    void removeObservador(String evento, ObservadorAPI o);     
    void notifica(String evento);
}
