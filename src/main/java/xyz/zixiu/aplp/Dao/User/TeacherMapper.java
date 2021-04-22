package xyz.zixiu.aplp.Dao.User;

import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Bean.User.TeacherBean;

public interface TeacherMapper {

    public void saveTeacher(SignBean bean);

    public  TeacherBean selectTeacherBySign(SignBean sign);


}