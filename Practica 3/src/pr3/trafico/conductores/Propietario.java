package pr3.trafico.conductores;
import pr3.trafico.vehiculos.*;
import java.util.*;

/**
 * Clase abstracta de tipo propietario. Tiene los datos que coinciden con sus clases hijas.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public abstract class Propietario {
    /**
     * Lista de vehiculos con el mismo propietario.
     */
    private List<Vehiculo> vehiculos = new ArrayList<>();

    /**
     * Nombre del propietario.
     */
    private String nombre;

    /**
     * COnstructor de la clase propietario.
     * @param nombre Nombre del propietario.
     */
    public Propietario (String nombre) {
        setNombre(nombre);
    }

    /**
     * Getter del listado de vehiculos del propietario.
     *
     * @return List
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Metodo para anyadir uno o varios vehiculos al listado.
     *
     * @param vehiculos Vehiculos a introducir.
     */
    public void anyadirVehiculo(Vehiculo ... vehiculos) {
        this.vehiculos.addAll(Arrays.asList(vehiculos));
    }

    /**
     * Getter del nombre
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre.
     *
     * @param nombre Nuevo nombre del propietario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        String cadena = "";

        for (Vehiculo v: vehiculos) {
            cadena = cadena.concat(v.toString() + "\n");
        }

        return cadena;
    }
}
