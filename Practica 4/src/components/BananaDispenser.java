package components;

import vehiculos.Vehiculo;

/**
 * Clase BananaDispenser. Crea los datos necesarios para este componente.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class BananaDispenser extends Component {

    /**
     * Constructor de BananaDispenser.
     * 
     * @param v Vehiculo al que le pertenece el componente.
     */
    public BananaDispenser (Vehiculo v) {
        super("BananaDispenser", 4, v, false);
    }
}
