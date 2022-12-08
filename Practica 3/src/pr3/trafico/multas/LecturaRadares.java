package pr3.trafico.multas;

import java.io.*;
import java.util.*;

/**
 * Clase que lee las multas de un fichero de texto.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class LecturaRadares {

    /**
     * Clase estatica para poder llamarla desde cualquier lado. Lee un fichero de texto y crea las multas.
     *
     * @param nombreFichero fichero de texto a leer.
     * @return ArrayList
     */
    public static ArrayList<Multa> leer(String nombreFichero) {
        ArrayList<Multa> multas = new ArrayList<>();
        BufferedReader br = null;
        String texto;

        try {
            br = new BufferedReader(new FileReader(nombreFichero));

            texto = br.readLine();

            while (texto != null) {
                multas.add(new Multa(texto.split(";")[0], texto.split(";")[1],
                        Integer.parseInt(texto.split(";")[2])));

                texto = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error de apertura de fichero");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error de lectura del fichero");
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero.");
                e.printStackTrace();
            }
        }

        return multas;
    }
}
