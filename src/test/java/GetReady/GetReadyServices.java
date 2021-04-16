package GetReady;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.zixiu.aplp.Service.DB.DBService;
import xyz.zixiu.aplp.Service.User.StudentService;
import xyz.zixiu.aplp.Service.User.TeacherService;

public class GetReadyServices {

    public StudentService stu;
    public TeacherService tea;
    public DBService db;

    public GetReadyServices(){

        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        stu = (StudentService) ac_User.getBean("StudentService");
        tea = (TeacherService) ac_User.getBean("TeacherService");

        ApplicationContext ac_DB = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-DB.xml");
        db = (DBService) ac_DB.getBean("DBService");

    }





}
