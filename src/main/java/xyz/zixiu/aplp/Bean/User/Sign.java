package xyz.zixiu.aplp.Bean.User;

public class Sign {

    private String role;
    private String basis;
    private String id;
    private String password;

    public Sign(String role, String basis, String id, String password){
        this.role = role;
        this.basis = basis;
        this.id = id;
        this.password = password;
    };

    public Sign(){
    };


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

}
