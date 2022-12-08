package pr3.trafico.conductores;

import pr3.trafico.vehiculos.Coche;

/**
 * Tester del apartado 3
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class TesterAp3 {

	/**
	 * Tester para comprobar que una persona menor no puede tener carnet.
	 */
	private void testMenorDe18NoPuedeTenerCarnetA() {
		Persona ana = new Persona("Ana Soler", 17);
		Carnet c = new Carnet(TipoLicencia.A);
		System.out.println("Test: MenorDe18NoPuedeTenerCarnetA");
		System.out.println(c);
		System.out.println(ana.setCarnet(c));		// debe devolver false, porque Ana no tiene 18		
	}

	/**
	 * Tester para comprobar que una persona menor de 23 no puede tener carnet licencia C1.
	 */
	private void testMenorDe23NoPuedeTenerCarnetC1() {
		Persona ana = new Persona("Ana Soler", 19);
		Carnet c = new Carnet(TipoLicencia.A, TipoLicencia.C1);
		System.out.println("=================\nTest: MenorDe18NoPuedeTenerCarnetC1");
		System.out.println(c);			
		System.out.println(ana.setCarnet(c));		// debe devolver false, porque Ana no tiene 23
	}

	/**
	 * Tester para comprobar la categoria de cada carnet.
	 */
	private void testCarnetParaCategoria() {
		Persona ana = new Persona("Ana Soler", 24);
		ana.setCarnet(new Carnet(TipoLicencia.A, TipoLicencia.C1));
		Coche c = new Coche("Fiat 500x", 2019, "1245 HYN", true, ana);
		System.out.println("=================\nTest: CarnetParaCategoria");
		System.out.println(c);		// ana no es el conductor, porque tiene carnet de moto y camión
		ana.getCarnet().addLicencia(TipoLicencia.B);
		c.setConductor(ana);
		System.out.println(c);		// ahora sí
		System.out.println(ana.getCarnet());		// carnet
	}

	/**
	 * Main del tester.
	 * @param args Argumentos de entrada.
	 */
	public static void main(String[] args) {
		TesterAp3 tap3 = new TesterAp3();
		tap3.testMenorDe18NoPuedeTenerCarnetA();
		tap3.testMenorDe23NoPuedeTenerCarnetC1();
		tap3.testCarnetParaCategoria();
	}	
}
