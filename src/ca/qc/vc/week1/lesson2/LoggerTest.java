package ca.qc.vc.week1.lesson2;


class Logger {

    private static final Logger INSTANCE = new Logger();

    private Logger() {}

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void info(String message) {
        System.out.println("[INFO] " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.info("Application started.");
    }
}
