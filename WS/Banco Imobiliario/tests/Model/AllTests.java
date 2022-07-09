package Model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	BancoTest.class, 
	CasaNegociavelTest.class, 
	CompanhiaTest.class, 
	ContaBancariaTest.class, 
	DadoTest.class,
	JogadorTest.class, 
	SorteRevesTest.class, 
	TabuleiroTest.class, 
	TentativaTest.class, 
	TerrenoTest.class 
	})

public class AllTests { }
