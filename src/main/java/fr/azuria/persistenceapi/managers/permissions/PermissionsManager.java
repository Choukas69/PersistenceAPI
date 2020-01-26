package fr.azuria.persistenceapi.managers.permissions;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.PlayerBean;

import java.util.ArrayList;

public class PermissionsManager {

    private final ProxyPermissionsManager proxyPermissionsManager;

    public PermissionsManager(DataService dataService) {
        this.proxyPermissionsManager = new ProxyPermissionsManager(dataService);
    }

    public ArrayList<String> getAllPermissions(PlayerBean playerBean) {
        ArrayList<String> permissions = new ArrayList<>();

        permissions.addAll(this.proxyPermissionsManager.getProxyPermissions(playerBean).getRealPermissions());

        return permissions;
    }
}
