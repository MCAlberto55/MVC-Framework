package Exceptions;

public class NonExistentModelException extends Exception{
    public static final long serialVerionUID = 777;

    public NonExistentModelException(String alerta) {
        super(alerta);
    }
}
