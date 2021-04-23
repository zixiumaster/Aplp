package xyz.zixiu.aplp.Service.User.Interface;

import org.springframework.stereotype.Repository;
import xyz.zixiu.aplp.Bean.User.SignBean;

@Repository
public interface TeacherService {

    public Boolean register(SignBean bean);

    public Boolean login(SignBean sign);



}