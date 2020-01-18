package fr.azuria.persistenceapi.beans;

import java.util.Date;
import java.util.UUID;

public class PlayerBean implements Cloneable {

    private UUID uuid;
    private int coins;
    private Date lastConnection;
    private Date firstConnection;
    private int groupId;

    public PlayerBean(UUID uuid, int coins, Date lastConnection, Date firstConnection, int groupId) {
        this.uuid = uuid;
        this.coins = coins;
        this.lastConnection = lastConnection;
        this.firstConnection = firstConnection;
        this.groupId = groupId;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Date getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(Date lastConnection) {
        this.lastConnection = lastConnection;
    }

    public Date getFirstConnection() {
        return firstConnection;
    }

    public void setFirstConnection(Date firstConnection) {
        this.firstConnection = firstConnection;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
