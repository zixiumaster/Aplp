package xyz.zixiu.aplp.Service.User.Interface;

import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Bean.User.StudentBean;

public interface StudentService {

    public Boolean register(SignBean bean);

    public StudentBean login(SignBean sign);

    public boolean updateperson(SignBean sign);

    public boolean updatepassword(SignBean sign);

}