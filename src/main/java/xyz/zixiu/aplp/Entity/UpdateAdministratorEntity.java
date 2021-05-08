package xyz.zixiu.aplp.Entity;

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
}
