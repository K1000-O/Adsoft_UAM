package pr3.trafico.vehiculos;

import pr3.trafico.conductores.Persona;
import pr3.trafico.conductores.Propietario;
import pr3.trafico.conductores.TipoLicencia;
import pr3.trafico.itv.Itv;

import java.time.LocalDate;

/**
 * Clase heredera de vehiculo para la creacion de objetos de tipo coche.
 *
 * @author Alejandro Hurtado alejandror.hurtado@estudiante.uam.es
 * @author Camilo Jene camilo.jenec@estudiante.uam.es
 */
public class Coche extends Vehiculo {

	/**
	 * Booleano que indica si el Coche tiene motor diesel o no.
	 */
	private boolean diesel;

	/**
	 * Constructor de la clase Coche sin matricula para el Ejercicio1.
	 *
	 * @param mod modelo
	 * @param a a�o
	 * @param diesel diesel
	 */
	public Coche(String mod, int a, boolean diesel) {
		super(mod, a);
		this.diesel = diesel;
	}

	/**
	 * Constructor de la clase Coche con matricula pero sin conductor.
	 *
	 * @param mod modelo
	 * @param a a�o
	 * @param matricula matricula
	 * @param diesel diesel
	 */
	public Coche(String mod, int a, String matricula, boolean diesel) {
		super(mod, a, matricula);
		this.diesel = diesel;
	}

	/**
	 * Constructor de la clase Coche con matricula y conductor.
	 *
	 * @param mod modelo
	 * @param a a�o
	 * @param matricula matricula
	 * @param diesel diesel
	 * @param conductor conductor
	 */
	public Coche(String mod, int a, String matricula, boolean diesel, Propietario conductor) {
		super(mod, a, matricula, conductor);
		this.diesel = diesel;
	}

	/**
	 * M�todo que devuelve el numero de ruedas que tiene un coche.
	 *
	 * @return 4
	 */
	@Override public int numeroRuedas() { return 4;	}

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
				if (tL == TipoLicencia.B) {
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
	 * toString que devuelve la informacion del Coche.
	 *
	 * @return String
	 */
	@Override public String toString() {
		return "Coche "+(this.diesel ? "diesel" : "gasolina") + ", "+ super.toString();
	}

	/**
	 * Metodo que devuelve el Indice de contaminacion del Coche llamando a la funcion del padre.
	 *
	 * @return IndiceContaminacion
	 */
	@Override
	public IndiceContaminacion getIndiceContaminacion() {
		if (this.diesel) return IndiceContaminacion.C;
		return super.getIndiceContaminacion();
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
			return itvRealizada == anyoActual ? itv.getFecha().plusYears(2) :
					anyoActual - itvRealizada > 2 ? fechaActual : fechaActual.plusYears((anyoActual - itvRealizada) % 2);
		}
	}

	/**
	 * Metodo que devuelve un booleano que indica si el coche tiene motor diesel o no.
	 *
	 * @return Boolean
	 */
	public boolean getDiesel() { return this.diesel; }

	/**
	 * Metodo que permite alterar el valor del atributo diesel del Coche.
	 *
	 * @param b Boolean
	 */
	public void setDiesel(boolean b) { this.diesel = b; }
}
