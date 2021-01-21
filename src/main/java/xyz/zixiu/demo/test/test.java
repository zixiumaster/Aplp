package xyz.zixiu.demo.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.zixiu.demo.bean.bean_test;
import xyz.zixiu.demo.dao.bean_test_Mapper;


public class test {
    @Test
    public void test() throws Exception{
        System.out.println("test_01");
        System.out.println("mybatis-spring整合，有mapper类实现方式");
        //01.加载spring配置
        ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext.xml");

        //02.获取对象
        //getBean需要applicationCaontext.xml里面注入对象的id与之对应
        bean_test_Mapper bm =(bean_test_Mapper)ac.getBean("bean_test_mapper");

        //03.调用办法
        bm.save_bean_test(new bean_test(11,"test_02","test_02"));

    }
}
