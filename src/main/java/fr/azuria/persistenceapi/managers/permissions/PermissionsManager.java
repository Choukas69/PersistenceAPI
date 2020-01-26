package fr.azuria.persistenceapi.managers.permissions;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.GroupBean;
import fr.azuria.persistenceapi.beans.PlayerBean;

import java.util.ArrayList;

public class PermissionsManager {

    private final DataService dataService;

    private final ProxyPermissionsManager proxyPermissionsManager;

    public PermissionsManager(DataService dataService) {
        this.dataService = dataService;

        this.proxyPermissionsManager = new ProxyPermissionsManager(dataService);
    }

    public ArrayList<String> getAllPermissions(PlayerBean playerBean) {
        ArrayList<String> permissions = new ArrayList<>();

        final GroupBean groupBean = this.dataService.getGroupManager().loadGroup(playerBean.getGroupId());

        permissions.addAll(this.proxyPermissionsManager.getProxyPermissions(groupBean).getRealPermissions());

        return permissions;
    }
}
