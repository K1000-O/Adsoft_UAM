package pr3.trafico.vehiculos;

/**
 * Enumeraci�n que define el tipo de contaminaci�n.
 *
 * @author Alejandro Raul Hurtado alejandror.hurtado@estudiante.uam.es
 * @author Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public enum IndiceContaminacion {
	/**
	 * Tipo de �ndice A.
	 */
	A,
	/**
	 * Tipo de �ndice B.
	 */
	B,
	/**
	 * Tipo de �ndice C.
	 */
	C;

	/**
	 * A�o A.
	 */
	private static final int FECHAA = 2018;
	/**
	 * A�o B.
	 */
	private static final int FECHAB = 2010;

	/**
	 * M�todo que devuelve el �ndice de contaminaci�n que hay dependiendo del a�o.
	 * @param anyo a�o de compra.
	 * @return A si anyo >= FECHAA, B si anyo >= FECHAB else C
	 */
	public static IndiceContaminacion getIndiceContaminacion(int anyo) {
		if (anyo >= FECHAA) return A;
		if (anyo >= FECHAB) return B;
		return C;
	}
}
