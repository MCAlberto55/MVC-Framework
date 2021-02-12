package MVC;

import ConfigurationReader.ConfigReader;
import Exceptions.NonExistConfigurationFileException;
import Exceptions.NonExistenControllerException;
import Exceptions.WrongDataConfigurationFileException;
import Interface.Observer;
import Log.Login;
import java.io.IOException;

public abstract class View implements Observer {

    private Controller controller;
    protected Model model;
    private String[] configuration;

    public void initialize(Model model, String viewName) {
        controller = new Controller();
        this.model = model;
        this.model.attach(this);
        try {
            this.configuration = readConfiguration();
            Login.getInstance().info("Configuration loaded");
        } catch (Exception e) {
            Login.getInstance().fatal(e.toString());
            e.printStackTrace();
        }
    }

    public void makeController(String controllerName) {
        Login.getInstance().info("Making Controller");
        controller.initialize(model, this, controllerName);
    }

    public void communicate() {
        Login.getInstance().info("Communicating");

        try {
            if (controller.getControllerName().equals(configuration[0])) {
                controller.update(configuration);
            } else {
                throw new NonExistenControllerException("Controller not match witch configuration name");
            }
        } catch(Exception e) {
            Login.getInstance().fatal(e.getMessage());
            e.printStackTrace();
        }
    }

    private String[] readConfiguration() throws IOException, NonExistConfigurationFileException, WrongDataConfigurationFileException {
        Login.getInstance().info("Reading configuration");
        ConfigReader reader = new ConfigReader();
        return reader.readConfiguration();
    }

    public abstract void display();
}
