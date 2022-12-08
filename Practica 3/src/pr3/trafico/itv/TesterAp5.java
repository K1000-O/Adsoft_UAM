package pr3.trafico.itv;

import pr3.trafico.vehiculos.Camion;
import pr3.trafico.vehiculos.Coche;
import pr3.trafico.vehiculos.Motocicleta;
import pr3.trafico.vehiculos.Vehiculo;

import java.time.LocalDate;

/**
 * Tester de la clase Itv.
 *
 * @author EstudianteEPS Alejandro Hurtado Fuertes alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS Camilo Jene Conde camilo.jenec@estudiante.uam.es
 */
public class TesterAp5 {

    /**
     * Main del tester.
     *
     * @param args Argumentos de entrada.
     */
    public static void main (String[] args) {
        Taller taller = new Taller("Neumaticos SL", "Calle De La Avenida 42", "Madrid");

        Itv[] itvs = {
                new Itv(LocalDate.now(), taller, "No ha pasado la ITV."), // Hoy
                new Itv(LocalDate.of(2018, 12, 22), taller, "Ha pasado la ITV de forma correcta."), // 22-12-2018
                new Itv(LocalDate.now().minusMonths(3), taller, "Pasada ITV"), // Itv pasada hace 3 meses. Para probar el camión c3.
                new Itv(LocalDate.of(2020, 4, 13), taller, "Itv pasada."),
                new Itv(LocalDate.of(2019, 4, 13), taller, "Itv no pasada."),
        };

        taller.addItv(itvs);

        Vehiculo c1 = new Coche("Ck212", 2020, "2123 KJA", true);
        Vehiculo c2 = new Motocicleta("Mk212", 2010, "4322 xDD", true);
        Vehiculo c3 = new Camion("Cam21", 2008, "2211 JAJA", 3);
        Vehiculo c4 = new Camion("Cam22", 2014, "2015 BABA", 2);

        c1.addItv(itvs[0]);
        c2.addItv(itvs[1]);
        c3.addItv(itvs[2]);
        c4.addItv(itvs[3]);

        System.out.println(c1.toString() + c1.nextItv());
        System.out.println("\n" + c2.toString() + " " + c2.nextItv()); // Tiene que dar el día actual.
        System.out.println("\n" + c3.toString() + " " + c3.nextItv()); // Tiene que dar dentro de 3 meses.
        System.out.println("\n" + c4.toString() + " " + c4.nextItv()); // Tiene que dar el 13-4-2021.

        System.out.println(taller.getVehiculos());  // Muestra todos los vehiculos del taller.
    }
}
