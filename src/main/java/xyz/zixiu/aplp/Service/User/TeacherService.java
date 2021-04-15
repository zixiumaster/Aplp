package xyz.zixiu.aplp.Service.User;

import org.springframework.stereotype.Repository;
import xyz.zixiu.aplp.Bean.User.Sign;
import xyz.zixiu.aplp.Bean.User.Teacher;

@Repository
public interface TeacherService {

    public void register(Teacher bean);

    public Boolean login(Sign sign);



}