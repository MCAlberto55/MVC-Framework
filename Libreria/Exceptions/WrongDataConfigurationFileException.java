package Exceptions;

public class WrongDataConfigurationFileException extends Exception{
    public static final long serialVerionUID = 312;

    public WrongDataConfigurationFileException(String alerta) {
        super(alerta);
    }
}
