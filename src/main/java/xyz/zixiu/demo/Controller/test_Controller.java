package xyz.zixiu.demo.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
class test_Controller {

    @RequestMapping("/t1")
    public String t1(){

        System.out.println("sssssssssssssssssssssssssssssssssss");

        ApplicationContext ac = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("ggggggggggggggggggggggggggggg");

//        bean_test_service service = (bean_test_service)ac.getBean("bean_test_service");
//
//        System.out.println("ggggggggggggggggggggggggggggg");
//
//        service.save_bean_test(new bean_test(999,"test_02","test_02"));


        return "test";


    }
}
