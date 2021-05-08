package xyz.zixiu.aplp.Bean.User;

public class UserBean {
    protected String id;
    protected String name;
    protected String phone;
    protected String email;
    protected String password;

    public UserBean(String id, String name, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public UserBean(AdminBean user){
        this.id =user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.phone= user.getPhone();
    }
    public UserBean(TeacherBean user){
        this.id =user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.phone= user.getPhone();
    }
    public UserBean(StudentBean user){
        this.id =user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.phone= user.getPhone();
    }

    public UserBean() { }

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

    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
