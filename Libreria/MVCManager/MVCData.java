package MVCManager;

import MVC.Service;
import MVC.View;

public class MVCData {
    private String controllerName;
    private String modelName;
    private String viewName;
    private View view;
    private Service service;

    public MVCData(String controllerName, String modelName, String viewName, View view, Service service) {
        this.controllerName = controllerName;
        this.modelName = modelName;
        this.viewName = viewName;
        this.view = view;
        this.service = service;
    }

    public String getControllerName() {
        return controllerName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getViewName() {
        return viewName;
    }

    public View getView() {
        return view;
    }

    public Service getService() {
        return service;
    }

}
