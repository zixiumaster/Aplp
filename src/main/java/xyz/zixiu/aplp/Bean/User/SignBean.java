package xyz.zixiu.aplp.Bean.User;

public class SignBean extends UserBean {

    //角色
    private String role;

    //id类型
    private String basis;

    //注册Sign reg
    public SignBean(String regRole,String regBasis,String regId,String regPassword){
        this.role=regRole;
        this.basis=regBasis;
        this.id=regId;
        this.password=regPassword;
        basisID();
    }

    public SignBean(){}

    public void basisID(){

        if( ( basis != "" && basis != null ) && ( id != "" && id != null ) ){
            switch (basis){
                case "id":
                    break;
                case "phone":
                    phone=id;
                    id=null;
                    break;
                case "email":
                    email=id;
                    id=null;
                    break;
                default:
                    break;
            }
        }

    }

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


    @Override
    public String toString() {
        return "SignBean{" +
                "role='" + role + '\'' +
                ", basis='" + basis + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
