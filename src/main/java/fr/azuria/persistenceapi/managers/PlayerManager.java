package fr.azuria.persistenceapi.managers;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.PlayerBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class PlayerManager {

    private DataService dataService;

    public PlayerManager(DataService dataService) {
        this.dataService = dataService;
    }

    public PlayerBean loadPlayer(UUID uuid) {
        try (Connection connection = this.dataService.getDatabaseManager().getConnection()) {
            final String sql = "SELECT * FROM players WHERE uuid = ?";

            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uuid.toString());

            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final int coins = resultSet.getInt("coins");
                final Date lastConnection = resultSet.getDate("last_connection");
                final Date firstConnection = resultSet.getDate("first_connection");
                final int groupId = resultSet.getInt("group_id");

                return new PlayerBean(uuid, coins, lastConnection, firstConnection, groupId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
