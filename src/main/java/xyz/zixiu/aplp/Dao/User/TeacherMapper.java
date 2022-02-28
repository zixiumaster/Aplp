package xyz.zixiu.aplp.Dao.User;

import org.apache.ibatis.annotations.Param;
import xyz.zixiu.aplp.Entity.*;

import java.util.List;

public interface TeacherMapper {

    public void signUpTeacher(SignEntity signEntity);

    public ReadTeacherEntity signInTeacher(SignEntity signEntity);

    public void updateTeacher(UpdateTeacherEntity updateTeacherEntity);

    public void deleteTeacher(SignEntity signEntity);

    public List<ReadTeacherEntity> selectTeacherByDepartmentId(@Param("departmentId") String departmentId);

}