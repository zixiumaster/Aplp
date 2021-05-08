package xyz.zixiu.aplp.Dao.User;

import xyz.zixiu.aplp.Entity.*;

public interface TeacherMapper {

    public void signUpTeacher(SignEntity signEntity);

    public ReadTeacherEntity signInTeacher(SignEntity signEntity);

    public void updateTeacher(UpdateTeacherEntity updateTeacherEntity);

    public void deleteTeacher(SignEntity signEntity);

}