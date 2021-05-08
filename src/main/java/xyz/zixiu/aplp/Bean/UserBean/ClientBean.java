package xyz.zixiu.aplp.Bean.UserBean;

import xyz.zixiu.aplp.Entity.ReadAdministratorEntity;
import xyz.zixiu.aplp.Entity.ReadStudentEntity;
import xyz.zixiu.aplp.Entity.ReadTeacherEntity;

/**
 * 用于返回前端存入Cookie
 */
public class ClientBean {

    private String role;

    private String basis;

    private String id;

    private String name;

    private String phone;

    private String email;

    private String password;

    private String department;

    private String classe;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public ClientBean() {
    }

    @Override
    public String toString() {
        return "ClientBean{" +
                "role='" + role + '\'' +
                ", basis='" + basis + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }

    public ClientBean(SignBean signBean, ReadAdministratorEntity readEntity) {
        this.role = signBean.getRole();
        this.basis = signBean.getBasis();
        this.id = readEntity.getId();
        this.name = readEntity.getName();
        this.phone = readEntity.getPhone();
        this.email = readEntity.getEmail();
        this.password = readEntity.getPassword();
    }

    public ClientBean(SignBean signBean, ReadTeacherEntity readEntity) {
        this.role = signBean.getRole();
        this.basis = signBean.getBasis();
        this.id = readEntity.getId();
        this.name = readEntity.getName();
        this.phone = readEntity.getPhone();
        this.email = readEntity.getEmail();
        this.password = readEntity.getPassword();
        this.department = readEntity.getDepartment();
    }

    public ClientBean(SignBean signBean, ReadStudentEntity readEntity) {
        this.role = signBean.getRole();
        this.basis = signBean.getBasis();
        this.id = readEntity.getId();
        this.name = readEntity.getName();
        this.phone = readEntity.getPhone();
        this.email = readEntity.getEmail();
        this.password = readEntity.getPassword();
        this.department = readEntity.getDepartment();
        this.classe = readEntity.getClasse();
    }

}
