package xyz.zixiu.aplp.Bean.User;

public class Sign {
    private String basis;
    private String value;
    private String password;

    public Sign(String basis, String value, String password) {
        this.basis = basis;
        this.value =value;
        this.password = password;
    }

    public Sign(){};

    @Override
    public String toString() {
        return "Sign{" +
                "basis='" + basis + '\'' +
                ", value='" + value + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
