package xyz.zixiu.aplp.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
class test_Controller {


    @RequestMapping("/t1")
    public String t1(){

        System.out.println("\n\nsssssssssssssssssssssssssssssssssss\n\n");
                
        return "test";


    }
}
