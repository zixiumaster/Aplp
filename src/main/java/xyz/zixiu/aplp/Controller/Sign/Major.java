package xyz.zixiu.aplp.Controller.Sign;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.zixiu.aplp.Bean.UserBean.FromPersonBean;
import xyz.zixiu.aplp.Bean.UserBean.FromSchoolBean;
import xyz.zixiu.aplp.Service.User.Interface.UserInformationService;

@CrossOrigin
@Controller
@RequestMapping("/Major")
public class Major {

    private UserInformationService userInformationService;

    @RequestMapping("/goMajor")
    public String goMajor(){
        System.out.println("\n\ngoMajor ok\n\n");
        return "jsp/Main/Index.jsp";
    }

    @RequestMapping("/toFromPerson")
    public @ResponseBody
    String toFromPerson(@RequestBody FromPersonBean fromPersonBean){

        System.out.println(fromPersonBean.toString());
        if(userInformationService.updeteUser(fromPersonBean)){

            return "yes";
        }else{
            return "no";
        }

    }

    @RequestMapping("/toFromSchool")
    public @ResponseBody
    Boolean toFromSchoolBean(@RequestBody FromSchoolBean fromSchoolBean){
        System.out.println(fromSchoolBean.toString());
        return userInformationService.updeteUser(fromSchoolBean);
    }


    public Major() {
        System.out.println("public Major()");
        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        userInformationService = (UserInformationService)ac_User.getBean("UserInformationService");
    }

}