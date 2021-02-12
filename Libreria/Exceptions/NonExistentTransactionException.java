package Exceptions;

public class NonExistentTransactionException extends Exception{
    public static final long serialVerionUID = 911;

    public NonExistentTransactionException(String alerta) {
        super(alerta);
    }
}
