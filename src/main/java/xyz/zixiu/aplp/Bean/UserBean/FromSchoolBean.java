package xyz.zixiu.aplp.Bean.UserBean;

import xyz.zixiu.aplp.Entity.SignEntity;

/**
 * 个人院系班级信息表单
 * @see #signrole   验证身份
 * @see #signId     验证ID
 * @see #signbasis  验证id格式
 * @see #signPassword   验证密码
 */
public class FromSchoolBean {

    private String signrole;
    private String signbasis;
    private String signId;
    private String signPassword;

    private String department;
    private String classe;


    public SignEntity getSignEntity(){
        return new SignEntity(this.signbasis,this.signId,this.signPassword);
    }

    @Override
    public String toString() {
        return "FromSchoolBean{" +
                "signrole='" + signrole + '\'' +
                ", signbasis='" + signbasis + '\'' +
                ", signId='" + signId + '\'' +
                ", signPassword='" + signPassword + '\'' +
                ", department='" + department + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }

    public String getSignrole() {
        return signrole;
    }

    public void setSignrole(String signrole) {
        this.signrole = signrole;
    }

    public String getSignbasis() {
        return signbasis;
    }

    public void setSignbasis(String signbasis) {
        this.signbasis = signbasis;
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

    public FromSchoolBean() {
    }

    public FromSchoolBean(String signrole, String signbasis, String signId, String signPassword, String department, String classe) {
        this.signrole = signrole;
        this.signbasis = signbasis;
        this.signId = signId;
        this.signPassword = signPassword;
        this.department = department;
        this.classe = classe;
    }
}
