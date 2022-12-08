package pr3.trafico.vehiculos;

import pr3.trafico.conductores.Persona;
import pr3.trafico.conductores.Propietario;
import pr3.trafico.conductores.TipoLicencia;
import pr3.trafico.itv.Itv;

import java.time.LocalDate;
import java.util.Date;

/**
 * Clase con los datos necesarios para las Motocicletas.
 *
 * @author Alejandro Raul Hurtado alejandror.hurtado@estudiante.uam.es
 * @author Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class Motocicleta extends Vehiculo{
    /**
     * Variable para saber si la moto es electrica.
     */
    private final Boolean esElectrica;

    /**
     * Constructor de Motocicleta sin conductor.
     * @param mod modelo de la moto.
     * @param a a�o de compra de la moto.
     * @param matricula matr�cula de la moto.
     * @param esElectrica si es electrica o no.
     */
    public Motocicleta(String mod, int a, String matricula, Boolean esElectrica) {
        super(mod, a, matricula);
        this.esElectrica = esElectrica;
    }

    /**
     * Constructor de Motocicleta con conductor.
     * @param mod modelo de la moto.
     * @param a a�o de compra de la moto.
     * @param matricula matr�cula de la moto.
     * @param esElectrica si es electrica o no.
     * @param conductor conductor
     */
    public Motocicleta(String mod, int a, String matricula, Boolean esElectrica, Propietario conductor) {
        super(mod, a, matricula, conductor);
        this.esElectrica = esElectrica;
    }

    /**
     * Numero de ruedas de la moto.
     * @return int
     */
    @Override
    public int numeroRuedas() {
        return 2;
    }

    /**
     * Devolver si la moto es electrica o no.
     * @return True si es electrica, False si no lo es.
     */
    public Boolean getEsElectrica() {
        return esElectrica;
    }

    /**
     * M�todo que devuelve el �ndice de contaminaci�n.
     * @return A si es electrica else si no lo es.
     */
    @Override
    public IndiceContaminacion getIndiceContaminacion() {
        if (esElectrica) return IndiceContaminacion.A;
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
                if (tL == TipoLicencia.A) {
                    return super.setConductor(conductor);
                }
            }
        } else {
            if (conductor.getEdad() >= 18) {
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
        int itvRealizada = itv.getFecha().getYear();

        if (diferenciaAnyo <= 4) {
            return fechaActual.plusYears(4 - diferenciaAnyo);
        } else if (diferenciaAnyo > 10) {
            return itvRealizada == anyoActual ? itv.getFecha().plusYears(1) : fechaActual;
        } else {
            return itvRealizada == anyoActual ? itv.getFecha().plusYears(2) : anyoActual - itvRealizada > 2 ? fechaActual : fechaActual.plusYears((anyoActual - itvRealizada) % 2);
        }
    }

    /**
     * toString que imprime algo determinado.
     * @return String
     */
    @Override
    public String toString() {
        return "Motocicleta" + (getEsElectrica() ? " electrica, " : ", ") + super.toString();
    }
}
