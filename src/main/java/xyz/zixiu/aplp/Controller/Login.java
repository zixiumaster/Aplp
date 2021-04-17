package xyz.zixiu.aplp.Controller;

import org.apache.tools.ant.taskdefs.email.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.zixiu.aplp.Bean.User.Sign;


@Controller
@RequestMapping("/Login")
public class Login {

    @RequestMapping("/stu")
    public  String stu(@RequestBody Sign jsonString){

        System.out.println(jsonString.toString());

        return null;
    }

    @RequestMapping("/test")
    public String test(@RequestBody String user){
        System.out.println(user);
        return user;
    }

    @RequestMapping("/zixiu")
    public String zixiu(){
        return "zixiu";
    }

}
