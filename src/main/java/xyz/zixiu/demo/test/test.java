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
        System.out.println("mybatis-spring整合，有mapper类实现方式");
        //01.加载spring配置
        ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext.xml");

        bean_test_service service = (bean_test_service)ac.getBean("bean_test_service");

        service.save_bean_test(new bean_test(888,"test_02","test_02"));
        
//        运行结果为：
//            抛出错误，数据库未写入记录
//        @Override
//        public void save_bean_test(bean_test bean) {
//            Mapper.save_bean_test(bean);
//            int i=100/0;
//            Mapper.save_bean_test(bean);
//        }
//        因为开启了事物管理，所以ServiceImpl里的代码出错时，整个方法都放弃执行
        
    }
}