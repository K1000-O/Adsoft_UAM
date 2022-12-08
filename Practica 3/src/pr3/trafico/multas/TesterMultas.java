package pr3.trafico.multas;

import pr3.trafico.conductores.*;
import pr3.trafico.vehiculos.*;

import java.util.Arrays;

/**
 * Tester para comprobar el funcionamiento de las multas.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class TesterMultas {

	/**
	 * Main del tester.
	 *
	 * @param args Argumentos de entrada.
	 */
	public static void main(String[] args) {
		Persona ana = new Persona("Ana Soler", 30);		 // Ana 			
		Persona andres = new Persona("Andres Molina", 27);
		Sociedad edsa = new Sociedad("Entregas a Domicilio S.A.", ana);	// Ana es responsable de EDSA
		
		ana.setCarnet(new Carnet(TipoLicencia.B, TipoLicencia.C1));
		andres.setCarnet(new Carnet(TipoLicencia.A));
		
		Vehiculo parque[] = { 
				new Coche("Fiat 500x", 2019, "1245 HYN", true, ana), // Coche de Ana, que lo conduce	
				new Camion("IvecoDaily", 2010, "5643 KOI", 2, edsa), // Coche de EDSA
				new Motocicleta("Harley Davidson", 2003, "0987 ETG", false, andres)};
		
		ProcesadorMultas pm = new ProcesadorMultas(Arrays.asList(parque));
		pm.procesar(LecturaRadares.leer("multas_radar1.txt"));
	}
}
