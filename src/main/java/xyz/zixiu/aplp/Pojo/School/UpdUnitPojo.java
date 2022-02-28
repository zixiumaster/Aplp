package xyz.zixiu.aplp.Pojo.School;

public class UpdUnitPojo {

    private String role;

    private String parent;

    private String oldId;

    private String newId;

    private String newName;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public String toString() {
        return "UpdUnitPojo{" +
                "role='" + role + '\'' +
                ", parent='" + parent + '\'' +
                ", oldId='" + oldId + '\'' +
                ", newId='" + newId + '\'' +
                ", newName='" + newName + '\'' +
                '}';
    }

    public UpdUnitPojo() {
    }

    public UpdUnitPojo(String role, String parent, String oldId, String newId, String newName) {
        this.role = role;
        this.parent = parent;
        this.oldId = oldId;
        this.newId = newId;
        this.newName = newName;
    }
}
