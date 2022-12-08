package forms;

import java.io.*;
import java.util.*;

/**
 * Clase Form. Clase formulario en la que introduciremos los distintos campos
 * a rellenar en forma de objetos de tipo Field.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Form extends AbstractForm {
    /**
     * Hasmap en el que guardamos los campos que introducimos en el formulario
     * guardando la pregunta como clave junto con el resto de información.
     */
    private Map<String, Field<?>> formulario = new LinkedHashMap<>();

    /**
     * Método add que utilizamos para añadir Campos a un formulario.
     * 
     * @param pregunta texto con la pregunta del campo a rellenar.
     * @param campo infomracion con el tipo de campo que es el Field.
     * 
     * @return Form formulario con e nuevo campo añadido.
     */
    public Form add(String pregunta, Field<?> campo) {
        formulario.putIfAbsent(pregunta, campo);

        return this;
    }

    /**
     * Método para rellenar un formulario.
     * Imprime por pantalla las preguntas de los campos que contiene,
     * guarda sus respuestas y comprueba que estas sean aceptables.
     * 
     * @return Map nuevo Hashmap con las respuestas dadas a cada uno de los campos.
     * @throws IOException Error en caso de mala lectura.
     */
    public Map<String, ?> exec() throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String valorTeclado = null;
        boolean comprobacion = false;
        Map<String, Object> aImprimir = new LinkedHashMap<>();

        for (Map.Entry<String, Field<?>> entry : formulario.entrySet()) {
            while(!comprobacion) {
                System.out.println(entry.getKey() + " > ");
 
                valorTeclado = br.readLine();

                comprobacion = entry.getValue().comprobarValidaciones(valorTeclado);
            }

            aImprimir.put(entry.getKey(), entry.getValue().getFuncion().apply(valorTeclado));

            comprobacion = false;
        }

        return aImprimir;
    }
}
