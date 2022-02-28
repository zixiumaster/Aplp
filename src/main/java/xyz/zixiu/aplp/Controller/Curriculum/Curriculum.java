package xyz.zixiu.aplp.Controller.Curriculum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.zixiu.aplp.Bean.Curriculum.selCurriculumSign;
import xyz.zixiu.aplp.Pojo.Curriculum.CurriculumListPojo;
import xyz.zixiu.aplp.Pojo.Curriculum.CurriculumPojo;
import xyz.zixiu.aplp.Service.Curriculum.CurriculumService;
import xyz.zixiu.aplp.Service.School.StructureService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/Curriculum")
public class Curriculum {

    private CurriculumService curriculumService=new CurriculumService();

    private StructureService structureService =new StructureService();

    @RequestMapping( "/addCurriculum")
    @ResponseBody
    public String addCurriculum(
            @RequestParam(value = "file") MultipartFile[] files,  //接收文件
            @RequestParam(value = "fileName") String fileName,
            @RequestParam(value = "curriculumId") String curriculumId,
            @RequestParam(value = "curriculumName") String curriculumName,
            @RequestParam(value = "describeText") String describeText,
            @RequestParam(value = "departmentId") String departmentId,
            @RequestParam(value = "teacherId") String teacherId,
            @RequestParam(value = "classeList") List<String> classeList,

            HttpServletRequest request
    ) {
        if(files != null){
            try {
                //写入课程数据库
                MultipartFile file=files[0];

                System.out.println("\n"+file.getName()+"\n"+file.getSize()+"\n"+file.getClass()+"\n"+file.toString()+"\n");
                System.out.println(fileName);
                System.out.println(curriculumId);
                System.out.println(curriculumName);
                System.out.println(describeText);
                System.out.println(departmentId);
                System.out.println(teacherId);
                System.out.println(classeList);

                CurriculumPojo curriculumPojo=new CurriculumPojo(curriculumId,curriculumName,describeText,fileName);
                curriculumService.addCurriculum(file,curriculumPojo);

                //更新结构数据库
                structureService.addCurriculum(departmentId,teacherId,curriculumId,classeList);

                return "yes";
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return "error";
            }
        }else{
            return "error";
        }

    }

    @RequestMapping("/getCurriculumList")
    public @ResponseBody
    CurriculumListPojo getCurriculumList(@RequestBody String sign){
        System.out.println(sign.toString());

        String[] signArray = sign.split("_");

        List<String> curriculumList=new ArrayList<>();

        try {
            curriculumList = structureService.getCurriculum(signArray[0],signArray[1],signArray[2]);
        }catch (Exception e){
            System.err.println(e);
        }


        System.out.println(curriculumList.toString());

        try {
            List<String> asmCurriculumList = structureService.getCurriculum("Student","101","101");
            for (String asmCurriculumId:asmCurriculumList) {
                curriculumList.add(asmCurriculumId);
            }
        }catch (Exception e){
            System.err.println(e);
        }






        CurriculumListPojo curriculumListPojo =curriculumService.getCurriculumList(curriculumList);

        System.out.println(curriculumListPojo.toString());

        return curriculumListPojo;

    }

    @RequestMapping("/newPart")
    public @ResponseBody
    String newPart( @RequestParam(value = "curriculumId") String curriculumId,
                    @RequestParam(value = "partId") String partId,
                    @RequestParam(value = "partName") String partName,
                    @RequestParam(value = "describeText") String describeText){

        System.out.println(curriculumId);
        System.out.println(partId);
        System.out.println(partName);
        System.out.println(describeText);

        String isOk=curriculumService.addPart(curriculumId,partId,partName,describeText);



        return isOk;
    }

    @RequestMapping("/updPartFile")
    public @ResponseBody
    String updPartFile(
            @RequestParam(value = "file") MultipartFile[] files,  //接收文件
            @RequestParam(value = "fileName") String fileName,
            @RequestParam(value = "curriculumId") String curriculumId,
            @RequestParam(value = "partId") String partId
            ){
        String isOk="no";
        try {
            isOk=curriculumService.addPartFile(files[0],fileName,curriculumId,partId);
            return isOk;
        } catch (IOException e) {
            e.printStackTrace();
            return isOk;
        }

    }
}