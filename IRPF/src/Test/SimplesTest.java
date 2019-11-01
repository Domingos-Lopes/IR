package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Controller.ServiceSimplificado;
import Model.Entities.Pessoa;

class SimplesTest {
	
	@Test
	public void testSimples30000() {
		Pessoa p = new Pessoa("Domingos", "0123", 30000, 1000 );
		ServiceSimplificado sp = new ServiceSimplificado(p);
		sp.imposto();
		double target = 2776;
		System.out.println(sp.getImposto());
		double dif = sp.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	@Test
	public void testSimples20000() {
		Pessoa p = new Pessoa("Domingos", "0123", 20000, 1000 );
		ServiceSimplificado sp = new ServiceSimplificado(p);
		sp.imposto();
		double target = 907;
		//System.out.println(sp.getImposto());
		double dif = sp.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}

	@Test
	public void testSimples10000() {
		Pessoa p = new Pessoa("Domingos", "0123", 10000, 1000 );
		ServiceSimplificado sp = new ServiceSimplificado(p);
		sp.imposto();
		double target = 0;
		//System.out.println(sp.getImposto());
		double dif = sp.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}

}
