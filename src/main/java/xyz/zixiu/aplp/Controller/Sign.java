package xyz.zixiu.aplp.Controller;

import com.alibaba.nacos.api.exception.NacosException;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import xyz.apps.NacosDiscovery;
import xyz.zixiu.aplp.Bean.User.AdminBean;
import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Bean.User.StudentBean;
import xyz.zixiu.aplp.Bean.User.TeacherBean;
import xyz.zixiu.aplp.Service.User.UserService;

@Controller
@RequestMapping("/Sign")
public class Sign {

    UserService us=new UserService();



    @RequestMapping("/godoc")
    public String godoc(){
        System.out.println("\n\ngoRegister\n\n");
        return "Html/Main/ww.doc";
    }

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
        System.out.println(user.toString());

        try {
            if (user.getRole() == null || user.getId() == null ||  user.getPassword() == null) {
                return "no";
            } else if (user.getRole().equals("Admin")) {
                return "no";
            } else if (user.getRole().equals("Teacher")) {
                us.teacherService.register(user);
                return "yes";
            } else if (user.getRole().equals("Student")) {
                us.studentService.register(user);
                return "yes";
            } else {
                return "no";
            }
        } catch (Exception e) {
            System.err.println(e);
            return "no";
        }
    }

    @RequestMapping("/toLogin")
    public @ResponseBody
    SignBean toLogin(@RequestBody SignBean user) {

        System.out.println(user.toString());

        try {
            if (user.getRole() == null) {
                return null;
            } else if (user.getRole().equals("Admin")) {
                 AdminBean bean = us.adminService.login(user);
                 if( bean!=null ){
                     user.setAdminBean(bean);
                     return user;
                 }else{
                     return null;
                 }
            } else if (user.getRole().equals("Teacher")) {
                TeacherBean bean = us.teacherService.login(user);
                if( bean!=null ){
                    user.setTeacherBean(bean);
                    return user;
                }else{
                    return null;
                }
            } else if (user.getRole().equals("Student")) {
                StudentBean bean = us.studentService.login(user);
                if( bean!=null ){
                    user.setStudentBean(bean);
                    return user;
                }else{
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

}