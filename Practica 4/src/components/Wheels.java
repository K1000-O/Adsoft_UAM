package components;

import vehiculos.Vehiculo;

/**
 * Clase Wheels. Crea los datos necesarios para este componente.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Wheels extends Component {

    /**
     * Constructor de Wheels.
     * 
     * @param v Vehiculo al que le pertenece el componente.
     */
    public Wheels(Vehiculo v) {
        super("Wheels", 3, v, true);
    }
}
