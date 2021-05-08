package xyz.zixiu.aplp.Bean.UserBean;

/**
 * 签名类，用于 登录/注册/注销
 * @see #role       身份 (教师，学生，管理员)
 * @see #basis      方式（ID，Phone，Email）
 * @see #id         凭证（可能是ID、Phone、Email三种方式的一种，具体要根据basis属性判断）
 * @see #password   密码
 */
public class SignBean {

    private String role;

    private String basis;

    private String id;

    private String password;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
        return "SignBean{" +
                "role='" + role + '\'' +
                ", basis='" + basis + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public SignBean(String role, String basis, String id, String password) {
        this.role = role;
        this.basis = basis;
        this.id = id;
        this.password = password;
    }

    public SignBean() {
    }
}
