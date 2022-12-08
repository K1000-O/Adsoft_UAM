package components;

import vehiculos.IVehicle;

/**
 * Interfaz que obliga a que las clases que la contengan tengan los 
 * siguientes metodos.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public interface IComponent {
    /**
     * Metodo que devuelve si el componente esta dañado o no.
     * 
     * @return boolean
     */
    public boolean isDamaged();

    /**
     * Setter de isDamage
     * 
     * @param damage true si el componente esta dañado, false si no lo esta.
     */
    public void setDamaged(boolean damage);

    /**
     * Getter del nombre del componente.
     * 
     * @return String
     */
    public String getName();

    /**
     * Getter del coste de reparacion del componente.
     * 
     * @return int
     */
    public int costRepair();

    /**
     * Getter del vehiculo.
     * 
     * @return IVehicle
     */
    public IVehicle getVehicle();

    /**
     * Getter del atributo isCritical.
     * 
     * @return boolean
     */
    public boolean isCritical();

    /**
     * Metodo que repara el componente.
     */
    public void repair();
}