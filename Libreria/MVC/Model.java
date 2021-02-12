package MVC;

import Exceptions.NonExistentModelFunctionException;
import Exceptions.NonExistentTransactionException;
import Interface.Observer;
import Log.Login;
import java.util.ArrayList;

public class Model {
    private String Data;
    private String modelName;
    private Service service;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public Model(String name, Service service) {
        Login.getInstance().info("Creating Model");
        this.modelName = name;
        this.service = service;
    }

    public void attach(Observer observer) {
        Login.getInstance().info("Attaching Observer");
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        Login.getInstance().info("Notifying Observers");
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }

    public void service(String[] configuration) throws NonExistentTransactionException, NonExistentModelFunctionException {
        if(configuration[2].equals(service.getName())) {
            if(this.service.hasFunction(configuration[3]) == true) {
                setData(service.run());
                notifyObservers();
            }else {
                throw new NonExistentTransactionException("Service do not has that function");
            }
        }else {
            throw new NonExistentModelFunctionException("Service doesn't exist");
        }
    }

    public String getModelName() {
        return modelName;
    }

    public String getData() {
        Login.getInstance().info("Observer reads Model data");
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
