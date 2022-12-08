package components;

import vehiculos.Vehiculo;

/**
 * Clase Window. Crea los datos necesarios para este componente.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Window extends Component {
    /**
     * Constructor de Window.
     * 
     * @param v Vehiculo al que le pertenece el componente.
     */
    public Window (Vehiculo v) {
        super("Window", 2, v, false);
    }
}
