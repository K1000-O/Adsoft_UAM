package pr3.trafico.vehiculos;

import pr3.trafico.conductores.Persona;
import pr3.trafico.conductores.Propietario;
import pr3.trafico.conductores.TipoLicencia;
import pr3.trafico.itv.Itv;

import java.time.LocalDate;

/**
 * Clase heredera de vehiculo para la creacion de objetos de tipo Camion.
 *
 * @author Alejandro Hurtado alejandror.hurtado@estudiante.uam.es
 * @author Camilo Jene camilo.jenec@estudiante.uam.es
 */
public class Camion extends Vehiculo{
    /**
     * Numero de ejes que tiene el Camion.
     */
    private int numEjes = 0;

    /**
     * Constructor de la clase Camion sin conductor.
     *
     * @param mod modelo
     * @param a a�o
     * @param matricula matricula
     * @param numEjes numero de ejes
     */
    public Camion(String mod, int a, String matricula, int numEjes) {
        super(mod, a, matricula);
        this.numEjes = numEjes;
    }

    /**
     * Constructor de la clase Camion con conductor.
     *
     * @param mod modelo
     * @param a a�o
     * @param matricula matricula
     * @param numEjes numero de ejes
     * @param conductor conductor
     */
    public Camion(String mod, int a, String matricula, int numEjes, Propietario conductor) {
        super(mod, a, matricula, conductor);
        this.numEjes = numEjes;
    }

    /**
     * Metodo que devuelve el numero de ejes del Camion.
     *
     * @return numEjes
     */
    public int getNumEjes() {
        return numEjes;
    }

    /**
     * Metodo para alterar el valor del atributo numEjes.
     *
     * @param numEjes numero Ejes
     */
    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    /**
     * Metodo que devuelve el numero de ruedas de un Camion.
     *
     * @return int
     */
    @Override
    public int numeroRuedas() {
        return 2 * numEjes;
    }

    /**
     * Metodo que devuelve el Indice de Contaminacion del Camion.
     *
     * @return IndiceContaminacion
     */
    @Override
    public IndiceContaminacion getIndiceContaminacion() {
        if (numEjes > 2) return IndiceContaminacion.C;
        else return super.getIndiceContaminacion();
    }

    /**
     *	Setter del conductor del vehiculo, según la licencia o la edad si no tiene la primera.
     *
     * @param conductor conductor del coche.
     * @return Boolean
     */
    @Override
    public Boolean setConductor(Persona conductor) {
        if (conductor.getCarnet() != null) {
            for (TipoLicencia tL : conductor.getCarnet().getTiposLicencia()) {
                if (tL == TipoLicencia.C1) {
                    return super.setConductor(conductor);
                }
            }
        } else {
            if (conductor.getEdad() >= 24) {
                return super.setConductor(conductor);
            }
        }

        return false;
    }

    /**
     * Metodo que devuelve la fecha de la siguiente itv a pasar.
     *
     * @return LocalDate
     */
    @Override
    public LocalDate nextItv() {
        if (super.itvs.isEmpty()) {
            return LocalDate.now();
        }

        Itv itv = super.itvs.get(itvs.size() - 1);
        LocalDate fechaActual = LocalDate.now();
        int anyoActual = fechaActual.getYear();
        int diferenciaAnyo = anyoActual - super.getAnyoCompra();
        int anyoItvRealizada = itv.getFecha().getYear();
        int diferenciaMes = fechaActual.getMonth().getValue() - itv.getFecha().getMonth().getValue();


        if (diferenciaAnyo < 2) {
            return fechaActual.plusYears(2 - diferenciaAnyo);
        } else if (diferenciaAnyo > 6 && diferenciaAnyo <= 10) {
            return anyoItvRealizada == anyoActual ? itv.getFecha().plusYears(1) : anyoActual - anyoItvRealizada > 1 ? fechaActual: itv.getFecha().plusYears(1);
        } else if (diferenciaAnyo > 10) {
            return itv.getFecha().getMonth() == fechaActual.getMonth() ? fechaActual.plusMonths(6) : diferenciaMes > 6 ? fechaActual : itv.getFecha().plusMonths(6);
        } else {
            return anyoItvRealizada == anyoActual ? itv.getFecha().plusYears(2) : fechaActual.plusYears((anyoActual - anyoItvRealizada) % 2);
        }
    }

    /**
     * toString que imprime la informacion del Camion.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Camion de " + numEjes + " ejes, " + super.toString();

    }
}