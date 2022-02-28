package xyz.zixiu.aplp.Pojo.School;

import java.util.ArrayList;
import java.util.List;

public class CtrlCurriculumPojo {

    private String ctrl;
    private String departmentId;
    private String teacherId;
    private String curriculumId;

    private List<String> claseIdList=new ArrayList<>();

    @Override
    public String toString() {
        return "CtrlCurriculumPojo{" +
                "ctrl='" + ctrl + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", curriculumId='" + curriculumId + '\'' +
                ", claseIdList=" + claseIdList +
                '}';
    }

    public String getCtrl() {
        return ctrl;
    }

    public void setCtrl(String ctrl) {
        this.ctrl = ctrl;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public List<String> getClaseIdList() {
        return claseIdList;
    }

    public void setClaseIdList(List<String> claseIdList) {
        this.claseIdList = claseIdList;
    }

    public CtrlCurriculumPojo() {
    }

    public CtrlCurriculumPojo(String ctrl, String departmentId, String teacherId, String curriculumId, List<String> claseIdList) {
        this.ctrl = ctrl;
        this.departmentId = departmentId;
        this.teacherId = teacherId;
        this.curriculumId = curriculumId;
        this.claseIdList = claseIdList;
    }

    public void addClase(String claseId){
        this.claseIdList.add(claseId);
    }

}
