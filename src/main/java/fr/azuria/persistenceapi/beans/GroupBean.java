package fr.azuria.persistenceapi.beans;

public class GroupBean {

    private int id;
    private String name;
    private String tag;

    public GroupBean(int id, String name, String tag) {
        this.id = id;
        this.name = name;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCustomName() {
        return tag;
    }
}
