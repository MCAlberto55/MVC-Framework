package MVCManager;

import Log.Login;
import MVC.Model;
import MVC.View;

public class MVCFramework {

    private MVCData data;

    public MVCFramework(MVCData data) {
        this.data = data;
    }

    public void execute() {
        Login.getInstance().info("Executing MVC");
        Model model = new Model(data.getModelName(), data.getService());
        View view = data.getView();
        view.initialize(model, data.getViewName());
        view.makeController(data.getControllerName());
        Login.getInstance().info("Instantiated components");
        view.display();
    }
}
