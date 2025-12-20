package java.config;

public enum LocalConfig implements Config{
    INSTANCE;

    @Override
    public String frontUrl() {
        return "http://localhost:3001/";
    }

    @Override
    public String usersJdbcUrl() {
        return "http://localhost:5432/";
    }

    @Override
    public String dbUsername() {
        return "secret";
    }

    @Override
    public String dbPassword() {
        return "secret";
    }
}
