package test;

import GetReady.GetReadyServices;
import org.junit.Test;
import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Service.UserService;

public class mb_test {

    GetReadyServices ser = new GetReadyServices();
    UserService us=new UserService();

    String a="5";
    String b="6";
    @Test
    public void test() throws Exception{
        Test_02();
        Test_01();
    }

    public void Test_02() {

        ser.d.chack();
        ser.s.register(new SignBean("Student","email",null,a));
        ser.t.register(new SignBean("Teacher","email",null,a));
        ser.a.register(new SignBean("Teacher","email",null,a));
    }

    public void Test_01(){
        us.stu.register(new SignBean("Student","email",null,b));
        us.tea.register(new SignBean("Teacher","email",null,b));
        us.adm.register(new SignBean("Teacher","email",null,b));
    }

    public void Test_0(){}

}
