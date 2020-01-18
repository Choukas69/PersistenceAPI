package fr.azuria.persistenceapi;

import fr.azuria.persistenceapi.utils.DatabaseCredentials;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {

    private DatabaseCredentials databaseCredentials;
    private BasicDataSource dataSource;

    public DatabaseManager(DatabaseCredentials databaseCredentials) {
        this.databaseCredentials = databaseCredentials;

        this.setupDataSource();
    }

    private void setupDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername(databaseCredentials.getUsername());
        dataSource.setPassword(databaseCredentials.getPassword());
        dataSource.setUrl(databaseCredentials.toURL());

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
