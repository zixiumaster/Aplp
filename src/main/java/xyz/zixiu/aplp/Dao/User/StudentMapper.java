package xyz.zixiu.aplp.Dao.User;

import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Bean.User.StudentBean;

public interface StudentMapper {


    public void saveStudent(SignBean bean);

    public StudentBean selectStudentBySign(SignBean sign);


}