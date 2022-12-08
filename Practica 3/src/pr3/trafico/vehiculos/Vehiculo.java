package pr3.trafico.vehiculos;

import pr3.trafico.conductores.Persona;
import pr3.trafico.conductores.Propietario;
import pr3.trafico.conductores.Sociedad;
import pr3.trafico.itv.Itv;

import java.time.LocalDate;
import java.util.*;

/**
 * Clase abstracta para la creacion de diferentes vehiculos que heredan de �sta.
 *
 * @author Alejandro Raul Hurtado alejandror.hurtado@estudiante.uam.es
 * @author Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public abstract class Vehiculo {
	/**
	 * Nombre del modelo del vehiculo
	 */
	private String modelo;
	/**
	 * Matricula del vehiculo
	 */
	private String matricula;
	/**
	 * A�o de compra del vehiculo
	 */
	private int anyoCompra;

	/**
	 * Nombre del propietario del vehiculo.
	 */
	private Propietario propietario = null;

	/**
	 * Nombre del conductor del vehiculo.
	 */
	private Persona conductor = null;

	/**
	 * Lista de itvs pasadas por un vehiculo.
	 */
	protected List<Itv> itvs = new ArrayList<>();

	/**
	 * Constructor del vehiculo sin matricula.
	 * @param mod modelo
	 * @param a a�o
	 */
	public Vehiculo(String mod, int a) {
		this.modelo = mod;
		this.anyoCompra = a;
	}

	/**
	 * Constructor del vehiculo con matricula pero sin propietario.
	 * @param mod modelo
	 * @param a a�o
	 * @param matricula matricula
	 */
	public Vehiculo(String mod, int a, String matricula) {
		this(mod, a);
		this.matricula = matricula;
	}

	/**
	 * Constructor del vehiculo con matricula y propietario.
	 * @param mod modelo
	 * @param a a�o
	 * @param matricula matricula
	 * @param propietario propietario
	 */
	public Vehiculo(String mod, int a, String matricula, Propietario propietario) {
		this(mod, a, matricula);
		this.setPropietario(propietario);
	}

	/**
	 * Metodo abstracto numero de ruedas del vehiculo
	 * @return int
	 */
	public abstract int numeroRuedas();

	/**
	 * Metodo que anyade una itv al listado de itvs pasadas.
	 *
	 * @param itv itv realizada por el vehiculo.
	 */
	public void addItv (Itv itv) {
		itv.setVehiculo(this);
		this.itvs.add(itv);
	}

	/**
	 * Metodo que setea el propietario del vehiculo. Hay que comprobar si es una sociedad o no. Si lo es, el conductor
	 * es el responsable.
	 *
	 * @param propietario propietario del vehiculo.
	 */
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;

		if (propietario instanceof Sociedad) {
			this.setConductor(((Sociedad) propietario).getResponsable());
		} else {
			this.setConductor((Persona) propietario);
		}

		propietario.anyadirVehiculo(this);
	}

	/**
	 * Setter del conductor del vehiculo.
	 *
	 * @param conductor conductor del vehiculo.
	 * @return Boolean
	 */
	public Boolean setConductor(Persona conductor) {
		this.conductor = conductor;

		return true;
	}

	/**
	 * Metodo que devuelve el indice de contaminacion dependiendo del a�o de compra.
	 * @return IndiceContaminacion
	 */
	public IndiceContaminacion getIndiceContaminacion() {
		return IndiceContaminacion.getIndiceContaminacion(this.anyoCompra);
	}

	/**
	 * Getter de la matricula del vehiculo.
	 *
	 * @return String
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Getter del conductor del vehiculo.
	 *
	 * @return Persona
	 */
	public Persona getConductor() {
		return conductor;
	}

	/**
	 * Getter del anyo de compra del vehiculo.
	 *
	 * @return int
	 */
	public int getAnyoCompra() {
		return anyoCompra;
	}

	/**
	 * Metodo abtracto que devuelve la fecha de la siguiente ITV a realizar.
	 * @return LocalDate
	 */
	public abstract LocalDate nextItv();

	/**
	 * toString sobreescrito para imprimir algo definido.
	 * @return String
	 */
	@Override
	public String toString() {
		return "modelo "+this.modelo+(matricula != null ? ", matricula: " + this.matricula : "")+", fecha compra "+
				this.anyoCompra+", con "+this.numeroRuedas()+" ruedas, indice:"+this.getIndiceContaminacion() +
				(this.propietario != null ? " propietario: " + this.propietario.getNombre() + " conductor: " + (this.conductor != null ? this.conductor.getNombre() : "no registrado.") : "") + "\n";
	}
}
