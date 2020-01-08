package fr.azuria.persistenceapi.utils;

public class DatabaseServer {

    private String host;
    private String username;
    private String password;
    private String databaseName;
    private int port;

    public DatabaseServer(String host, String username, String password, String databaseName, int port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        this.port = port;
    }

    public String toURL() {
        return "jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
