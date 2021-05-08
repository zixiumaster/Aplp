package xyz.zixiu.aplp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Major")
public class Major {

  //  UserService us=new UserService();

    @RequestMapping("/goMajor")
    public String goMajor(){
        System.out.println("\n\ngoMajor ok\n\n");
        return "jsp/Main/Index.jsp";
    }

//    @RequestMapping("/toFromPerson")
//    public @ResponseBody
//    String toFromPerson(@RequestBody SignBean user){
//        System.out.println(user.toString());
//        if (user.getRole()==null){
//            return "no";
//        }else if (user.getRole().equals("Admin")) {
//            if(us.adminService.updateperson(user)){
//                return "yes";
//            }else{
//                return "no";
//            }
//        } else if (user.getRole().equals("Teacher")) {
//            if(us.teacherService.updateperson(user)){
//                return "yes";
//            }else{
//                return "no";
//            }
//        } else if (user.getRole().equals("Student")) {
//            if(us.studentService.updateperson(user)){
//                System.out.println("service is ok");
//                return "yes";
//            }else{
//                System.out.println("service is ok");
//                return "no";
//            }
//        } else {
//            return "no";
//        }
//    }
//
//
//    //set password=#{password} where ${basis}=#{id}
//    @RequestMapping("/toFromPassword")
//    public @ResponseBody
//    String toFromPassword(@RequestBody SignBean user){
//
//        if (user.getRole()==null){
//            return "no";
//        }else if (user.getRole().equals("Admin")) {
//            if(us.adminService.updatepassword(user)){
//                return "yes";
//            }else{
//                return "no";
//            }
//        } else if (user.getRole().equals("Teacher")) {
//            if(us.teacherService.updatepassword(user)){
//                return "yes";
//            }else{
//                return "no";
//            }
//        } else if (user.getRole().equals("Student")) {
//            if(us.studentService.updatepassword(user)){
//
//                return "yes";
//            }else{
//
//                return "no";
//            }
//        } else {
//            return "no";
//        }
//    }


}
