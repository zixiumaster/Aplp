package xyz.zixiu.aplp.Controller.GetHeml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @see #getFromManageCurriculum()  管理员发布课程表单
 * @see #getFromManagePart()        教师发布章节表单
 */
@CrossOrigin
@Controller
@RequestMapping("/GetHtmlCurriculum")
public class GetHtmlCurriculum {

    @RequestMapping("/getFromManageCurriculum")
    public String getFromManageCurriculum(){

        return "Html/Main/FromCurriculum/FromManageCurriculum.html";
    }

    @RequestMapping("/getFromManagePart")
    public String getFromManagePart(){

        return "Html/Main/FromCurriculum/FromManagePart.html";
    }

    @RequestMapping("/getHtmlCurriculumList")
    public String getHtmlCurriculumList(){

        return "Html/Curriculum/curriculumBlockView.html";
    }

    @RequestMapping("/getHtmlPartListTable")
    public String getHtmlPartListTable(){
        return "Html/Curriculum/partListTable.html";
    }

    @RequestMapping("/getHtmlPartView")
    public String getHtmlpartView(){
        return "Html/Curriculum/partView.html";
    }


    @RequestMapping("/getHtmlManagePartList")
    public String getHtmlManagePartList(){
        return "/Html/Curriculum/ManagePartList.html";
    }

}