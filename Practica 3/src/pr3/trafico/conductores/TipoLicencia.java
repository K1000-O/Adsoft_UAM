package pr3.trafico.conductores;

/**
 * Enumeracion de los tipos de licencia.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public enum TipoLicencia {
    /**
     * Tipo licencia A
     */
    A,
    /**
     * Tipo licencia B
     */
    B,
    /**
     * Tipo licencia C1
     */
    C1;

    /**
     * Edad minima de las licencias A y B.
     */
    private final int edadMinimaAyB = 18;

    /**
     * Edad minima de la licencia C1.
     */
    private final int edadMinimaC1 = 23;

    /**
     * Getter de la edad minima de cada licencia.
     *
     * @return int
     */
    public int getEdadMinima() {
        return this == TipoLicencia.C1 ? edadMinimaC1 : edadMinimaAyB;
    }
}
