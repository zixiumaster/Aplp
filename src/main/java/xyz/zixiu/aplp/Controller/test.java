package xyz.zixiu.aplp.Controller;
import org.apache.commons.fileupload.FileItemHeaders;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import xyz.zixiu.aplp.Bean.User.Sign;

import java.util.Enumeration;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class test {


    @RequestMapping(value="/login",method= RequestMethod.POST)
    public @ResponseBody Sign login(@RequestBody Sign user){

        System.out.println("\n\npublic Sign test_02(@RequestBody Sign user)\t"+user.toString()+"\n\n");

        return  new Sign();
    }

}
