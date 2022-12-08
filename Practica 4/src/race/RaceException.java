package race;

/**
 * Excepcion creada para cualquier error de carrea.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class RaceException extends Exception {

    /**
     *  Serial version de la excepcion.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la excepcion.
     * 
     * @param mensaje Mensaje de error en caso de excepcion.
     */
    public RaceException(String mensaje) {
        super(mensaje);
    }
}
