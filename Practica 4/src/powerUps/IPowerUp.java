package powerUps;

import vehiculos.IVehicle;

/**
 * Interfaz para los powerups que recibirán los vehículos.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public interface IPowerUp {

    /**
     * Método que asigna un powerup a un vehiculo
     * 
     * @param v vehiculo que recibe el powerup
     */
    public void applyPowerUp(IVehicle v);
   
    /**
     * Metodo que devuelve el nombre del powerup
     * 
     * @return String
     */
    public String namePowerUp();    
}
