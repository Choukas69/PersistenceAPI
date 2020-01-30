package fr.azuria.persistenceapi.managers.permissions;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.PlayerBean;
import fr.azuria.persistenceapi.beans.permissions.PermissionsBean;
import fr.azuria.persistenceapi.beans.permissions.ProxyPermissionsBean;

public class PermissionsManager {

    private ProxyPermissionsManager proxyPermissionsManager;

    public PermissionsManager(DataService dataService) {
        this.proxyPermissionsManager = new ProxyPermissionsManager(dataService);
    }

    public PermissionsBean getPermissions(PlayerBean playerBean) {
        ProxyPermissionsBean proxyPermissionsBean = this.proxyPermissionsManager.getProxyPermissions(playerBean);

        return new PermissionsBean(proxyPermissionsBean);
    }
}
