package fr.azuria.persistenceapi;

import fr.azuria.persistenceapi.managers.GroupsManager;
import fr.azuria.persistenceapi.managers.PlayersManager;
import fr.azuria.persistenceapi.managers.permissions.PermissionsManager;
import fr.azuria.persistenceapi.utils.DatabaseCredentials;

public class DataService {

    private final DatabaseManager databaseManager;

    private final PlayersManager playerManager;
    private final GroupsManager groupManager;
    private final PermissionsManager permissionManager;

    public DataService(String host, String username, String password, String databaseName, int port) {
        final DatabaseCredentials credentials = new DatabaseCredentials(host, username, password, databaseName, port);
        this.databaseManager = new DatabaseManager(credentials);

        this.playerManager = new PlayersManager(this);
        this.groupManager = new GroupsManager(this);
        this.permissionManager = new PermissionsManager(this);
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public PlayersManager getPlayerManager() {
        return playerManager;
    }

    public GroupsManager getGroupManager() {
        return groupManager;
    }

    public PermissionsManager getPermissionManager() { return permissionManager; }
}
