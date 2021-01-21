package xyz.zixiu.demo.bean;

public class bean_test {
    private int id;
    private String name;
    private String pwd;
    public bean_test(int id,String name,String pwd){
        setId(id);
        setName(name);
        setPwd(pwd);
    }
    public bean_test(){}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
