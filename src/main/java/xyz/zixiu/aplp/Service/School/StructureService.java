package xyz.zixiu.aplp.Service.School;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import xyz.zixiu.aplp.Pojo.School.CtrlCurriculumPojo;
import xyz.zixiu.aplp.Pojo.School.SchoolPojo;
import xyz.zixiu.aplp.Pojo.School.UnitPojo;
import xyz.zixiu.aplp.Pojo.School.UpdUnitPojo;

import java.io.IOException;
import java.util.*;


/**
 * 院系结构服务
 * @see #setUnit(UnitPojo)      用于新建单位( Classe , Teacher , Department )
 * @see #delUnit(UnitPojo)      用于删除单位( Classe , Teacher , Department )
 * @see #updUnit(UpdUnitPojo)   用于更新单位( Classe , Teacher , Department )
 * @see #getSchoolPojo()        用于获取所有院系内的教师和班级的结构
 */
public class StructureService {

    RestTemplate restTemplate = new RestTemplate();

    public Boolean setUnit(UnitPojo newUnitPojo){
        return restTemplate.postForObject(UrlConstants.SCHOOL_STRUCTURE_SETUNIT,newUnitPojo,Boolean.class);
    }

    public Boolean delUnit(UnitPojo delUnitPojo){
        return restTemplate.postForObject(UrlConstants.SCHOOL_STRUCTURE_DELUNIT,delUnitPojo,Boolean.class);
    }

    public Boolean updUnit(UpdUnitPojo unitPojo){
        return restTemplate.postForObject(UrlConstants.SCHOOL_STRUCTURE_UPDUNIT, unitPojo,Boolean.class);
    }

    public SchoolPojo getSchoolPojo(){

        SchoolPojo schoolPojo = restTemplate.postForObject(UrlConstants.SCHOOL_STRUCTURE_GETSCHOOL,null,SchoolPojo.class);
        System.out.println(schoolPojo.toString());
        return  schoolPojo;

    }

    public Boolean addCurriculum(String departmentId, String teacherId, String curriculumId, List<String> claseId){

        Boolean checkFlag=false;

        CtrlCurriculumPojo ctrlCurriculumPojo=new CtrlCurriculumPojo();

        ctrlCurriculumPojo.setCtrl("add");
        ctrlCurriculumPojo.setDepartmentId(departmentId);
        ctrlCurriculumPojo.setTeacherId(teacherId);
        ctrlCurriculumPojo.setCurriculumId(curriculumId);
        ctrlCurriculumPojo.setClaseIdList(claseId);

        checkFlag=restTemplate.postForObject(UrlConstants.SCHOOL_CURRICULUM_ADD,ctrlCurriculumPojo,Boolean.class);

        return checkFlag;

    }

    //{role:身份,department:院系id,id:教师或班级id}
    public List<String> getCurriculum(String role,String department,String id){

        System.out.println(role);
        System.out.println(department);
        System.out.println(id);

        Map<String,String> sign=new HashMap<>();
        sign.put("role",role);
        sign.put("department",department);
        sign.put("id",id);

        System.out.println(sign.toString());

        String CurriculumListString=restTemplate.postForObject(UrlConstants.SCHOOL_CURRICULUM_SELECT_ONE,sign,String.class);

        System.out.println(sign.toString());

        String[] CurriculumArray = CurriculumListString.split("_");

        List<String> tempList = Arrays.asList(CurriculumArray);  //此集合无法操作添加元素

        List<String> CurriculumList = new ArrayList<String>(tempList); //此集合可操作元素

        return CurriculumList;
    }

    public String setfile(MultipartFile file) throws IOException {

        ByteArrayResource fileAsResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }

            @Override
            public long contentLength() {
                return file.getSize();
            }
        };
        MultiValueMap<String, Object> multipartRequest = new LinkedMultiValueMap<>();
        multipartRequest.add("multipartFile", fileAsResource);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity(multipartRequest, headers);
        //发起调用

        return restTemplate.postForObject(UrlConstants.ROOT+"CurriculumService/setfile", requestEntity, String.class);














//        MultiValueMap<String,Object> body =new LinkedMultiValueMap<>();
//
//        body.add("files",new FileSystemResource(  ));
//
//        File f= new File();
//
//        new FileSystemResource(f.getAbsoluteFile())

      //  return restTemplate.postForObject(UrlConstants.ROOT+"CurriculumService/setfile",file,String.class);

    //   return restTemplate.postForObject(UrlConstants.ROOT+"CurriculumService/setfile",files, String.class);
    }

}