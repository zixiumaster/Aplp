package xyz.zixiu.aplp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Sign")
public class Sign {

    @RequestMapping("/welcome")
    public String welcome(){
        return "Login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){

         return null;
    }
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        System.out.println("\n\ngoLogin\n\n");
        return "Html/Sign/Login.html";
    }

    @RequestMapping("/goRegister")
    public String goRegister(){
        System.out.println("\n\ngoRegister\n\n");
        return "Html/Sign/Register.html";
    }


}
