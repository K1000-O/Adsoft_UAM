package pr3.trafico.conductores;


/**
 * Clase Persona que extiende de propietario.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class Persona extends Propietario{
    /**
     * Edad de la persona.
     */
    private int edad = 0;

    /**
     * Carnet de la persona.
     */
    private Carnet carnet = null;

    /**
     * Constructor de persona.
     *
     * @param nombre Nombre de la persona.
     * @param edad Edad de la persona.
     */
    public Persona (String nombre, int edad) {
        super(nombre);
        this.edad = edad;
    }

    /**
     * Getter de edad.
     *
     * @return int
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter del carnet. Devuelve true si ha sido posible setear el carnet.
     * @param c Carnet a setear.
     * @return Boolean
     */
    public Boolean setCarnet(Carnet c) {
        for (TipoLicencia tL: c.getTiposLicencia()) {
            if (tL.getEdadMinima() > edad) {
                return false;
            }
        }

        this.carnet = c;

        return true;
    }

    /**
     * Getter del carnet.
     *
     * @return Carnet
     */
    public Carnet getCarnet() {
        return this.carnet;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return super.getNombre() + (super.getVehiculos().size() != 0 ? " propietario de:\n" + super.toString() : ".");
    }

}
