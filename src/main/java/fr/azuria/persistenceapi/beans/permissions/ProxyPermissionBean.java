package fr.azuria.persistenceapi.beans.permissions;

import fr.azuria.persistenceapi.utils.Permission;
import fr.azuria.persistenceapi.utils.PermissionsProvider;

import java.util.ArrayList;

public class ProxyPermissionBean {

    @Permission("proxy.command.party")
    private boolean proxyCommandParty;

    @Permission("proxy.command.friends")
    private boolean proxyCommandFriends;

    public ProxyPermissionBean(boolean proxyCommandParty, boolean proxyCommandFriends) {
        this.proxyCommandParty = proxyCommandParty;
        this.proxyCommandFriends = proxyCommandFriends;
    }

    public boolean getProxyCommandParty() {
        return proxyCommandParty;
    }

    public boolean getProxyCommandFriends() {
        return proxyCommandFriends;
    }

    public ArrayList<String> getRealPermissions() {
        return PermissionsProvider.getPermissions(this);
    }
}
