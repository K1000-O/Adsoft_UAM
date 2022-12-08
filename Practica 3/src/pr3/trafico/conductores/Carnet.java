package pr3.trafico.conductores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase carnet. Tiene todo lo necesario para poder tratar objetos de esta clase.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class Carnet {
    /**
     * Puntos del carnet. Inicialmente tiene 12.
     */
    private int puntos = 12;

    /**
     * Id del carnet. Se genera automaticamente y no se debe cambiar.
     */
    private final int id;

    /**
     * Atrbuto estatico con todos los carnets que existen.
     */
    private static int numCarnets = 0;

    /**
     * Lista de los tipo de licencia del carnet.
     */
    private List<TipoLicencia> tiposLicencia = new ArrayList<>();

    /**
     * Atributo para saber si el carnet ha sido suspendido o no. Inicialmente no lo esta.
     */
    private Boolean carnetSuspendido = false;

    /**
     * Constructor del carnet. En él se setea la id según los carnets existentes. El primer carnet tiene id = 0.
     *
     * @param tipoLicencia Tipos de licencia que componen el carnet.
     */
    public Carnet(TipoLicencia ... tipoLicencia){
        addLicencia(tipoLicencia);
        id = numCarnets;
        numCarnets++;
    }

    /**
     * Getter de los puntos del carnet.
     *
     * @return int
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Setter de los puntos del carnet.
     *
     * @param puntos Nuevos puntos del carnet.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Getter del id.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Getter de los tipos de licencia de un carnet.
     *
     * @return List
     */
    public List<TipoLicencia> getTiposLicencia() {
        return tiposLicencia;
    }

    /**
     * Metodo que anyade a la lista de tipos de licencia una o varias licencias.
     *
     * @param tL Tipos de licencias a anyadir.
     */
    public void addLicencia(TipoLicencia ... tL) {
        this.tiposLicencia.addAll(Arrays.asList(tL));
    }

    /**
     * Setter de carnet suspendido.
     *
     * @param suspendido Parametro que establece si esta o no suspendido un carnet.
     */
    public void setCarnetSuspendido(Boolean suspendido) {
        this.carnetSuspendido = suspendido;
    }

    /**
     * Getter de carnet suspendido.
     * @return Boolean
     */
    public Boolean getCarnetSuspendido() {
        return carnetSuspendido;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Carnet [id = " + getId() + ", licencias = " + this.tiposLicencia + ", puntos = " + getPuntos() + "].";
    }
}
