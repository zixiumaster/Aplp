package xyz.zixiu.aplp.Dao.User;

import xyz.zixiu.aplp.Entity.ReadStudentEntity;
import xyz.zixiu.aplp.Entity.SignEntity;
import xyz.zixiu.aplp.Entity.UpdateStudentEntity;

public interface StudentMapper {

    public void signUpStudent(SignEntity signEntity);

    public ReadStudentEntity signInStudent(SignEntity signEntity);

    public void updateStudent(UpdateStudentEntity updateStudentEntity);

    public void deleteStudent(SignEntity signEntity);

}