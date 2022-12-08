package components;

import vehiculos.Vehiculo;

/**
 * Clase Engine. Crea los datos necesarios para este componente.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Engine extends Component {
    /**
     * Constructor de Engine.
     * 
     * @param v Vehiculo al que le pertenece el componente.
     */
    public Engine(Vehiculo v) {
        super("Engine", 3, v, true);
    }
}
