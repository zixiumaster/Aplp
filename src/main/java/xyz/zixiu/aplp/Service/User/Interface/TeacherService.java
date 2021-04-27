package xyz.zixiu.aplp.Service.User.Interface;

import org.springframework.stereotype.Repository;
import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Bean.User.TeacherBean;

@Repository
public interface TeacherService {

    public Boolean register(SignBean bean);

    public TeacherBean login(SignBean sign);



}