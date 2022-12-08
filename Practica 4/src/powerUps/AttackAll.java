package powerUps;

import java.util.List;

import components.IComponent;
import vehiculos.IVehicle;
import vehiculos.Vehiculo;

/**
 * Clase de tipo AttackAll que hereda los datos de Powerup.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class AttackAll extends PowerUp{
    /**
     * Constructor de la clase AttackAll
     */
    public AttackAll() {
        super("AttackAll");
    }

    /**
     * Método heredado de Powerup, implementa la funcionalidad que realiza este powerup.
     * En concreto, el vehiculo que recibe este powerup tiene un 50% de probabilidades de atacar a un componente aleatorio de un vehiculo aleatorio.
     * 
     * @param vehiculos lista de todos los vehiculos
     * @param v vehiculo que ha recibido el powerup
     */
    @Override
    public void realizarAccion(List<Vehiculo> vehiculos, IVehicle v) {
        for (Vehiculo vehiculoAAtacar : vehiculos) {
            if (!vehiculoAAtacar.equals(v) && Math.random() >= 0.5) {
                IComponent c1 = vehiculoAAtacar.getComponents().get((int)Math.floor(Math.random()*vehiculoAAtacar.getComponents().size()));
                c1.setDamaged(true);
                if (c1.isCritical()) c1.getVehicle().setCanMove(false);
            }
        }
        
    }    
}
