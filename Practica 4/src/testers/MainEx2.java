package testers;

import java.io.IOException;

import race.*;

/**
 * Clase que implementa el tester del apartado 2.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class MainEx2 {
    
    /** 
     * Main del tester --> Apartado 2.
     * 
     * @param args Argumentos de entrada.
     */
    public static void main (String ... args) {
        Race r;
        try {
            r = RaceReader.read(args[0]);
            r.simulate();
        } catch (IOException e) {
            System.out.println("Error reading the file");
        } catch (RaceException e) {
            System.out.println(e);
        }
    }
}
