package fr.azuria.persistenceapi.managers;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.GroupBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupManager {

    private DataService dataService;

    public GroupManager(DataService dataService) {
        this.dataService = dataService;
    }

    public GroupBean loadGroup(int id) {
        try (Connection connection = dataService.getDatabaseManager().getConnection()) {
            final String sql = "SELECT * FROM permissions WHERE group_id = ?";

            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            final ResultSet result = statement.executeQuery();

            final ArrayList<String> permissions = new ArrayList<>();
            while (result.next()) {
                permissions.add(result.getString("name"));
            }

            return new GroupBean(id, permissions);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
