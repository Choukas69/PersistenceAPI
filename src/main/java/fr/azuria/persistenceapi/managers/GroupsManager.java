package fr.azuria.persistenceapi.managers;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.GroupBean;
import fr.azuria.persistenceapi.beans.PlayerBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupsManager {

    private final DataService dataService;

    public GroupsManager(DataService dataService) {
        this.dataService = dataService;
    }

    public GroupBean loadGroup(PlayerBean bean) {
        try (Connection connection = dataService.getDatabaseManager().getConnection()) {
            final String SQL = "SELECT * FROM `groups` WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, bean.getGroupId());

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                final int id = result.getInt("id");
                final String name = result.getString("name");
                final String tag = result.getString("tag");

                return new GroupBean(id, name, tag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
