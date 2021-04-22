package GetReady;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.zixiu.aplp.Service.DB.DBService;
import xyz.zixiu.aplp.Service.User.Interface.AdminService;
import xyz.zixiu.aplp.Service.User.Interface.StudentService;
import xyz.zixiu.aplp.Service.User.Interface.TeacherService;

public class GetReadyServices {

    public StudentService s;

    public TeacherService t;
    public AdminService a;
    public DBService d;

    public GetReadyServices(){

        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        s = (StudentService)ac_User.getBean("StudentService");
        t = (TeacherService)ac_User.getBean("TeacherService");
        a =(AdminService) ac_User.getBean("AdminService");

        ApplicationContext ac_DB = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-DB.xml");
        d = (DBService) ac_DB.getBean("DBService");

    }





}
