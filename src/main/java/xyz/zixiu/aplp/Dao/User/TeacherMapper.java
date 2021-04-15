package xyz.zixiu.aplp.Dao.User;

import xyz.zixiu.aplp.Bean.User.Sign;
import xyz.zixiu.aplp.Bean.User.Student;
import xyz.zixiu.aplp.Bean.User.Teacher;

public interface TeacherMapper {

    public void saveTeacher(Teacher bean);

    public Teacher selectTeacherBySign(Sign sign);


}