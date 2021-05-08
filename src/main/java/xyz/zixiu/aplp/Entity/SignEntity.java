package xyz.zixiu.aplp.Entity;

/**
 * 签名类，登录、注册、注销时,用于Service与Dao交互
 * @see #basis      方式（ID，Phone，Email）
 * @see #id         凭证（可能是ID、Phone、Email三种方式的一种，具体要根据basis属性判断）
 * @see #password   密码
 */
public class SignEntity {

    private String basis;

    private String id;

    private String password;

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignEntity{" +
                "basis='" + basis + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public SignEntity() {
    }

    public SignEntity(String basis, String id, String password) {
        this.basis = basis;
        this.id = id;
        this.password = password;
    }
}
