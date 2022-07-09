import erro.*;

public class PJuridica extends Contribuinte
{
	protected String cnpj;
	
	
	public PJuridica(String n,double r,String c)
	{
		nome=n;
		rendaBrt=r;
		cnpj=c;
	}
	
	public double calcImposto() throws SalarioZeradoPJ {
		if(rendaBrt == 0.0)
			throw new SalarioZeradoPJ(cnpj);
		
		return rendaBrt*0.1;
	}
}
