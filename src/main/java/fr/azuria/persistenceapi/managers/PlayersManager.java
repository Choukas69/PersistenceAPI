package fr.azuria.persistenceapi.managers;

import fr.azuria.persistenceapi.DataService;
import fr.azuria.persistenceapi.beans.PlayerBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class PlayersManager {

    private final DataService dataService;

    private static final PlayerBean DEFAULT_BEAN = new PlayerBean(UUID.randomUUID(), 50, Date.from(Instant.now()), Date.from(Instant.now()), 1);

    public PlayersManager(DataService dataService) {
        this.dataService = dataService;
    }

    public PlayerBean loadPlayer(UUID uuid) {
        try (Connection connection = this.dataService.getDatabaseManager().getConnection()) {
            final String SQL = "SELECT * FROM players WHERE uuid = ?";

            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, uuid.toString());

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                final int coins = result.getInt("coins");
                final Date lastConnection = result.getDate("last_connection");
                final Date firstConnection = result.getDate("first_connection");
                final int groupId = result.getInt("groupId_id");

                return new PlayerBean(uuid, coins, lastConnection, firstConnection, groupId);
            } else {
                return this.registerPlayer(uuid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private PlayerBean registerPlayer(UUID uuid) {
        try (Connection connection = this.dataService.getDatabaseManager().getConnection()) {
            final PlayerBean bean = (PlayerBean) DEFAULT_BEAN.clone();

            final String SQL = "INSERT INTO players(uuid, coins, last_connection, first_connection, group_id) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, uuid.toString());
            statement.setInt(2, bean.getCoins());
            statement.setDate(3, new java.sql.Date(bean.getLastConnection().getTime()));
            statement.setDate(4, new java.sql.Date(bean.getFirstConnection().getTime()));
            statement.setInt(5, bean.getGroupId());

            statement.executeUpdate();

            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
