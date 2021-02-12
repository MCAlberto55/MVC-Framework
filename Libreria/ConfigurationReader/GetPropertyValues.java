package ConfigurationReader;

import Exceptions.NonExistConfigurationFileException;
import Exceptions.WrongDataConfigurationFileException;
import Log.Login;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {
    private String[] result;
    private InputStream inputStream;

    public String[] getPropValues() throws WrongDataConfigurationFileException, NonExistConfigurationFileException {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new NonExistConfigurationFileException("Property file " + propFileName + "' not found in the classpath");
            }
        }catch(Exception e) {
            Login.getInstance().fatal(e.getMessage());
            e.printStackTrace();
        }

        try{
            // get the property value and print it out
            String transacciónName = prop.getProperty("TransacciónName");
            String controller = prop.getProperty("Controller");
            String model = prop.getProperty("MVC.Model");
            String función = prop.getProperty("Función");

            result = new String[]{controller, model, transacciónName, función};
        } catch(Exception e){
            throw  new WrongDataConfigurationFileException("wrong format, please check user manual");
        }

        return result;
    }
}
