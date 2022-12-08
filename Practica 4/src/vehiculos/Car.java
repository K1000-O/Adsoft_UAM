package vehiculos;

/**
 * Clase de tipo Car que hereda los datos de vehiculo.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Car extends Vehiculo {

    /**
     * Constructor del vehiculo de tipo Car.
     * 
     * @param maxSpeed Velocidad maxima del vehiculo.
     */
    public Car (double maxSpeed) {
        super(maxSpeed);
        super.name = "Car(" + super.getId() + ")";
    }

    /**
     * Metodo que actualiza la posicion del Coche.
     */
    @Override
    public void actualizarPosicion() {
        if (getComponents().stream().anyMatch(x -> x.isCritical() && x.isDamaged()))
            return;
        // Calculo de la probabilidad.
        int probabilidad = (int)(Math.random()*10+1);
        
        super.setActualPosition(probabilidad == 1 ? getActualPosition() + 0.9*super.getMaxSpeed() 
            : getActualPosition() + super.getMaxSpeed());
        
    }
}