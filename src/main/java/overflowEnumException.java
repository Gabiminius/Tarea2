/**
 * Para cuando se desborde enum, existirá una excepción
 */
public class overflowEnumException extends Exception{
    /**
     * Constructor de overflowEnumException
     * @param message es el mensaje que se imprimirá cuando ocurra la excepción.
     */
    public overflowEnumException(String message){
        super(message);
    }
}