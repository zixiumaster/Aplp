package xyz.zixiu.aplp.Controller;
import org.springframework.stereotype.Controller;
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
    public Sign stu(@RequestBody Sign user){
        System.out.println("\n\npublic String stu(@RequestBody Sign ss)\t"+user.toString()+"\n\n");
        return user;
    }

}
