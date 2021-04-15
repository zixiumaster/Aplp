package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.zixiu.aplp.Bean.User.Sign;
import xyz.zixiu.aplp.Service.User.StudentService;
import xyz.zixiu.aplp.Service.User.TeacherService;

public class mb_test {

    StudentService studentService;
    TeacherService teacherService;

    @Test
    public void test() throws Exception{
        getReady();

        Test_01();

    }

    public void Test_02(){
       // dbService.build();
    }

    public void Test_01(){
        studentService.login(new Sign("123","123","123"));
        teacherService.login(new Sign("123","123","123"));
    }

    public void Test_0(){}

    public void getReady(){
        ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService=(StudentService)ac.getBean("StudentService");
        teacherService=(TeacherService)ac.getBean("TeacherService");
    }

}
