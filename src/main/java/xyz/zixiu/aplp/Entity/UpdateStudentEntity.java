package xyz.zixiu.aplp.Entity;

import xyz.zixiu.aplp.Bean.UserBean.FromPersonBean;

public class UpdateStudentEntity extends ReadStudentEntity {

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

    public UpdateStudentEntity(String id, String name, String phone, String email, String password, String department, String classe, String signBasis, String signId, String signPassword) {
        super(id, name, phone, email, password, department, classe);
        this.signBasis = signBasis;
        this.signId = signId;
        this.signPassword = signPassword;
    }

    public UpdateStudentEntity() {
    }

    @Override
    public String toString() {
        return "UpdateStudentEntity{" +
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

    public void setUpdateStudentEntity(ReadStudentEntity read) {
        super.setId(read.getId());
        super.setName(read.getName());
        super.setEmail(read.getEmail());
        super.setPhone(read.getPhone());
        super.setPassword(read.getPassword());
        super.setDepartment(read.getDepartment());
        super.setClasse(read.getClasse());
    }

}
