package forms;

import java.util.*;
import java.util.function.*;

/**
 * Clase que implementa un objeto de tipo Field.
 * Cada field tendrá una pregunta y un campo para una respuesta que se rellenará tras rellenar el formulario.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Field<A extends Comparable<A>> {
    /**
     * Elemento de tipo function con dos atributos, un string y un elemento genérico.
     */
    private Function<String, A> funcion;

    /**
     * Hasmap con las condiciones a cumplir en cada tipo de Field.
     * La clave será una condición que se validará si el dato intruducido la cumple.
     * También contiene un string con el texto que se imprime si no se cumple la validación.
     */
    private Map<Predicate<A>, String> validaciones = new HashMap<>();

    /**
     * Constructor de la clase Field, recibe la información por argumento y la guarda.
     * 
     * @param f elemento de tipo Function con la información del field.
     */
    public Field (Function<String, A> f) {
        funcion = f;
    }

    /**
     * Método para añadir una condición de validación a la lista.
     * El método solo lo introduce si la validación no estaba en la lsita previamente.
     * 
     * @param p predicate con la condición a cumplir para validar.
     * @param texto texto que se imprime si la condición no se cumple.
     * 
     * @return Field campo con la condición de validación ya añadida.
     */
    public Field<A> addValidation(Predicate<A> p, String texto) {
        validaciones.putIfAbsent(p, texto);

        return this;
    }

    
    /**
     * Getter del atributo funcion.
     * 
     * @return Function
     */
    public Function<String, A> getFuncion() {
        return funcion;
    }

    
    /** 
     * Getter del Hasmap de validaciones.
     * 
     * @return Map
     */
    public Map<Predicate<A>, String> getValidaciones() {
        return validaciones;
    }

    
    /** 
     * Método que comprueba si el argumento que recibe cumple con todas las 
     * condiciones de las validaciones de este Field.
     * 
     * @param texto con el valor que comprobaremos si es válido o no.
     * @return boolean
     */
    public boolean comprobarValidaciones(String texto) {
        if (validaciones.size() == 0)
            return true;

        for (Map.Entry<Predicate<A>, String> entry : validaciones.entrySet()) {
            if (!entry.getKey().test(funcion.apply(texto))) {
                System.out.println("Invalid value: " + funcion.apply(texto) + "\n   " + entry.getValue() + "\n");
                return false;
            }
        }

        return true;
    }
}