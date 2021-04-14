package xyz.zixiu.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.zixiu.demo.bean.bean_test;
import xyz.zixiu.demo.service.bean_test_service;


public class test {
    @Test
    public void test() throws Exception{
        System.out.println("test_01");
        //01.加载spring配置
//        ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext.xml");
//        bean_test_service service = (bean_test_service)ac.getBean("bean_test_service");
//        service.save_bean_test(new bean_test(999,"test_02","test_02"));

        ApplicationContext ac1 = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext.xml");
        bean_test_service t =(bean_test_service) ac1.getBean("bean_test_service");
        t.save_bean_test(new bean_test(123,"123","123"));

    }
}