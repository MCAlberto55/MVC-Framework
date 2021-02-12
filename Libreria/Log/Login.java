package Log;

import org.apache.log4j.Logger;

public class Login {
    private Logger logger = Logger.getLogger(Login.class);
    private static Login log;

    private Login() {}

    public static Login getInstance() {
        if(log == null) {
            log = new Login();
            return log;
        }else {
            return log;
        }
    }

    public void fatal(String msg) {
        logger.fatal(msg);
    }

    public void error(String msg) {
        logger.error(msg);
    }

    public void info(String msg) {
        logger.info(msg);
    }
}
