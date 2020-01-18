package fr.azuria.persistenceapi.beans;

import java.util.ArrayList;

public class GroupBean {

    private int id;
    private ArrayList<String> permissions;

    public GroupBean(int id, ArrayList<String> permissions) {
        this.id = id;
        this.permissions = permissions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<String> permissions) {
        this.permissions = permissions;
    }
}
