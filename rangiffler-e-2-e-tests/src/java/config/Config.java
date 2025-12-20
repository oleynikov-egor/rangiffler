package java.config;

public interface Config {
    public static Config getInstance() {
        return LocalConfig.INSTANCE;
    }

    String frontUrl();
    String usersJdbcUrl();
    String dbUsername();
    String dbPassword();
}
