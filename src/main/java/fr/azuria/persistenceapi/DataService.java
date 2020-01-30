package fr.azuria.persistenceapi;

import fr.azuria.persistenceapi.managers.GroupsManager;
import fr.azuria.persistenceapi.managers.PlayersManager;
import fr.azuria.persistenceapi.managers.permissions.PermissionsManager;
import fr.azuria.persistenceapi.utils.DatabaseCredentials;

public class DataService {

    private DatabaseManager databaseManager;

    private PlayersManager playersManager;
    private GroupsManager groupsManager;
    private PermissionsManager permissionsManager;

    public DataService(String host, String username, String password, String databaseName, int port) {
        DatabaseCredentials credentials = new DatabaseCredentials(host, username, password, databaseName, port);
        this.databaseManager = new DatabaseManager(credentials);

        this.playersManager = new PlayersManager(this);
        this.groupsManager = new GroupsManager(this);
        this.permissionsManager = new PermissionsManager(this);
    }

    public void close() {
        this.databaseManager.closePool();
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public PlayersManager getPlayerManager() {
        return playersManager;
    }

    public GroupsManager getGroupManager() {
        return groupsManager;
    }

    public PermissionsManager getPermissionManager() { return permissionsManager; }
}
