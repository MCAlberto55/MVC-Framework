package Exceptions;

public class NonExistConfigurationFileException extends Exception{
    public static final long serialVerionUID = 007;

    public NonExistConfigurationFileException(String alerta) {
        super(alerta);
    }
}

