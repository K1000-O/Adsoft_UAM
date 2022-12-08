package testers;


import java.io.IOException;

import race.*;

/**
 * Tester del apartado 1.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class MainEx1 {
    /**
     * Main del tester --> Apartado 1.
     * 
     * @param args Argumentos de entrada.
     */
    public static void main(String ... args) {
        Race r;

        try {
            r = RaceReader.read(args[0]);
            System.out.println(r);
        } catch (IOException e) {
            System.out.println("Error reading the file");
        } catch (RaceException e) {
            System.out.println(e);
        }
    }
}
