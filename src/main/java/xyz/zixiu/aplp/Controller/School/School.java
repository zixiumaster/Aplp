package xyz.zixiu.aplp.Controller.School;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.zixiu.aplp.Bean.UserBean.ClientBean;
import xyz.zixiu.aplp.Bean.UserBean.FromSchoolBean;
import xyz.zixiu.aplp.Bean.UserBean.SignBean;
import xyz.zixiu.aplp.Pojo.School.DepartmentPojo;
import xyz.zixiu.aplp.Pojo.School.SchoolPojo;
import xyz.zixiu.aplp.Pojo.School.UnitPojo;
import xyz.zixiu.aplp.Pojo.School.UpdUnitPojo;
import xyz.zixiu.aplp.Service.School.StructureService;
import xyz.zixiu.aplp.Service.User.Interface.UserInformationService;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/School")
public class School {

    private StructureService structureService =new StructureService();

    private UserInformationService userInformationService;

    @RequestMapping("/getSchool")
    public @ResponseBody
    SchoolPojo getSchoolPojo() {

        SchoolPojo schoolPojo =structureService.getSchoolPojo();

        for (DepartmentPojo dep:schoolPojo.getSchool()) {
            String a = dep.getId();
            System.out.println(a);

            List<String> b =userInformationService.getTeacherList(a);
            System.out.println(b.toString());

            dep.setTeacherList(b);
            System.out.println(dep);
        }
        System.out.println(schoolPojo.toString());
        return schoolPojo;
    }

    @RequestMapping("/addUnit")
    public @ResponseBody
    Boolean addUnit(@RequestBody UnitPojo newUnitPojo) {
        System.out.println(" Boolean addUnit(@RequestBody UnitPojo newUnitPojo)");
        System.out.println(newUnitPojo);
        return structureService.setUnit(newUnitPojo);
    }

    @RequestMapping("/delUnit")
    public @ResponseBody
    Boolean delUnit(@RequestBody UnitPojo delUnitPojo) {
        System.out.println(" Boolean delUnit(@RequestBody UnitPojo delUnitPojo)");
        System.out.println(delUnitPojo);
        return structureService.delUnit(delUnitPojo);
    }

    @RequestMapping("/updUnit")
    public @ResponseBody
    Boolean updUnit(@RequestBody UpdUnitPojo unitPojo) {
        return structureService.updUnit(unitPojo);
    }

    @RequestMapping("/getCurriculumList")
    public @ResponseBody
    List<String> getCurriculumList(@RequestBody String role,String department,String id){
        return structureService.getCurriculum(role,department,id);
    }

    @RequestMapping( "/up")
    @ResponseBody
    public String uploadTrainProduct(
            @RequestParam(value = "file") MultipartFile[] files,  //这样接收文件
            @RequestParam(value = "id") String id,
            @RequestParam(value = "content") String content,
            HttpServletRequest request
    ) {
        System.out.println(id);
        System.out.println(content);
        System.out.println("uploadTrainProduct");
        System.out.println( files.length);
        System.out.println( files.toString());
        try {
            for (MultipartFile file : files) {    //循环保存文件
                System.out.println(file.getName());
                System.out.println(file.getSize());
                System.out.println(file.getClass());
                System.out.println(file.toString());
                System.out.println(1234567);
                structureService.setfile(file);
            }
            structureService.setfile(files[0]);

            // 返回前台
            return "成功";

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    public School() {
        System.out.println("public Major()");
        ApplicationContext ac_User = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext-User.xml");
        userInformationService = (UserInformationService)ac_User.getBean("UserInformationService");
    }

}