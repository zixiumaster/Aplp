package xyz.zixiu.aplp.Entity;

import xyz.zixiu.aplp.Bean.UserBean.FromPersonBean;

public class UpdateTeacherEntity extends ReadTeacherEntity {

    private String signBasis;

    private String signId;

    private String signPassword;

    public String getSignBasis() {
        return signBasis;
    }

    public void setSignBasis(String signBasis) {
        this.signBasis = signBasis;
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

    public UpdateTeacherEntity(String id, String name, String phone, String email, String password, String department, String signBasis, String signId, String signPassword) {
        super(id, name, phone, email, password, department);
        this.signBasis = signBasis;
        this.signId = signId;
        this.signPassword = signPassword;
    }

    public UpdateTeacherEntity() {
    }

    @Override
    public String toString() {
        return "UpdateTeacherEntity{" +
                "signBasis='" + signBasis + '\'' +
                ", signId='" + signId + '\'' +
                ", signPassword='" + signPassword + '\'' +
                super.toString()+
                '}';
    }

    public void setFromPersonBean(FromPersonBean from){
        this.signBasis=from.getSignbasis();
        this.signId= from.getSignId();
        this.signPassword= from.getSignPassword();
        super.setId(from.getId());
        super.setName(from.getName());
        super.setEmail(from.getEmail());
        super.setPhone(from.getPhone());
        super.setPassword(from.getPassword());

    }

    public void setUpdateTeacherEntity(ReadTeacherEntity read) {
        super.setId(read.getId());
        super.setName(read.getName());
        super.setEmail(read.getEmail());
        super.setPhone(read.getPhone());
        super.setPassword(read.getPassword());
        super.setDepartment(read.getDepartment());
    }


}
