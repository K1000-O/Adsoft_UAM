package vehiculos;

/**
 * Clase de tipo Truck que hereda los datos de vehiculo.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Truck extends Vehiculo {

    /**
     * Constructor del vehiculo de tipo Truck.
     * 
     * @param maxSpeed Velocidad maxima del vehiculo.
     */
    public Truck (double maxSpeed) {
        super(maxSpeed);
        super.name = "Truck(" + super.getId() + ")";
    }

    /**
     * Metodo que actualiza la posicion del camión.
     */
    @Override
    public void actualizarPosicion() {
        if (getComponents().stream().anyMatch(x -> x.isCritical() && x.isDamaged()))
            return;

        // Calculo de la probabilidad.
        int probabilidad = (int)(Math.random()*10+1);
        
        super.setActualPosition(probabilidad == 1 ? getActualPosition() + 0.8*super.getMaxSpeed() 
            : getActualPosition() + super.getMaxSpeed());
    }
}
