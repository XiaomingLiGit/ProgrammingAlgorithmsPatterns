package ca.qc.vc.week1.lesson2;


class AppConfig {

    private static final AppConfig INSTANCE = new AppConfig();

    private String databaseUrl = "jdbc:mysql://localhost:3306/shop";
    private boolean debugMode = true;

    private AppConfig() {}

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public boolean isDebugMode() {
        return debugMode;
    }
}

public class AppConfigTest {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        System.out.println(config.getDatabaseUrl());
    }
}
