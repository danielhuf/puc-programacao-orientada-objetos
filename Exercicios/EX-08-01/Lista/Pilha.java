package Lista;

public class Pilha {
	private Lista ls=new Lista();
	
	public boolean vazio() {
		return ls.vazio();
	}
	
	public boolean push(Object x) {
		return ls.insIni(x);
	}
	
	public Object pop() {
		if(ls.vazio())
			return null;
		
		return ls.retIni();
	}
}