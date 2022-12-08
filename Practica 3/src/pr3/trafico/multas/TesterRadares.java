package pr3.trafico.multas;

import java.util.List;

/**
 * Tester de la clase Lectura radares.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class TesterRadares {
	/**
	 * Main del tester.
	 *
	 * @param args Argumentos de entrada.
	 */
	public static void main(String[] args) {
		List<Multa> multas = LecturaRadares.leer("multas_radar1.txt");
		
		for (Multa m : multas) 
			System.out.println(m+"\n------------");		
	}
}
