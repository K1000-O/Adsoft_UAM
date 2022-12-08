package powerUps;

import java.util.List;

import vehiculos.*;

/**
 * Clase PowerUp que implementa la interfaz IPowerUp.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public abstract class PowerUp implements IPowerUp{
    /**
     * String con el nombre que recibe el powerup.
     */
    private String name;

    /**
     * Constructor de la clase PowerUp
     * 
     * @param name nombre del powerup
     */
    public PowerUp(String name) {
        this.name = name + "PowerUp";
    }

    /**
     * Método que asigna un powerup a un vehiculo
     * 
     * @param v vehiculo que recibe el powerup
     */
    public void applyPowerUp(IVehicle v) {
        ((Vehiculo)v).setPowerUp(this);
    }

    /**
     * Metodo abstracto que heredaran los powerups para implementar la funcionalidad de cada uno.
     *
     * @param vehiculos lista de todos los vehiculos
     * @param v vehiculo que ha recibido el powerup
     */
    public abstract void realizarAccion(List<Vehiculo> vehiculos, IVehicle v);

    /**
     * Metodo que devuelve el nombre del powerup
     * 
     * @return String
     */
    public String namePowerUp() {
        return name;
    }
}

