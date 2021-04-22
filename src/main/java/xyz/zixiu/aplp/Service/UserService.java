package xyz.zixiu.aplp.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.zixiu.aplp.Service.User.Interface.AdminService;
import xyz.zixiu.aplp.Service.User.Interface.StudentService;
import xyz.zixiu.aplp.Service.User.Interface.TeacherService;

public class UserService {
    public StudentService stu;
    public TeacherService tea;
    public AdminService adm;

    public UserService(){
        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        stu = (StudentService) ac_User.getBean("StudentService");
        tea = (TeacherService) ac_User.getBean("TeacherService");
        adm = (AdminService) ac_User.getBean("AdminService");
    }


}
