package config;

public enum LocalConfig implements Config{
    INSTANCE;

    @Override
    public String frontUrl() {
        return "http://localhost:3001/";
    }

    @Override
    public String usersJdbcUrl() {return "jdbc:mysql://localhost:3306/mysql";}

    @Override
    public String dbUsername() {
        return "root";
    }

    @Override
    public String dbPassword() {
        return "secret";
    }
}
