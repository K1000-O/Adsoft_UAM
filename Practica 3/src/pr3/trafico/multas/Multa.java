package pr3.trafico.multas;

/**
 * Clase para generar objetos de tipo multa.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class Multa {
    /**
     * Matricula del vehiculo a multar.
     */
    private String matricula = null;

    /**
     * Descripcion de la multa.
     */
    private String descripcion = null;

    /**
     * Numero de puntos a sustraer.
     */
    private int puntos = -1;

    /**
     * COnstructor de la multa.
     *
     * @param matricula matricula del vehiculo.
     * @param descripcion descripcion de la multa.
     * @param puntos puntos a sustraer.
     */
    public Multa(String matricula, String descripcion, int puntos) {
        this.matricula = matricula; this.descripcion = descripcion; this.puntos = puntos;
    }

    /**
     * Getter de la matricula.
     *
     * @return String
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Getter de la descripcion.
     *
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Getter de los puntos de la multa.
     *
     * @return int
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Setter de los puntos.
     *
     * @param puntos nuevos puntos.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Metodo toString que devuelve la info de la multa.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Multa [matricula = " + this.getMatricula() + ", tipoMulta = " + this.getDescripcion() + ", puntos = " +
            this.getPuntos() + "]";
    }
}
