package components;

import vehiculos.*;

/**
 * Clase componente que implementa la interfaz IComponent.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public abstract class Component implements IComponent{
    /**
     * Atributo que muestra si el componente esta dañado.
     */
    private boolean isDamaged;

    /**
     * Nombre del componente.
     */
    private String name;

    /**
     * Coste de reparacion del componente.
     */
    private int costRepair;

    /**
     * Atributo que indica si el componente es critico o no.
     */
    private boolean isCritical;

    /**
     * Fase de reparacion en la que se encuentra el vehiculo.
     */
    private int faseReparacion = 0;

    /**
     * Vehiculo al que le pertenece el componente.
     */
    private Vehiculo vehiculo;

    /**
     * Constructor de la clase Component.
     * 
     * @param name Nombre del componente.
     * @param costRepair Coste de reparacion del componente.
     * @param vehiculo Vehiculo al que pertenece el componente.
     * @param isCritical Indica si el componente es critico o no.
     */
    public Component(String name, int costRepair, Vehiculo vehiculo, boolean isCritical) {
        this.name = name;
        this.costRepair = costRepair;
        this.isCritical = isCritical;
        this.isDamaged = false;
        this.vehiculo = vehiculo;
    }

    
    /** 
     * Setter del vehiculo.
     * 
     * @param vehiculo Vehiculo al que le pertenece el componente.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /** 
     * Getter de isDamaged.
     * 
     * @return boolean
     */
    @Override
    public boolean isDamaged() {
        return isDamaged;
    }

    
    /** 
     * Setter de isDamaged;
     * 
     * @param damage true si esta dañado, false si no lo está.
     */
    @Override
    public void setDamaged(boolean damage) {
        this.isDamaged = damage;
    }

    
    /** 
     * Getter del nombre del componente.
     * 
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    
    /** 
     * Getter del coste de reparacion.
     * 
     * @return int
     */
    @Override
    public int costRepair() {
        return costRepair;
    }

    
    /** 
     * Getter del vehiculo.
     * 
     * @return IVehicle
     */
    @Override
    public IVehicle getVehicle() {
        return vehiculo;
    }

    
    /** 
     * Getter si es critico el componente.
     * 
     * @return boolean
     */
    @Override
    public boolean isCritical() {
        return isCritical;
    }

    /**
     * Metodo reparacion. Si no esta dañado return, sino --> faseReparacion += 1.
     */
    @Override
    public void repair() {
        if (!isDamaged) return;

        faseReparacion++;

        if (faseReparacion == costRepair) {
            if (isCritical) vehiculo.setCanMove(true);
            setDamaged(false);
            faseReparacion = 0;
        }   
    }

    
    /** 
     * Getter de la fase de reparacion en la que se encuentra.
     * 
     * @return int
     */
    public int getFaseReparacion() {
        return faseReparacion;
    }
    
    
    /** 
     * Imprime los datos del componente.
     * 
     * @return String
     */
    public String toString() {
        return name + ". Is damaged: " + isDamaged + ". Is critical: " + isCritical + ".\n";
    }
}