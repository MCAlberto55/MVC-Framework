package Exceptions;

public class NonExistenControllerException extends Exception{
    public static final long serialVerionUID = 055;

    public NonExistenControllerException(String alerta) {
        super(alerta);
    }
}
