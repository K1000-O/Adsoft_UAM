package processings;

import java.io.IOException;

import forms.Field;
import forms.Form;

/**
 * Clase address en la que guardamos la direccion en la que vive alguien y su codigo postal. Implementamos la interfaz
 * Comparable ya que nos interesa comparar de una forma determinada las coass.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
class Address implements Comparable<Address> {
    /**
     * Atributo address para guardar la dirección.
     */
    private String address;

    /**
     * Atributo que guarda la direccion del codigo postal.
     */
    private int postalCode;

    /**
     * COnstructor de la clase Address.
     * 
     * @param adr Direccion de la vivienda.
     * @param pc Codigo postal de la vivienda.
     */
    public Address(String adr, int pc) {
        this.address = adr;
        this.postalCode = pc;
    }

    
    /** 
     * Getter del codigo postal.
     * 
     * @return int
     */
    public int postalCode() { 
        return this.postalCode; 
    }

    
    /** 
     * Metodo toString de la direccion.
     * 
     * @return String
     */
    public String toString() {
        return this.address+" at PC("+this.postalCode+")";
    }

    /**
     * Metodo override compareTo que devuelve la diferencia entre dos direcciones. Si los codigos postales
     * son iguales compara las Strings.
     * 
     * @param o Adress a comparar.
     */
    @Override
    public int compareTo(Address o) {
        return o.postalCode == this.postalCode 
            ? address.compareTo(o.address) : postalCode - o.postalCode;
    }
}

/**
 * Clase main del apartado 2.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class ProcessingMain {

    /**
     * Main del apartado 2.
     * 
     * @param args Argumentos de entrada.
     * @throws IOException Excepcion en caso de error.
     */
    public static void main(String[] args) throws IOException {
        Form censusForm = new Form();
        
        Field<Address> adr = new Field<Address>(s -> { String[] data = s.split(";");
                                                        return new Address(data[0], Integer.valueOf(data[1].trim()));
                                                    }).
                                addValidation(a -> a.postalCode() >= 0, "Postal code should be positive");

        Field<Integer> np = new Field<Integer>(s->Integer.valueOf(s)).
                                addValidation(s->s>0, "value greater than 0 expected");

        censusForm.add("Enter address and postal code separated by ';'", adr).
                   add("Number of people living in that address?", np);

        DataAggregator dag = new DataAggregator();
        for (int i=0; i<3; i++)
            dag.add(censusForm.exec());

        System.out.println(dag);
    }
}
    
