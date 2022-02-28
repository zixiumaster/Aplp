package xyz.zixiu.aplp.Pojo.School;

/**
 * 用于操作(新建,删除,更新)单位( Classe , Teacher , Department )
 * @see #role       身份:( Classe , Teacher , Department )
 * @see #parent     所属单位 : Department之ID,若role值为Department,则无意义
 * @see #id         操作单位ID
 * @see #name       操作单位名称:若role值为Teacher,则无意义 ,删除操作时无意义
 */
public class UnitPojo {

    private String role;

    private String parent;

    private String id;

    private String name;

    @Override
    public String toString() {
        return "UnitPojo{" +
                "role='" + role + '\'' +
                ", parent='" + parent + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public UnitPojo() {
    }

    public UnitPojo(String role, String parent, String id, String name) {
        this.role = role;
        this.parent = parent;
        this.id = id;
        this.name = name;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
