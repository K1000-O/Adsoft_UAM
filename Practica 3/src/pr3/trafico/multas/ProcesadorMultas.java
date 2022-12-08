package pr3.trafico.multas;

import pr3.trafico.conductores.Carnet;
import pr3.trafico.conductores.Persona;
import pr3.trafico.vehiculos.Vehiculo;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase que se encargara de procesar las multas y de imprimir por pantalla diferentes mensajes segun los puntos que
 * se pierdan y segun el estado del carnet.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class ProcesadorMultas {
    /**
     * Lista de veiculos que procesar.
     */
    private List<Vehiculo> vehiculos = new ArrayList<>();

    /**
     * Constructor del procesador de multas.
     *
     * @param vehiculos lista de vehiculos.
     */
    public ProcesadorMultas(List<Vehiculo> vehiculos) {
        this.vehiculos.addAll(vehiculos);
    }

    /**
     * Metodo que procesa las multas e imprime su correspondiente mensaje por pantalla.
     *
     * @param multas listado de multas a procesar.
     */
    public void procesar(ArrayList<Multa> multas) {
        /* Para cada multa, comprobamos el vehiculo al que le corresponde la matricula y lo obtenemos. */
        for (Multa m: multas) {
            Vehiculo v = null;

            if (vehiculos.stream().anyMatch(x -> x.getMatricula().equals(m.getMatricula())))
               v = vehiculos.stream().filter(x -> x.getMatricula().equals(m.getMatricula())).collect(Collectors.toList()).get(0);

            if (v != null) {
                Persona conductor = v.getConductor();

                if (conductor != null) {
                    System.out.println(mensajePerdidaPuntos(v.getConductor(), m));

                    if (comprobarITV(v)) {
                        m.setPuntos(m.getPuntos() + 1);
                        System.out.println("Infraccion adicional: ITV no pasada. Total puntos perdidos: " + m.getPuntos());
                        escribirItvCaducada(v);
                    }

                    if (conductor.getCarnet().getPuntos() == 0) {
                        // Poner la perdida de puntos y que se ha cancelado el carnet.
                        System.out.println(carnetSuspendido(conductor));
                    } else {
                        setearPuntos(conductor.getCarnet(), m);

                        if (conductor.getCarnet().getPuntos() == 0) {
                            System.out.println("El conductor " + conductor.getNombre() + " queda con 0 puntos.");
                        }
                    }
                } else {
                    System.out.println(vehiculoSinConductor());
                }
            }
        }
    }

    /**
     * Mensaje de que un conductor ha perdido puntos.
     *
     * @param conductor conductor que ha perdido puntos.
     * @param m multa correspondiente al vehiculo del conductor.
     * @return mensaje de perdida de puntos.
     */
    private String mensajePerdidaPuntos(Persona conductor, Multa m) {
        return "El conductor " + conductor.getNombre() + " pierde " + m.getPuntos() + " puntos.";
    }

    /**
     * Mensaje de que un carnet ha quedado suspendido.
     *
     * @param conductor conductor al que se le ha suspendido el carnet.
     * @return mensaje de suspension.
     */
    private String carnetSuspendido(Persona conductor) {
        conductor.getCarnet().setCarnetSuspendido(true);
        return "Queda suspendido el carnet de " + conductor.getNombre() + ".";
    }

    /**
     * Mensaje de que el vehiculo no tiene conductor.
     *
     * @return mensaje vehiculo sin conductor.
     */
    private String vehiculoSinConductor() {
        return "El vehiculo no tiene ningun conductor.";
    }

    /**
     * Metodo para setear los nuevos puntos del carnet.
     *
     * @param carnet carnet a cambiar los puntos.
     * @param m multa del que obtener los puntos a extraer.
     */
    private void setearPuntos(Carnet carnet, Multa m) {
        int puntos = carnet.getPuntos() - m.getPuntos();

        carnet.setPuntos(Math.max(puntos, 0));
    }

    /**
     * Metodo que comprueba si el coche tiene la ITV en regla.
     *
     * @param vehiculo vehiculo a comprobar.
     * @return true si no la tiene en regla, false si la tiene.
     */
    private Boolean comprobarITV(Vehiculo vehiculo) {
        LocalDate fechaActual = LocalDate.now();

        return fechaActual.isAfter(vehiculo.nextItv()) || fechaActual.isEqual(vehiculo.nextItv()); // Si es fecha posterior devuelve true --> infraccion.
    }

    /**
     * Metodo usado para escribir en un fichero el vehiculo y el conductor del mismo al tener la infraccon de vehiculo
     * sin ITV.
     *
     * @param vehiculo vehiculo sin ITV.
     */
    private void escribirItvCaducada(Vehiculo vehiculo) {
        File fichero = new File("ITV_caducada.txt");

        if (!fichero.exists()) {
            try{
                if (!fichero.createNewFile())
                    return;
            } catch (IOException e) {
                System.out.println("Error al abrir el fichero.");
                e.printStackTrace();
            }
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));

            bw.write(vehiculo.getMatricula() + "; No tiene la itv en regla; 1\n");

            bw.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero.");
            e.printStackTrace();
        }
    }
}
