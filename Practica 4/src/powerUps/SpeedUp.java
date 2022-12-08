package powerUps;

import java.util.List;

import vehiculos.IVehicle;
import vehiculos.Vehiculo;

/**
 * Clase de tipo SpeedUp que hereda los datos de Powerup.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class SpeedUp extends PowerUp{

    /**
     * Constructor de la clase SpeedUp
     */
    public SpeedUp() {
        super("SpeedUp");
    }

    /**
     * Método heredado de Powerup, implementa la funcionalidad que realiza este powerup.
     * En concreto, el vehiculo que recibe este powerup, se desplaza el doble de distancia en este turno.
     * 
     * @param vehiculos lista de todos los vehiculos
     * @param v vehiculo que ha recibido el powerup
     */
    @Override
    public void realizarAccion(List<Vehiculo> vehiculos, IVehicle v) {
        v.setActualPosition(v.getActualPosition() + v.getMaxSpeed());
    }
    
}
