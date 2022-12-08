package race;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import components.*;
import powerUps.*;
import vehiculos.*;

/**
 * Clase Race en la que guardaremos todos los datos necesarios para el 
 * tratamiento de estas.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class Race {
    /**
     * Longitud de la carrera.
     */
    private int longitud;

    /**
     * Lista de vehiculos que participan en la carrera.
     */
    private List<Vehiculo> vehiculos = new ArrayList<>();

    /**
     * Lista de powerUps que contiene la carrera.
     */
    private List<IPowerUp> powerUps = new ArrayList<>(Arrays.asList(new Swap(), new AttackAll(), new SpeedUp()));

    /**
     * Turno en el que nos encontramos
     */
    private int turno = 1;

    /**
     * Atributo que habilita los ataques.
     */
    private boolean allowAttacks = false;
    /**
     * Atributo que habilita el uso de powerups.
     */
    private boolean allowPowerUps = false;
    
    /**
     * Constructor de la clase Race.
     * 
     * @param longitud Longitud de la carrera.
     * @param vehiculos Lista de vehiculos.
     * @throws RaceException Excepcion en caso ed error de lectura de carrera.
     */
    public Race(int longitud, ArrayList<Vehiculo> vehiculos) throws RaceException {
        this.longitud = longitud;
        this.vehiculos = vehiculos;
 
        comprobarErrores();
    }

    /**
     * Método para simular los turnos de la carrera.
     * 
     */
    public void simulate() {
        do {
            System.out.println("--------------------\nStarting turn:" + turno +
                imprimirVehiculos() + (allowAttacks ? imprimirAtaques() + (allowPowerUps ? algoritmoPowerUps() : "") + imprimirReparaciones() : "") + 
                "Ending Turn: " + turno + "\n--------------------\n");
                         
            for(Vehiculo v : vehiculos) {
                v.actualizarPosicion();
            }

            turno++;
        } while (!vehiculos.stream().anyMatch(x -> x.getActualPosition() >= longitud));     
        
        Vehiculo vGanador = vehiculos.stream().filter(x -> x.getActualPosition() >= longitud).findFirst().get();
        System.out.println(vGanador + " has won the race.");
    }

    
    /** 
     * Metodo que implementa el algoritmo de ataque de la carrera.
     * 
     * @return String
     */
    private String algoritmoAtaque() {
        double tamAux = 31;
        String texto = "";

        for (IVehicle v : vehiculos) {
            IVehicle vehiculoAAtacar = null;
            try {
                IComponent c = v.getComponents().stream().filter(x -> x.getName().equals("BananaDispenser")).findFirst().get();
                
                // Comprobamos que el banana dispenser no esta dañado.
                if (c.isDamaged()) {
                    texto += v.getName() + " can not attack.\n";
                } else {
                    for (IVehicle v1: vehiculos) {
                        if (v1.getActualPosition() - v.getActualPosition() <= 30 &&
                            v1.getActualPosition() - v.getActualPosition() >= 0 && 
                            !v1.equals(v)) { 
                                // Si la distancia es menor que la anterior guardada nos quedamos con ese vehiculo. Si es igual se hace al azar. 
                                if (v1.getActualPosition() - v.getActualPosition() < tamAux) {
                                    tamAux = v1.getActualPosition() - v.getActualPosition();
                                    vehiculoAAtacar = v1;
                                } else if (v1.getActualPosition() - v.getActualPosition() == tamAux) {
                                    vehiculoAAtacar = Math.random() < 0.5 ? v1 : vehiculoAAtacar;
                                }
                            }
                    }
                    
                    if (vehiculoAAtacar == null || Math.random() < 0.5) {
                        texto += v.getName() + " fails attack.\n";
                    } else {
                        // Elegimos el componente a atacar.
                        IComponent c1 = vehiculoAAtacar.getComponents().get((int)Math.floor(Math.random()*vehiculoAAtacar.getComponents().size()));
                        c1.setDamaged(true);
                        if (c1.isCritical()) c1.getVehicle().setCanMove(false);
                        texto += v.getName() + " attacks " + vehiculoAAtacar.getName() + " " + c1.getName() + ".\n";
                    }
                }
            } catch (NoSuchElementException e) {
                // Si el vehiculo no tiene la banana dispenser no puede atacar.
                texto += v.getName() + " can not attack.\n";
            }

            tamAux = 31;
        }

        return texto;
    }

    /**
     * Metodo que establece en cada turno si los vehiculos obtendran o no powerups.
     * 
     * @return String
     */
    private String algoritmoPowerUps() {
        String texto = "\u001B[35m";

        if (Math.random() * 10 + 1 == 1 || turno % 3 == 0) {
            vehiculos.stream().forEach(x -> x.setPowerUp(powerUps.get((int)Math.floor(Math.random() * powerUps.size()))));
        } else {
            texto += "\nTurn with no powerups\n\u001B[0m";
            return texto;
        }

        for (Vehiculo v : vehiculos) {
            ((PowerUp)v.getPowerUp()).realizarAccion(vehiculos, v);  
            texto += "\nVehicle: " + v.getName() + " applying power-up: " + v.getPowerUp().namePowerUp();    
        }

        texto += "\n\u001B[0m";
        return texto;
    }

    
    /** 
     * Metodo que imprime los ataques de la carrera.
     * 
     * @return String
     */
    private String imprimirAtaques() {
        String texto = "\033[32m";

        if (turno % 3 == 0) {
            texto += "\n>>> Starting attack phase\n";
            texto += algoritmoAtaque();
        } else {
            texto += "\n>>> Not attacking turn.\n";
        }

        texto += "\u001B[0m";

        return texto;
    }

    
    /** 
     * Metodo que imprime las reparaciones que deben realizar los componentes de cada vehiculo.
     * 
     * @return String
     */
    private String imprimirReparaciones() {
        String texto = "\033[31m";
        int faseReparacion;

        for (IVehicle v : vehiculos) {
            for (IComponent c : v.getComponents()) {
                if (c.isDamaged()) {
                    c.repair();
                    faseReparacion = ((Component)c).getFaseReparacion();
                    texto += v.getName() + " " + c.getName() + " is being repaired " + 
                        (faseReparacion != 0 ? faseReparacion : c.costRepair()) + "/" + c.costRepair() + ".\n";
                }
            }
        }
        
        texto += "\n\u001B[0m";
        return texto;
    }

    /** 
     * Método que imprime los vehiculos de la carrera.
     * 
     * @return String
     */
    public String imprimirVehiculos() {
        String texto = "\nRace with maximum length: " + longitud + "\n";

        for (IVehicle v : vehiculos) {
            texto += v.toString(); // Concatenamos los textos.

            // Por cada vehiculo, imprimimos la distancia entre los demás vehiculos.
            for (IVehicle v2 : vehiculos) {
                if (!v2.equals(v)) {
                    texto += " " + v.getName() + " distance to " + v2.getName() + 
                            ": " + getTwoDecimals(Math.abs(v.getActualPosition() - v2.getActualPosition())) + "\n";
                }
            }
        }
        return texto;
    }

    /**
     * Metodo que devuelve el valor pasado por parámetro pero con dos decimales.
     * 
     * @param value Valor que hay que transformar.
     * @return String
     */
    private String getTwoDecimals(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value);
    }

    /**
     * Metodo que comprueba los posibles erroes de la carrera.
     * 
     * @throws RaceException Excepcion en caso de error de lectura.
     */
    private void comprobarErrores() throws RaceException {
        /* Por cada vehiculo comprobamos si alguno tiene una velocidad maxima mayor que la
        longitud de la carrera. */
        if (vehiculos.stream().anyMatch(x -> x.getMaxSpeed() >= longitud)) 
            throw new RaceException("Tamanyo de la carrera incorrecta.");
    }

    
    /** 
     * Setter de allowAttacks.
     * 
     * @param allow Booleano que especifica si se puede atacar o no.
     */
    public void allowAttacks(boolean allow) {
        this.allowAttacks = allow;
    }

    /** 
     * Setter de allowPowerUps.
     * 
     * @param allow Booleano que especifica si se puede usar powerups o no.
     */
    public void allowPowerUps(boolean allow) {
        this.allowPowerUps = allow;
    }
    
    /** 
     * Metodo toString de la clase Race.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return imprimirVehiculos();
    }
}
