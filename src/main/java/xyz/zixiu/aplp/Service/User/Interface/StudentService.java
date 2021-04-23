package xyz.zixiu.aplp.Service.User.Interface;

import xyz.zixiu.aplp.Bean.User.SignBean;

public interface StudentService {

    public Boolean register(SignBean bean);

    public Boolean login(SignBean sign);


}