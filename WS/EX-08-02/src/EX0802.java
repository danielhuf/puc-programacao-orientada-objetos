import A.*;
import A.B.*;
import A.B.C.*;

public class EX0802 {
	public static void main(String[] args) {
		
		A.Inteiro x=new A.Inteiro();
		A.B.Inteiro y=new A.B.Inteiro();
		A.B.C.Inteiro z= new A.B.C.Inteiro();
		
		System.out.println(x.multiplica(5,6));
		System.out.println(y.subtrai(5,6));
		System.out.println(z.soma(5,6));
	}
}
