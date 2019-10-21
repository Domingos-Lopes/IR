package Test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Controller.ServiceCompleto;
import Model.Entities.ContribuinteCompleto;

class CPtest {
	
	@Test
	public void testIdoso6dep10000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 70, 20000, 1000, 6 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 879;
		System.out.println(sc.getDesconto());
		System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	@Test
	public void testIdoso3dep10000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 70, 10000, 1000, 3 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 0;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	@Test
	public void testIdoso0dep30000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 70, 30000, 1000, 0 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 2935;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	@Test
	public void testIdoso0dep20000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 70, 20000, 1000, 0 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 964;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	@Test
	public void testIdoso0dep10000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 70, 10000, 1000, 0 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 0;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	@Test
	public void testNormal6dep30000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 30000, 1000, 6 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 2776;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	@Test
	public void testNormal6dep20000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 20000, 1000, 6 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 907;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}

	@Test
	public void testNormal6dep10000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 10000, 1000, 6 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 0;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	
	@Test
	public void testNormal3dep30000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 30000, 1000, 3 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 2895;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}

	
	@Test
	public void testNormal3dep20000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 20000, 1000, 3 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 950;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
	}
	
	
	@Test
	public void testNormal3dep10000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 10000, 1000, 3 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 0;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
		
	}
	
	
	
	@Test
	public void testNormal0dep30000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 30000, 1000, 0 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 3015;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
		
	}
	
	
	@Test
	public void testNormal0dep20000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 20000, 1000, 0 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 993;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
		
	}
	
	@Test
	public void testNormal0dep10000() {
		ContribuinteCompleto cp = new ContribuinteCompleto("Domingos", "0123", 20, 10000, 1000, 0 );
		ServiceCompleto sc = new ServiceCompleto(cp);
		sc.desconto();
		sc.imposto();
		double target = 0;
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - target;
		assertTrue(Math.abs(dif) < 1.0);	
		
	}
	
	
	
	@Test
	public void test() {
		ContribuinteCompleto target = new ContribuinteCompleto("Domingos", "0123", 70, 50000, 1000, 3);
		ServiceCompleto sc = new ServiceCompleto(target);
		sc.desconto();
		sc.imposto();
		//System.out.println(sc.getDesconto());
		//System.out.println(sc.getImposto());
		double dif = sc.getImposto() - 8068;
		assertTrue(Math.abs(dif) < 1.0);	
		
	}

}
