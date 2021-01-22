package xyz.zixiu.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
class test_Controller {

    @RequestMapping("/t1")
    public String t1(){
        System.out.println("sssssssssssssssssssssssssssssssssss");
        return "test";
    }
}
