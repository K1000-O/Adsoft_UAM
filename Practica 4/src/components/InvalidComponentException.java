package components;

/**
 * Excepcion creada para cualquier error de componentes.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class InvalidComponentException extends Exception {

    /**
     *  Serial version de la excepcion.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la excepcion.
     * 
     * @param mensaje mensaje a imprimir en caso de error.
     */
    public InvalidComponentException(String mensaje) {
        super(mensaje);
    }
}
