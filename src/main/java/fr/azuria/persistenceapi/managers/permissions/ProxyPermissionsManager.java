package fr.azuria.persistenceapi.managers.permissions;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.GroupBean;
import fr.azuria.persistenceapi.beans.permissions.ProxyPermissionBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProxyPermissionsManager {

    private final DataService dataService;

    public ProxyPermissionsManager(DataService dataService) {
        this.dataService = dataService;
    }

    public ProxyPermissionBean getProxyPermissions(GroupBean groupBean) {
        try (Connection connection = this.dataService.getDatabaseManager().getConnection()) {
            final int groupId = groupBean.getId();

            final String SQL = "SELECT * FROM proxy_permissions WHERE group_id = ?";

            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, groupId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                boolean proxyCommandParty = resultSet.getBoolean("proxy_command_party");
                boolean proxyCommandFriends = resultSet.getBoolean("proxy_command_friends");

                return new ProxyPermissionBean(proxyCommandParty, proxyCommandFriends);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
