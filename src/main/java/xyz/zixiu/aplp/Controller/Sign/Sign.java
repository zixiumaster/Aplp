package xyz.zixiu.aplp.Controller.Sign;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.zixiu.aplp.Bean.UserBean.ClientBean;
import xyz.zixiu.aplp.Bean.UserBean.SignBean;
import xyz.zixiu.aplp.Entity.SignEntity;
import xyz.zixiu.aplp.Service.User.Interface.UserInformationService;

@CrossOrigin
@Controller
@RequestMapping("/Sign")
public class Sign {

    private UserInformationService userInformationService;

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

    @RequestMapping("/toRegister")
    public @ResponseBody
    String toRegister(@RequestBody SignBean user) {
        SignEntity signEntity = new SignEntity(user.getBasis(), user.getId(), user.getPassword());
        String role = user.getRole();
        System.out.println(user.toString());
        System.out.println(signEntity.toString());
        System.out.println(role);

            if (userInformationService.signUpUser(user)){
                return "yes";
            }else{
                return "no";
            }
    }

    @RequestMapping("/signUpAdministrator")
    public @ResponseBody
    String signUpAdministrator(@RequestBody SignBean newSignBean){
        if(userInformationService.signUpAdministrator(newSignBean)){
            return "yes";
        }else{
            return "no";
        }
    }


    @RequestMapping("/toLogin")
    public @ResponseBody
    ClientBean toLogin(@RequestBody SignBean user) {
        System.out.println(user.toString());
        ClientBean clientBean=userInformationService.signIn(user);
        System.out.println(clientBean.toString());
        return clientBean;
    }

    public Sign(){
        System.out.println("public Sign()");
        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        userInformationService = (UserInformationService)ac_User.getBean("UserInformationService");
    }
}