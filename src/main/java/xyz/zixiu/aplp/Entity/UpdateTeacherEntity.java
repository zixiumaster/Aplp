package xyz.zixiu.aplp.Entity;

import xyz.zixiu.aplp.Bean.UserBean.FromPersonBean;
import xyz.zixiu.aplp.Bean.UserBean.FromSchoolBean;

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
                super.toString() +
                '}';
    }

    public void setFromPersonBean(FromPersonBean from) {
        this.signBasis = from.getSignbasis();
        this.signId = from.getSignId();
        this.signPassword = from.getSignPassword();
        super.setId(from.getId());
        super.setName(from.getName());
        super.setEmail(from.getEmail());
        super.setPhone(from.getPhone());
        //如果表单中的新密码为空，就把验证密码放进去
        if (from.getPassword() != null) {
            super.setPassword(from.getPassword());
        } else {
            super.setPassword(from.getSignPassword());
        }
    }

    public void setFromSchoolBean(FromSchoolBean bean) {
        this.signBasis = bean.getSignbasis();
        this.signId = bean.getSignId();
        this.signPassword = bean.getSignPassword();
        super.setDepartment(bean.getDepartment());
    }

    public void setUpdateTeacherEntity(ReadTeacherEntity read) throws Exception {
        try {
            super.setId(read.getId());
        } catch (Exception e) {

        }
        try {
            super.setName(read.getName());
        } catch (Exception e) {

        }
        try {
            super.setEmail(read.getEmail());
        } catch (Exception e) {

        }
        try {
            super.setPhone(read.getPhone());
        } catch (Exception e) {

        }
        try {
            super.setPassword(read.getPassword());
        } catch (Exception e) {

        }
        try {
            super.setDepartment(read.getDepartment());
        } catch (Exception e) {

        }
    }


}
