package pr3.trafico.itv;

import pr3.trafico.vehiculos.Vehiculo;

import java.time.LocalDate;

/**
 * Clase ITV.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class Itv {
    /**
     * Fecha de la itv.
     */
    private LocalDate fecha;

    /**
     * Taller en el que se ha realizado la ITV.
     */
    private Taller tallerRealizacion;

    /**
     * Comentarios de la ITV.
     */
    private String comentario;

    /**
     * Vehiculo que ha pasado esta ITV.
     */
    private Vehiculo vehiculo = null;

    /**
     * Constructor de la clase ITV.
     *
     * @param fecha Fecha en la que se ha pasado la ITV.
     * @param taller Taller en el que se ha realizado la ITV.
     * @param comentario Comentarios de la ITV.
     */
    public Itv(LocalDate fecha, Taller taller, String comentario) {
        this.fecha = fecha; this.comentario = comentario;
        this.tallerRealizacion = taller; this.tallerRealizacion.addItv(this);
    }

    /**
     * Getter de la fecha.
     *
     * @return LocalDate
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Getter del taller en el que se ha realizado la ITV.
     *
     * @return Taller
     */
    public Taller getTallerRealizacion() {
        return tallerRealizacion;
    }

    /**
     * Getter de los comentarios.
     *
     * @return String
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Getter del vehiculo.
     *
     * @return Vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Setter del vehiculo que ha pasado esta ITV.
     *
     * @param vehiculo vehiculo que ha pasado la ITV.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "ITV pasada en el taller " + tallerRealizacion + " el día: " + fecha + ".\nComentarios: " + comentario;
    }
}
