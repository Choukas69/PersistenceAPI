package fr.azuria.persistenceapi;

import fr.azuria.persistenceapi.managers.GroupManager;
import fr.azuria.persistenceapi.managers.PlayerManager;
import fr.azuria.persistenceapi.utils.DatabaseCredentials;

public class DataService {

    private DatabaseManager databaseManager;
    private PlayerManager playerManager;
    private GroupManager groupManager;

    public DataService(String host, String username, String password, String databaseName, int port) {
        final DatabaseCredentials credentials = new DatabaseCredentials(host, username, password, databaseName, port);
        this.databaseManager = new DatabaseManager(credentials);

        this.playerManager = new PlayerManager(this);
        this.groupManager = new GroupManager(this);
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
