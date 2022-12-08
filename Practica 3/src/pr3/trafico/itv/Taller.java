package pr3.trafico.itv;

import pr3.trafico.vehiculos.Vehiculo;

import java.util.*;

/**
 * Clase Taller para el guardado de datos de los objetos de este tipo.
 *
 * @author Alejandro Raul Hurtado alejandror.hurtado@estudiante.uam.es
 * @author Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class Taller {
    /**
     * Nombre del taller.
     */
    private String nombre = null;

    /**
     * Direccion del taller.
     */
    private String direccion = null;

    /**
     * Provincia del taller.
     */
    private String provincia = null;

    /**
     * ITV's pasadas en el taller.
     */
    private List<Itv> itv = new ArrayList<>();

    /**
     * Constructor del taller.
     *
     * @param nombre Nombre del taller.
     * @param direccion Direccion del taller.
     * @param provincia Provincia del taller.
     */
    public Taller(String nombre, String direccion, String provincia) {
        this.nombre = nombre; this.direccion = direccion; this.provincia = provincia;
    }

    /**
     * Getter del listado de ITV's pasadas en el taller.
     *
     * @return List
     */
    public List<Itv> getItv() {
        return itv;
    }

    /**
     * Metodo para anyadir 1 o mas ITV's al listado.
     *
     * @param itv ITV's realizadas.
     */
    public void addItv(Itv ... itv) {
        this.itv.addAll(Arrays.asList(itv));
    }

    /**
     * Metodo que devuelve los vehiculos que han pasado una itv en el taller.
     *
     * @return Set
     */
    public Set<Vehiculo> getVehiculos() {
        Set<Vehiculo> vehiculos = new HashSet<>();
        itv.forEach(x -> vehiculos.add(x.getVehiculo()));

        return  vehiculos;
    }

    /**
     * @return String
     */
    @Override public String toString() {
        return nombre + " - " + direccion + " - " + provincia;
    }
}
