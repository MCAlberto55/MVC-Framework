package MVC;

import java.lang.reflect.Method;

public abstract class Service {
    private String name;

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasFunction(String function) {
        boolean hasFunction = false;
        Class service = this.getClass();
        var methods = service.getMethods();

        for(Method method: methods) {
            var methodName = method.getName();

            if(methodName.equals(function)) {
                hasFunction = true;
            }
        }
        return hasFunction;
    }

    public abstract String run();
}
