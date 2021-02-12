package ConfigurationReader;

import Exceptions.NonExistConfigurationFileException;
import Exceptions.WrongDataConfigurationFileException;
import java.io.IOException;

public class ConfigReader {

    public String[] readConfiguration() throws NonExistConfigurationFileException, WrongDataConfigurationFileException, IOException {
        GetPropertyValues properties = new GetPropertyValues();
        return properties.getPropValues();
    }
}
