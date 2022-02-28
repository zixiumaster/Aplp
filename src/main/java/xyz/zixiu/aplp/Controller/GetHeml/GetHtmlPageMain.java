package xyz.zixiu.aplp.Controller.GetHeml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 用于获取模块HTML
 * @see #getHtmlPageMainMenu(Map)   获取页面工具栏模块html
 * @see #getHtmlPageFormPerson()    获取个人信息更改表单
 * @see #getFromManageDepartment()  获取管理院系信息表单
 * @see #getFromManageClasse()      获取管理班级信息表单
 * @see #getFromUpdeteDepartment()  获取教师更新院系信息表单
 * @see #getFromUpdateClasse()      获取学生更新班级信息表单
 */
@CrossOrigin
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
        }else if(role.equals("Administrator")){
            return "Html/Main/Menu/Menu_01_Admin.html";
        }else{
            return null;
        }

    }

    @RequestMapping("/getHtmlPageFormPerson")
    public String getHtmlPageFormPerson(){
        return "Html/Main/FormPerson/FormPerson.html";
    }

    @RequestMapping("/getFromManageClasse")
    public String getFromManageClasse(){
        return "Html/Main/FormPerson/FromManageClasse.html";
    }

    @RequestMapping("/getFromManageDepartment")
    public String getFromManageDepartment(){
        return "Html/Main/FormPerson/FromManageDepartment.html";
    }

    @RequestMapping("/getFromManageDepartmentAdd")
    public String getFromManageDepartmentAdd(){
        return "Html/Main/FromManageSchool/FromManageDepartmentAdd.html";
    }

    @RequestMapping("/getFromManageDepartmentUpd")
    public String getFromManageDepartmentUpd(){
        return "Html/Main/FromManageSchool/FromManageDepartmentUpd.html";
    }

    @RequestMapping("/getFromManageDepartmentDel")
    public String getFromManageDepartmentDel(){
        return "Html/Main/FromManageSchool/FromManageDepartmentDel.html";
    }

    @RequestMapping("/getFromManageClasseAdd")
    public String getFromManageClasseAdd(){
        return "Html/Main/FromManageSchool/FromManageClasseAdd.html";
    }

    @RequestMapping("/getFromManageClasseDel")
    public String getFromManageClasseDel(){
        return "Html/Main/FromManageSchool/FromManageClasseDel.html";
    }

    @RequestMapping("/getFromManageClasseUpd")
    public String getFromManageClasseUpd(){
        return "Html/Main/FromManageSchool/FromManageClasseUpd.html";
    }

    @RequestMapping("/getFromUpdateClasse")
    public String getFromUpdateClasse(){
        return "Html/Main/FormPerson/FromSchoolStudent.html";
    }

    @RequestMapping("/getFromUpdeteDepartment")
    public String getFromUpdeteDepartment(){
        return "Html/Main/FormPerson/FromSchoolTeacher.html";
    }

    @RequestMapping("/getHtmlAddAdmin")
    public String getHtmlAddAdmin(){
        return "Html/Main/FormPerson/AddAmin.html";
    }


}
