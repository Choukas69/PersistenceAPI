package fr.azuria.persistenceapi.managers;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.GroupBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupsManager {

    private final DataService dataService;

    public GroupsManager(DataService dataService) {
        this.dataService = dataService;
    }

    public ArrayList<GroupBean> loadGroups() {
        try (Connection connection = dataService.getDatabaseManager().getConnection()) {
            final String SQL = "SELECT * FROM `groups`";

            PreparedStatement statement = connection.prepareStatement(SQL);

            ResultSet result = statement.executeQuery();

            ArrayList<GroupBean> groups = new ArrayList<>();

            while (result.next()) {
                final int id = result.getInt("id");
                final String name = result.getString("name");
                final String tag = result.getString("tag");

                groups.add(new GroupBean(id, name, tag));
            }

            return groups;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
