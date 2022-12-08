package vehiculos;

import java.util.ArrayList;
import java.util.List;

import components.*;
import powerUps.IPowerUp;

/**
 * Clase vehiculo que implementa la interfaz IVEhicle.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public abstract class Vehiculo implements IVehicle{
    /**
     * Nombre del vehiculo. Siempre tipoVehiculo(id).
     */
    protected String name;

    /**
     * Id del vehiculo.
     */
    private int id;

    /**
     * Numero de vehiculo que hay actualmente.
     */
    private static int numCars = 0;

    /**
     * Velocidad máxima del vehiculo.
     */
    private double maxSpeed = 0.0;

    /**
     * Posición actual del vehiculo.
     */
    private double actualPosition = 0.0;

    /**
     * Atributo para saber si podemos o no mover el vehiculo.
     */
    private boolean canMove = true;

    /**
     * Lista de componentes que tiene el vehiculo.
     */
    private List<IComponent> componentes = new ArrayList<IComponent>();

    /**
     * Powerup que ha recibido el vehiculo.
     */
    private IPowerUp powerUp;

    /**
     * Constructor de vehiculo.
     * 
     * @param maxSpeed velocidad maxima del vehiculo.
     */
    public Vehiculo(double maxSpeed) {
        Vehiculo.numCars += 1; // Modificamos el numero de coches.
        id = numCars;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Método que devuelve la posición actual.
     * 
     * @return double
     */
    @Override
    public double getActualPosition() {
        return actualPosition;
    }

    /**
     * Método que setea la posicion actual.
     * 
     * @param newPosition Nueva posicion del vehiculo.
     */
    @Override
    public void setActualPosition(double newPosition) {
        actualPosition = newPosition;
    }

    /**
     * Metodo que actualiza la posicion del vehiculo si no tiene ningun componente critico dañado.
     */
    public void actualizarPosicion() {
        if (!canMove())
            return;

        actualPosition += maxSpeed;
    }

    /**
     * Método que nos dice si el vehiculo se puede mover o no.
     * 
     * @return boolean
     */
    @Override
    public boolean canMove() {
        return canMove;
    }

    /**
     * Metodo que setea si un coche se puede mover o no.
     */
    @Override
    public void setCanMove(boolean newMovement) {
        canMove = newMovement;
    }

    /** 
     * Gettter de la velocidad maxima del vehiculo.
     * 
     * @return double
     */
    @Override
    public double getMaxSpeed() {
        return maxSpeed;
    }
    
    /** 
     * Getter del nombre del vehiculo.
     * 
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }
    
    /** 
     * Getter de la id del vehiculo.
     * 
     * @return int
     */
    public int getId() {
        return id;
    }

    /** 
     * Setter de la maxima velocidad del vehiuclo.
     * 
     * @param maxSpeed Velocidad maxima a la que puede llegar el vehiculo.
     */
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
 
    /** 
     * Metodo que anyade componentes a la lista de éstos.
     * 
     * @param c Componente a anyadir.
     * @throws InvalidComponentException Excepcion en caso de que no sea un componente válido.
     */
    @Override
    public void addComponent(IComponent c) throws InvalidComponentException {
        componentes.add(c);
    }
  
    /** 
     * Getter de la lista de componentes.
     * 
     * @return List
     */
    @Override
    public List<IComponent> getComponents() {
        return componentes;
    }

    /**
     * Setter del powerup que ha recibido el vehículo.
     * 
     * @param powerUp powerup que recibe de argumento.
     */
    public void setPowerUp(IPowerUp powerUp) {
        this.powerUp = powerUp;
    }

    /**
     * Getter del powerup del vehículo.
     * 
     * @return powerup
     */
    public IPowerUp getPowerUp() {
        return powerUp;
    }
    
    /**
     * Método que devuelve unalista de los componentes del vehiculo y su estado.
     * 
     * @return String
     */
    public String imprimirComponentes() {
        String texto = "";

        for (IComponent c : getComponents())
            texto += "-> " + c;

        return texto;
    }

    /** 
     * Metodo toString del vehiculo.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return name + ". Speed " + maxSpeed + ". Actual position " + actualPosition + ".\n" + (getComponents().size() > 0 ? imprimirComponentes() : "");
    }
}
