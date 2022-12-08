package vehiculos;

import java.util.*;

import components.*;

/**
 * Clase de tipo Motorcycle que hereda los datos de vehiculo.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Motorcycle extends Vehiculo {

    /**
     * Lista de componentes no permitidos en motocicletas.
     */
    private List<String> componentesNoPermitidos = new ArrayList<>(
            Arrays.asList(
                "Window"
            )
        );
    /**
     * Constructor del vehiculo de tipo Motorcycle.
     * 
     * @param maxSpeed Velocidad maxima del vehiculo.
     */
    public Motorcycle (double maxSpeed) {
        super(maxSpeed);
        super.name = "Motorcycle(" + super.getId() + ")";
    }

    
    /** 
     * Metodo que anyade un componente al vehiculo.
     * 
     * @param c componente
     * @throws InvalidComponentException Excepcion en caso de error de lectura de componentes.
     */
    @Override
    public void addComponent(IComponent c) throws InvalidComponentException {
        if (componentesNoPermitidos.contains(c.getName()))
            throw new InvalidComponentException("Component " + c.getName() + 
                " is not valid for Vehicle " + getName());
        
        super.addComponent(c);
    }
}
