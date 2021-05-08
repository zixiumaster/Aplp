package xyz.zixiu.aplp.Bean.User;

public class SignBean extends UserBean {

    //角色
    private String role;

    //id类型
    private String basis;

    //放置一些附属信息
    private String attachment;

    //注册Sign reg
    public SignBean(String regRole,String regBasis,String regId,String regPassword){
        this.role=regRole;
        this.basis=regBasis;
        this.id=regId;
        this.password=regPassword;
        basisID();
    }

    public SignBean(){}

    public void setAdminBean(AdminBean user){
        this.id =user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.phone= user.getPhone();
        this.password=user.getPassword();
    }
    public void setStudentBean(StudentBean user){
        this.id =user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.phone= user.getPhone();
        this.password=user.getPassword();
    }
    public void setTeacherBean(TeacherBean user){
        this.id =user.getId();
        this.name=user.getName();
        this.email=user.getEmail();
        this.phone= user.getPhone();
        this.password=user.getPassword();
    }

    @Override
    public String toString() {
        return "SignBean{" +
                "role='" + role + '\'' +
                ", basis='" + basis + '\'' +
                ", attachment='" + attachment + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }


}
