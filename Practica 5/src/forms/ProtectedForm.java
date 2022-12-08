package forms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Clase ProtectedForm, unicamente con el metodo protect, 
 * Es parte del patrón de diseño proxy.
 * 
 * @author EstudianteEPS alejandror.hurtado@estudiante.uam.es
 * @author EstudianteEPS camilo.jenec@estudiante.uam.es
 */
public class ProtectedForm extends AbstractForm{
    /**
     * Form al que le introducimos la seguridad.
     */
    private Form form;

    /**
     * Contrasenya del form.
     */
    private String contrasenya;

    /**
     * Atributo que nos indica si el form se ha bloqueado.
     */
    private boolean bloqueado = false;

    /**
     * Atributo que nos indica si ya se ha introducido la contrasenya de forma correcta.
     */
    private boolean yaIntroducido = false;

    /**
     * Numero de intentos para la contrasenya.
     */
    private final int intentos = 3;

    /**
     * Constructor del AbstractForm
     * 
     * @param form Form al que introducirle la contrasenya.
     * @param contrasenya Constrasenya a introducirle.
     */
    private ProtectedForm(Form form, String contrasenya) {
        this.form = form;
        this.contrasenya = contrasenya;
    }

    /**
     * Método protect que crea un objeto de tipo AbstractForm con un formulario y una contrasenya.
     * 
     * @param form Formulario que vamos a proteger.
     * @param contrasenya Contraseña con la que vamos a proteger el formulario.
     * 
     * @return AbstractForm Objeto de tipo AbstractForm que tiene un formulario al que solo se accederá si se introduce la contraseña correcta.
     */
    public static AbstractForm protect(Form form, String contrasenya) {
        AbstractForm aF = new ProtectedForm(form, contrasenya);

        return aF;
    }

    /**
     * Metodo que devuelve el exec del form en caso de contrasenya correcta o null en caso de incorrecta.
     * 
     * @return Map
     * @throws IOException Excepcion en caso de error en I/O.
     */
    public Map<String, ?> exec() throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String valorTeclado = null;
        
        if (!bloqueado && !yaIntroducido) {
            for(int i = 0; i < intentos; i++) {
                System.out.println("Enter password: ");

                valorTeclado = br.readLine();

                if (valorTeclado.equals(contrasenya)) {
                    yaIntroducido = true;
                    return form.exec();
                } else {
                    System.out.println("Invalid password " + (intentos - (i + 1)) + " remaining attempts.");
                }
            }

            bloqueado = true;
        } else if (yaIntroducido) {
            return form.exec();
        }

        return null;
    }
}
