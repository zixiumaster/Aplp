package xyz.zixiu.aplp.Controller.GetHeml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/GetHtmlPageMain")
public class GetHtmlPageMain {

    @RequestMapping("/getHtmlPageMainMenu")
    public String getHtmlPageMainMenu(@RequestBody Map<String,String> RB){
       // System.out.println("getHtmlPageMainMenu(@RequestParam(\"role\") String role)");
        String role=RB.get("role");
        System.out.println(role);

        if(role.equals("Student")){
            return "Html/Main/Menu/Menu_01_Student.html";
        }else if(role.equals("Teacher")){
            return "Html/Main/Menu/Menu_01_Teacher.html";
        }else if(role.equals("Admin")){
            return "Html/Main/Menu/Menu_01_Admin.html";
        }else{
            return null;
        }

    }

    @RequestMapping("/getHtmlPageFormPerson")
    public String getHtmlPageFormPerson(){
        return "Html/Main/From/FormPerson.html";
    }

    @RequestMapping("/getHtmlPageForm_ss")
    public String getHtmlPageForm_ss(){

        return "Html/Main/From/FormPerson.html";
    }



}
