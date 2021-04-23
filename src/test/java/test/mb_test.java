package test;

import GetReady.GetReadyServices;
import org.junit.Test;
import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Bean.User.UserBean;
import xyz.zixiu.aplp.Service.User.Impl.StudentServiceImpl;
import xyz.zixiu.aplp.Service.User.Interface.StudentService;

import javax.annotation.Resource;

public class mb_test {

    GetReadyServices ser = new GetReadyServices();
   // UserService us=new UserService();

    String a="11";
    String b="12";
    @Test
    public void test() throws Exception{
    }

    public void Test_02() {

        ser.s.register(new SignBean("Student","email",null,"test1"));
        ser.t.register(new SignBean("Teacher","email",null,a));
        ser.a.register(new SignBean("Teacher","email",null,a));
    }

    public void Test_01(){
//        us.stu.register(new SignBean("Student","email",null,b));
//        us.tea.register(new SignBean("Teacher","email",null,b));
//        us.adm.register(new SignBean("Teacher","email",null,b));
    }





}
