package pr3.trafico.conductores;

/**
 * Clase Sociedad que hereda los datos de Propietario.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class Sociedad extends Propietario {
    /**
     * Responsable de la sociedad.
     */
    private Persona responsable = null;

    /**
     * Constructor de la clase Sociedad.
     *
     * @param nombre Nombre de la sociedad.
     * @param responsable Responsable de la sociedad.
     */
    public Sociedad(String nombre, Persona responsable) {
        super(nombre);
        this.responsable = responsable;
    }

    /**
     * Getter del responsable.
     *
     * @return Persona
     */
    public Persona getResponsable() {
        return responsable;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return super.getNombre() + " (responsable: " + this.responsable.getNombre() + ")" +
                (super.getVehiculos().size() != 0 ? " propietario de:\n" + super.toString() : ".");
    }
}
