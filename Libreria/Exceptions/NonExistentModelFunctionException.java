package Exceptions;

public class NonExistentModelFunctionException extends Exception{
    public static final long serialVerionUID = 117;

    public NonExistentModelFunctionException(String alerta) {
        super(alerta);
    }
}
