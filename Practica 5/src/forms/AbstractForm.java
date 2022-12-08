package forms;

import java.io.IOException;
import java.util.Map;

/**
 * Clase AbstractForm. En la que crearemos la seguridad de los forms para pedir un acceso por contrasenya.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public abstract class AbstractForm {

    /**
     * Metodo que devuelve el form.
     * 
     * @return Map
     * @throws IOException Excepcion en caso de error en I/O.
     */
    public abstract Map<String, ?> exec() throws IOException;
}
