package test;

import GetReady.GetReadyServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import xyz.zixiu.aplp.Bean.User.Sign;

public class mb_test {

    GetReadyServices ser = new GetReadyServices();

    @Test
    public void test() throws Exception{

    }

    public void Test_02(){
        ser.db.chack();
    }

    public void Test_01(){
        ser.stu.login(new Sign("123","123","123"));
        ser.tea.login(new Sign("123","123","123"));
    }

    public void Test_0(){}

}
