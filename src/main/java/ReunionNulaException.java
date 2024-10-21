/**
 * Para el caso en que la duración del la reunión sea nula, se tendrá esta clase excepción
 */
public class ReunionNulaException extends Exception {
    /**
     * Constructor
     * @param message es el mensaje que se mostrará en la excepción
     */
    public ReunionNulaException(String message) {
        super(message);
    }
}