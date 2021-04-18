package xyz.zixiu.aplp.Controller;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.fabric.xmlrpc.base.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.zixiu.aplp.Bean.User.Sign;

@Controller
@RequestMapping("/Login")
public class Login {

    String basis;
    private String value;
    private String password;

    @RequestMapping(value="/stu",method= RequestMethod.POST)
    public String stu(@RequestBody Sign ss){
        System.out.println(ss.toString());
        System.out.println("public String stu(@RequestBody Sign ss)");
        return "zixiu";
    }

}
