package xyz.zixiu.aplp.Entity;

import xyz.zixiu.aplp.Bean.UserBean.FromPersonBean;

/**
 * 继承了父类的 id;name;phone;email;password;
 */
public class UpdateAdministratorEntity extends ReadAdministratorEntity {

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

    public UpdateAdministratorEntity(String id, String name, String phone, String email, String password, String signBasis, String signId, String signPassword) {
        super(id, name, phone, email, password);
        this.signBasis = signBasis;
        this.signId = signId;
        this.signPassword = signPassword;
    }

    public UpdateAdministratorEntity() {

    }

    @Override
    public String toString() {
        return "UpdateAdministratorEntity{" +
                "signBasis='" + signBasis + '\'' +
                ", signId='" + signId + '\'' +
                ", signPassword='" + signPassword + '\'' +
                super.toString()+
                '}';
    }

    public void setUpdateAdministratorEntity(ReadAdministratorEntity read) throws Exception {
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
        }
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

}
