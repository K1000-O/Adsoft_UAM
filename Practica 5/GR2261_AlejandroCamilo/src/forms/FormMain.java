package forms;
import java.io.IOException;

/**
 * Clase con el main que usamos apra probar el primer apartado.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class FormMain {
    /**
     * Método main para comprobar el correcto funcionamiento del formulario y los fields.
     * 
     * @param args String con los argumentos que recibe el método para funcionar.
     * 
     * @throws IOException excepción que se lanza si hay algun error de ejecución en el main.
     */
    public static void main(String[] args) throws IOException {
        Form enrollForm = new Form();
        Field<Integer> age = new Field<Integer>(s -> Integer.valueOf(s)).
                                addValidation(a -> a > 18, "value should be bigger than 18").
                                addValidation(a -> a < 66, "value should be less than 66");
        Field<Boolean> yesNo = new Field<>(s -> s.toUpperCase().equals("YES"));
        enrollForm.add("What is your age?", age).
                   add("Are you married?", yesNo).
                   add("Do you have children?", yesNo).
                   add("Are you married?", yesNo);
        System.out.println(enrollForm.exec());
    }
}
