package xyz.zixiu.aplp.Dao.User;

import xyz.zixiu.aplp.Bean.User.Sign;
import xyz.zixiu.aplp.Bean.User.Student;

public interface StudentMapper {

    public void saveStudent(Student bean);

    public Student selectStudentBySign(Sign sign);


}