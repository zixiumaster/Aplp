package xyz.zixiu.aplp.Entity;

import xyz.zixiu.aplp.Bean.UserBean.FromPersonBean;
import xyz.zixiu.aplp.Bean.UserBean.FromSchoolBean;

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
        //如果表单中的新密码为空，就把验证密码放进去
        if(from.getPassword()!=null){
            super.setPassword(from.getPassword());
        }else{
            super.setPassword(from.getSignPassword());
        }
    }

    public void setFromSchoolBean(FromSchoolBean bean){
        this.signBasis=bean.getSignbasis();
        this.signId=bean.getSignId();
        this.signPassword=bean.getSignPassword();

        super.setDepartment(bean.getDepartment());
        super.setClasse(bean.getClasse());
    }

    public void setUpdateStudentEntity(ReadStudentEntity read)  throws Exception {
        if(read.getId()!=null){
            super.setId(read.getId());
        }if (read.getName()!=null){
            super.setName(read.getName());
        }if (read.getEmail()!=null){
            super.setEmail(read.getEmail());
        }if (read.getPhone()!=null){
            super.setPhone(read.getPhone());
        }if (read.getPassword()!=null){
            super.setPassword(read.getPassword());
        } if (read.getDepartment()!=null){
            super.setDepartment(read.getDepartment());
        }if(read.getClasse()!=null){
            super.setClasse(read.getClasse());
        }
    }

}
