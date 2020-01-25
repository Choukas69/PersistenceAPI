package fr.azuria.persistenceapi.managers;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.GroupBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupManager {

    private DataService dataService;

    public GroupManager(DataService dataService) {
        this.dataService = dataService;
    }

    public GroupBean loadGroup(int id) {
        try (Connection connection = dataService.getDatabaseManager().getConnection()) {
            final String sql = "SELECT * FROM permissions WHERE group_id >= ?";

            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            final ResultSet result = statement.executeQuery();

            if (result.next()) {
                final int permLevel = result.getInt("perm_level");
                final String name = result.getString("name");
                final String frenchName = result.getString("french_name");
                final String customName = result.getString("custom_name");

                return new GroupBean(id, permLevel, name, frenchName, customName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
