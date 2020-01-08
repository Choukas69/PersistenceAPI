package fr.azuria.persistenceapi.managers;

import fr.azuria.persistenceapi.utils.DatabaseServer;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {

    private DatabaseServer credentials;
    private BasicDataSource dataSource;

    public DatabaseManager(DatabaseServer credentials) {
        this.credentials = credentials;

        /*final Configuration config = plugin.getConfigurationManager().getConfiguration();

        String host = config.getString("sql-host", "localhost");
        String username = config.getString("sql-username", "root");
        String password = config.getString("sql-password", "root");
        String databaseName = config.getString("sql-database-name", "Azuria");
        int port = config.getInt("sql-port", 3306);*/

        this.setupDataSource();
    }

    private void setupDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername(credentials.getUsername());
        dataSource.setPassword(credentials.getPassword());
        dataSource.setUrl(credentials.toURL());

        this.dataSource = dataSource;
    }

    public void closePool() {
        try {
            this.dataSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        if (this.dataSource == null) {
            this.setupDataSource();
        }

        return this.dataSource.getConnection();
    }
}
