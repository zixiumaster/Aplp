package xyz.zixiu.aplp.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.zixiu.aplp.Bean.User.Sign;

@Controller
@RequestMapping("/Login")
public class Login {

    String basis;
    private String value;
    private String password;

    //is no OK
    @RequestMapping(value="/stu",method= RequestMethod.POST)
    public String stu(@RequestBody Sign user){

        System.out.println("\n\npublic String stu(@RequestBody Sign ss)\t"+user.toString()+"\n\n");
        return "test";
    }

    //is OK
    @RequestMapping(value="/test_01",method= RequestMethod.POST)
    @ResponseBody
    public Sign test_01(@RequestBody Sign user){
        System.out.println("\n\npublic Sign test_02(@RequestBody Sign user)\t"+user.toString()+"\n\n");
        return new Sign("hahaha","hahaha","hahaha");
    }

    //is OK
    @RequestMapping(value="/test_02",method= RequestMethod.POST)
    public @ResponseBody Sign test_02(@RequestBody Sign user){
        System.out.println("\n\npublic Sign test_02(@RequestBody Sign user)\t"+user.toString()+"\n\n");
        return  new Sign("hahaha","hahaha","hahaha");
    }

    //is no OK
    @RequestMapping(value="/test_03",method= RequestMethod.POST)
    public Sign test_03(@RequestBody Sign user){
        System.out.println("\n\npublic Sign test_02(@RequestBody Sign user)\t"+user.toString()+"\n\n");
        return  new Sign("hahaha","hahaha","hahaha");
    }

}
