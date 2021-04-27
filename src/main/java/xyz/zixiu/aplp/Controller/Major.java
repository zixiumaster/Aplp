package xyz.zixiu.aplp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Major")
public class Major {

    @RequestMapping("/goMajor")
    public String goMajor(){
        System.out.println("\n\ngoMajor ok\n\n");
        return "jsp/Main/Index.jsp";
    }


}
