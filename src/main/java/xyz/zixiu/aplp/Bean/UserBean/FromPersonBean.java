package xyz.zixiu.aplp.Bean.UserBean;

import xyz.zixiu.aplp.Entity.SignEntity;

/**
 * 个人信息表单
 * @see #signrole   验证身份
 * @see #signId     验证ID
 * @see #signbasis  验证id格式
 * @see #signPassword   验证密码
 */
public class FromPersonBean {

    private String signrole;
    private String signbasis;
    private String signId;
    private String signPassword;

    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;


    public FromPersonBean() {
    }

    public FromPersonBean(String signrole, String signbasis, String signId, String signPassword, String id, String name, String phone, String email, String password) {
        this.signrole = signrole;
        this.signbasis = signbasis;
        this.signId = signId;
        this.signPassword = signPassword;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getSignrole() {
        return signrole;
    }

    public void setSignrole(String signrole) {
        this.signrole = signrole;
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId;
    }

    public String getSignPassword() {
        return signPassword;
    }

    public void setSignPassword(String signPassword) {
        this.signPassword = signPassword;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignbasis() {
        return signbasis;
    }

    public void setSignbasis(String signbasis) {
        this.signbasis = signbasis;
    }

    public SignEntity getSignEntity(){
        return new SignEntity(this.signbasis,this.signId,this.signPassword);
    }

    @Override
    public String toString() {
        return "FromPersonBean{" +
                "signrole='" + signrole + '\'' +
                ", signbasis='" + signbasis + '\'' +
                ", signId='" + signId + '\'' +
                ", signPassword='" + signPassword + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}