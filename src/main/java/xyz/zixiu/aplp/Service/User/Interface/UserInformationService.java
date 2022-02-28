package xyz.zixiu.aplp.Service.User.Interface;

import xyz.zixiu.aplp.Bean.UserBean.ClientBean;
import xyz.zixiu.aplp.Bean.UserBean.FromPersonBean;
import xyz.zixiu.aplp.Bean.UserBean.FromSchoolBean;
import xyz.zixiu.aplp.Bean.UserBean.SignBean;
import xyz.zixiu.aplp.Entity.*;

import java.util.List;

/**
 * @see #signUpUser(SignBean signBean)     用于教师和学生注册，可以根据参数signBean.role来判断用户身份，返回布尔值
 * @see #deleteUser(SignBean signBean)     用于用户注销，可以根据参数signBean.role来判断用户身份，返回布尔值
 * @see #signIn(SignBean)                  用于用户登录，返回操作对象的全部信息
 *
 * @see #updeteUser(UpdateAdministratorEntity)  用于用户更新信息，重载方法，可以根据参数自行判断用户身份，返回布尔值
 * @see #updateUser(UpdateStudentEntity)
 * @see #updeteUser(UpdateTeacherEntity)
 * @see #updeteUser(FromSchoolBean)     用于更新教师和学生的院系的班级信息
 *
 * @see #signUpAdministrator(SignBean)    用于管理员注册,需要一个管理员账号的验证
 */
public interface UserInformationService {

    public ClientBean signIn(SignBean signBean);

    public Boolean signUpUser(SignBean signBean);

    public Boolean deleteUser(SignBean signBean);

    public Boolean updeteUser(FromSchoolBean fromSchoolBean);

    public Boolean updeteUser(FromPersonBean fromPersonBean);

    public Boolean signUpAdministrator(SignBean newSignBean);

    public Boolean updeteUser(UpdateAdministratorEntity updateAdministratorEntity);

    public Boolean updeteUser(UpdateTeacherEntity updateTeacherEntity);

    public Boolean updateUser(UpdateStudentEntity updateStudentEntity);

    public ClientBean signInAdministrator(SignBean signBean);

    public ClientBean signInStudent(SignBean signBean);

    public ClientBean signInTeacher(SignBean signBean);

    public List<String> getTeacherList(String departmentId);

}
