package fr.azuria.persistenceapi.beans;

public class GroupBean {

    private int id;
    private int permLevel;
    private String name;
    private String frenchName;
    private String customName;

    public GroupBean(int id, int permLevel, String name, String frenchName, String customName) {
        this.id = id;
        this.permLevel = permLevel;
        this.name = name;
        this.frenchName = frenchName;
        this.customName = customName;
    }

    public int getId() {
        return id;
    }

    public int getPermLevel() {
        return permLevel;
    }

    public String getName() {
        return name;
    }

    public String getFrenchName() {
        return frenchName;
    }

    public String getCustomName() {
        return customName;
    }
}
