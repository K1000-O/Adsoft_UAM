package vehiculos;

import java.util.List;

import components.*;

/**
 * Interfaz para los vehiculos de la carrera.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public interface IVehicle {
    /**
     * Posicion actual del vehiculo.
     * 
     * @return double
     */
    public double getActualPosition();

    /**
     * Setter de la posicion actual del vehiculo.
     * 
     * @param newPosition nueva posicion del vehiculo.
     */
    public void setActualPosition(double newPosition);

    /**
     * Metodo que comprueba si el vehiculo se puede mover.
     * 
     * @return boolean
     */
    public boolean canMove();

    /**
     * Setter si se puede o no mover el vehiculo.
     * 
     * @param newMovement true si se puede mover, false si no puede.
     */
    public void setCanMove(boolean newMovement);

    /**
     * Getter de la velocidad máxima del vehiculo.
     * 
     * @return double
     */
    public double getMaxSpeed();

    /**
     * Getter del nombre del vehiculo.
     * 
     * @return String
     */
    public String getName();

    /**
     * Metodo que anyade un componente al listado.
     * 
     * @param c Componente a anyadir.
     * @throws InvalidComponentException Excepcion en caso de que no se pueda anyadir.
     */
    public void addComponent(IComponent c) throws InvalidComponentException;

    /**
     * Getter del listado de componentes del vehiculo.
     * 
     * @return List
     */
    public List<IComponent> getComponents();
}

