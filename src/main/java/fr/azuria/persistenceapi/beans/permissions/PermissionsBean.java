package fr.azuria.persistenceapi.beans.permissions;

import java.util.ArrayList;

public class PermissionsBean {

    private ProxyPermissionsBean proxyPermissionsBean;

    public PermissionsBean(ProxyPermissionsBean proxyPermissionsBean) {
        this.proxyPermissionsBean = proxyPermissionsBean;
    }

    public ArrayList<String> getList() {
        ArrayList<String> permissions = new ArrayList<>();

        permissions.addAll(this.proxyPermissionsBean.getPermissions());

        return permissions;
    }
}
