package xyz.zixiu.aplp.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Service.User.Impl.StudentServiceImpl;
import xyz.zixiu.aplp.Service.User.Interface.AdminService;
import xyz.zixiu.aplp.Service.User.Interface.StudentService;
import xyz.zixiu.aplp.Service.User.Interface.TeacherService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Sign")
public class Sign {




    @RequestMapping("/goLogin")
    public String goLogin(){
        System.out.println("\n\ngoLogin\n\n");

        StudentService s;
        TeacherService t;
        AdminService a;
        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        s = (StudentService)ac_User.getBean("StudentService");
        t = (TeacherService)ac_User.getBean("TeacherService");
        a =(AdminService) ac_User.getBean("AdminService");
        s.register(new SignBean("Student","email",null,"qwertyuik"));
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
        System.out.println(user.toString());
        String a="01";
       // studentService.register(new SignBean("Student","email",null,a));
        try {
            if (user.getRole() == null) {
                return "no";
            } else if (user.getRole().equals("Admin")) {
                return "no";
            } else if (user.getRole().equals("Teacher")) {

                return "yes";
            } else if (user.getRole().equals("Student")) {

                return "yes";
            } else {
                return "no";
            }
        } catch (Exception e) {
            return "no";
        }
    }

}
