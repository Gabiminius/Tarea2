/**
 * Consideramos esta excepcion cuando se quiera ingresar un empleado a una reunión que ya terminó.
 */
public class ReunionFinalizadaException extends Exception {
    /**
     * Constructor de la clase
     * @param message Mensaje que se mostrará en la excepción.
     */
    public ReunionFinalizadaException(String message) {
        super(message);
        /** el mensaje estará en el main
         * */
    }
}