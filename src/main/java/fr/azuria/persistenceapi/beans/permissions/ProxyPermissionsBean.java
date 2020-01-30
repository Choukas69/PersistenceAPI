package fr.azuria.persistenceapi.beans.permissions;

import fr.azuria.persistenceapi.utils.Permission;
import fr.azuria.persistenceapi.utils.PermissionsProvider;

import java.util.ArrayList;

public class ProxyPermissionsBean {

    @Permission("proxy.command.party")
    private boolean proxyCommandParty;

    @Permission("proxy.command.friends")
    private boolean proxyCommandFriends;

    public ProxyPermissionsBean(boolean proxyCommandParty, boolean proxyCommandFriends) {
        this.proxyCommandParty = proxyCommandParty;
        this.proxyCommandFriends = proxyCommandFriends;
    }

    public ArrayList<String> getPermissions() {
        return PermissionsProvider.getPermissions(this);
    }
}
