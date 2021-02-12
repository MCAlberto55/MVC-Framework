package MVC;

import Exceptions.NonExistentModelException;
import Log.Login;

public class Controller {
    private View view;
    private Model model;
    private String controllerName;

    public void initialize(Model model, View view, String name) {
        Login.getInstance().info("Inicializating Controller");
        this.model = model;
        this.view = view;
        this.controllerName = name;
    }

    public void update(String configuration[]) throws NonExistentModelException {
        Login.getInstance().info("Updating Model");

        if(model.getModelName().equals(configuration[1])) {
            try {
                model.service(configuration);
            } catch (Exception e) {
                Login.getInstance().fatal(e.getMessage());
                e.printStackTrace();
            }
        }else {
            throw new NonExistentModelException("Name do not match with configuration");
        }
    }

    public String getControllerName() {
        return controllerName;
    }
}
