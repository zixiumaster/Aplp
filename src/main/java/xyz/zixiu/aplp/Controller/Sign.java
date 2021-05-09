package xyz.zixiu.aplp.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.zixiu.aplp.Bean.UserBean.ClientBean;
import xyz.zixiu.aplp.Bean.UserBean.SignBean;
import xyz.zixiu.aplp.Entity.SignEntity;
import xyz.zixiu.aplp.Service.User.Interface.UserInformationService;

@Controller
@RequestMapping("/Sign")
public class Sign {

    private UserInformationService userInformationService;

    @RequestMapping("/goLogin")
    public String goLogin(){

        //请求地址
//        String url = "http://127.0.0.1:38800/App/Version";
//
//        RestTemplate restTemplate = new RestTemplate();
//        String s = restTemplate.postForObject(url,null, String.class);
//        System.out.println(s);
//
//        url = "http://127.0.0.1:38800/App/sss";
//
//        TestBean testBean=new TestBean();
//        testBean.setName("12341");
//        testBean.setPwd("sdfgh");
//
//        testBean = restTemplate.postForObject(url,testBean, TestBean.class);
//
//        System.out.println( testBean.toString());


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

//        try {
            if (userInformationService.signUpUser(user)){
                return "yes";
            }else{
                return "no";
            }
//        } catch (Exception e) {
//            System.err.println(e);
//            return "no";
//        }
    }

    @RequestMapping("/toLogin")
    public @ResponseBody
    ClientBean toLogin(@RequestBody SignBean user) {
        System.out.println(user.toString());
        return userInformationService.signIn(user);
    }

    public Sign(){
        System.out.println("public Sign()");
        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        userInformationService = (UserInformationService)ac_User.getBean("UserInformationService");
    }
}