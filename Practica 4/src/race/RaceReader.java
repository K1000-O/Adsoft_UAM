package race;

import vehiculos.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import components.*;

/**
 * Clase encargada de leer un fichero para crear una nueva carrera.
 * 
 * @author estudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author estudianteEPS camilo.jenec@estudiante.uam.es
 */
public class RaceReader {
    /**
     * Metodo estático que crea una nueva carrera a partir de unos datos introducidos por texto.
     *  
     * @param nombreFichero Nombre del fichero del que se obtienen los datos.
     * 
     * @return Race 
     * 
     * @throws IOException Excepcion en caso de error de lectura del fichero.
     * @throws RaceException Caso que halla un error al crear la carrera.
     */
    public static Race read(String nombreFichero) throws IOException, RaceException {
        // Inicializamos variables necesarias para el método.
        int numVehiculos = 0;
        String tipoVehiculo = null;
        double velocidad = 0;

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        // Map<String, Vehiculo> clasesVehiculo = new HashMap<String, Vehiculo>();
        // Map<String, Component> clasesComponentes = new HashMap<String, Component>();
        // // Anyadimos los vehiculos.
        // inicializarMapVehiculos(clasesVehiculo);
        // inicializarMapComponents(clasesComponentes);

        File fichero = new File(nombreFichero);
        String texto; 
        BufferedReader br = new BufferedReader(new FileReader(fichero));

        int longitud = Integer.parseInt(br.readLine());
        
        texto = br.readLine();

        while (texto != null) {
            String[] s = texto.split(" "); 

            numVehiculos = Integer.parseInt(s[0]);  // El primer elemento del array es el numero de vehiculos.
            tipoVehiculo = s[1];    // Tipo de vehiculos.
            velocidad = Double.parseDouble(s[2]);   // 3er elemento del array == velocidad del vehiculo.

            for (int i = 0; i < numVehiculos; i++) {
                Vehiculo v = null;
                
                // Vehiculo v = clasesVehiculo.get(tipoVehiculo);
                // v.setMaxSpeed(velocidad);

                if (tipoVehiculo.equals("Car")) {
                    v = new Car(velocidad);
                } else if (tipoVehiculo.equals("Truck")) {
                    v = new Truck(velocidad);
                } else if (tipoVehiculo.equals("Motorcycle")) {
                    v = new Motorcycle(velocidad);
                }

                for (int j = 3; j < s.length; j++) {
                    IComponent c = null;

                    // Preguntar al profesor porque no funciona. Mas que preguntar porque no funciona es preguntar cual es la forma correcta.
                    if (s[j].equals("Engine")) {
                        c = new Engine(v);
                    } else if (s[j].equals("BananaDispenser")) {
                        c = new BananaDispenser(v);
                    } else if (s[j].equals("Wheels")) {
                        c = new Wheels(v);
                    } else if (s[j].equals("Window")) {
                        c = new Window(v);
                    }
                    // IComponent c = clasesComponentes.get(s[j]);
                    // ((Component)c).setVehiculo(v);

                    try {
                        v.addComponent(c);
                    } catch (InvalidComponentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                vehiculos.add(v);    
            }

            texto = br.readLine();
        }

        br.close();
        return new Race(longitud, vehiculos);
    }

    /**
     * Metodo que introduce en el HashMap los vehiculos necesarios para el funcionamiento.
     * 
     * @param m HashMap a modificar.
     */
    private static void inicializarMapVehiculos(Map<String, Vehiculo> m) {
        m.putIfAbsent("Car", new Car(0));
        m.putIfAbsent("Motorcycle", new Motorcycle(0));
        m.putIfAbsent("Truck", new Truck(0));
    }

    /**
     * Metodo que introduce en el HashMap los vehiculos necesarios para el funcionamiento.
     * 
     * @param m HashMap a modificar.
     */
    private static void inicializarMapComponents(Map<String, Component> m) {
        m.putIfAbsent("Engine", new Engine(null));
        m.putIfAbsent("BananaDispenser", new BananaDispenser(null));
        m.putIfAbsent("Window", new Window(null));
        m.putIfAbsent("Wheels", new Wheels(null));
    }
}