package TEST;

import MVC.Service;

public class TEST extends Service {

    public TEST(String name) {
        super(name);
    }

    @Override
    public String run() {
        return test_function();
    }

    public String test_function() {
        return "El lado oscuro de la Fuerza es un camino a muchas habilidades que algunos consideran... antinaturales.";
    }
}
