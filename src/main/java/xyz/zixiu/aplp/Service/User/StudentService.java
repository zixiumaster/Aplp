package xyz.zixiu.aplp.Service.User;

import org.springframework.stereotype.Repository;
import xyz.zixiu.aplp.Bean.User.Sign;
import xyz.zixiu.aplp.Bean.User.Student;

@Repository
public interface StudentService {

    public void register(Student bean);

    public Boolean login(Sign sign);


}