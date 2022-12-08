package testers;

import java.io.IOException;

import race.*;

/**
* Clase que implementa el tester 4.
* 
* @author estudianteEPS alejandror.hurtado@estudiante.uam.es
* @author estudianteEPS camilo.jenec@estudiante.uam.es
*/
public class MainEx4 {

    /** 
     * Main del tester --> Apartado 4.
     * 
     * @param args Argumentos de entrada.
     */
    public static void main(String [] args) {
        Race r;
        try {
            r = RaceReader.read(args[0]);
            r.allowAttacks(true);
            r.allowPowerUps(true);
            r.simulate();
        } catch (IOException e) {
            System.out.println("Error reading the file");
        } catch (RaceException e) {
            System.out.println(e);
        }
    }
}
