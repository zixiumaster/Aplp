package xyz.zixiu.aplp.Service.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.zixiu.aplp.Service.User.Interface.AdminService;
import xyz.zixiu.aplp.Service.User.Interface.StudentService;
import xyz.zixiu.aplp.Service.User.Interface.TeacherService;

public class UserService {
    public StudentService studentService;
    public TeacherService teacherService;
    public AdminService adminService;

    public UserService(){
        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        studentService = (StudentService)ac_User.getBean("StudentService");
        teacherService = (TeacherService)ac_User.getBean("TeacherService");
        adminService =(AdminService) ac_User.getBean("AdminService");
    }

}
