import pr3.trafico.conductores.*;
import pr3.trafico.vehiculos.*;

/**
 * Tester usado para comprobar la implementacion de conductores.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class TesterPr31 {

	/**
	 * MAin del tester.
	 *
	 * @param args Argumentos de entrada.
	 */
	public static void main(String[] args) {
		Persona ana = new Persona("Ana Soler", 30);		 // Ana 			
		Persona luisa = new Persona("Luisa Puerto", 17);
		Persona andres = new Persona("Andres Molina", 27);
		Sociedad edsa = new Sociedad("Entregas a Domicilio S.A.", ana);	// Ana es responsable de EDSA
		
		Vehiculo parque[] = { 
				new Coche("Fiat 500x", 2019, "1245 HYN", true, ana), // Coche de Ana, que lo conduce		
				new Camion("IvecoDaily", 2010, "5643 KOI", 2, edsa), // Coche de EDSA
				new Motocicleta("Harley Davidson", 2003, "0987 ETG", false)};
		
		parque[2].setPropietario(ana);
		// El método setPropietario debe permitir pasar una Sociedad: parque[2].setPropietario(edsa);
		System.out.println("Luisa puede conducir una Harley? " + parque[2].setConductor(luisa));
		// Luisa, al ser menor de 18 no puede ser conductora			
		
		for (Vehiculo v : parque ) {
			System.out.println(v);
			System.out.println("------------------------");
		}
		
		parque[2].setConductor(andres);
		System.out.println(parque[2]);
		System.out.println("Personas:");
		System.out.println(andres+"\n---");				
		System.out.println(ana+"\n---");
		System.out.println("Sociedad:");
		System.out.println(edsa);
	}
}
