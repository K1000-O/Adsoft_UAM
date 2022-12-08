package powerUps;

import java.util.List;

import vehiculos.IVehicle;
import vehiculos.Vehiculo;

/**
 * Clase de tipo Swap que hereda los datos de Powerup.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Swap extends PowerUp {
    /**
     * Constructor de la clase Swap
     */
    public Swap() {
        super("Swap");
    }

    /**
     * Método heredado de Powerup, implementa la funcionalidad que realiza este powerup.
     * En concreto, el vehiculo que recibe este powerup, intercambia posiciones con el vehiculo que tiene directamente por delante.
     * 
     * @param vehiculos lista de todos los vehiculos
     * @param v vehiculo que ha recibido el powerup
     */
    @Override
    public void realizarAccion(List<Vehiculo> vehiculos, IVehicle v) {
        IVehicle vACambiar = null;
        double tamAux = 1*10^6;

        for (IVehicle vAux : vehiculos) {
            if (!vAux.equals(v)) {
                double dif = vAux.getActualPosition() - v.getActualPosition();
                if (dif > 0 && dif < tamAux) {
                    tamAux = dif;
                    vACambiar = vAux;
                } else if (dif == tamAux) {
                    vACambiar = Math.random() < 0.5 ? vACambiar : vAux;
                }
            }
        }

        if (vACambiar != null) {
            tamAux = v.getActualPosition();

            v.setActualPosition(vACambiar.getActualPosition());
            vACambiar.setActualPosition(tamAux);
        }
    }
 }
