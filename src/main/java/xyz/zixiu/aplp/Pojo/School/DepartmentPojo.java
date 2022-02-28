package xyz.zixiu.aplp.Pojo.School;


import java.util.ArrayList;
import java.util.List;

public class DepartmentPojo {

    private String id;

    private String name;

    private List<String> teacherList = new ArrayList<>();

    private List<String> classeList = new ArrayList<>();

    public void pushTeacher(String teacherId) {
        this.teacherList.add(teacherId);
    }

    public void pushClasse(String classeId, String classeName) {
        String classe = classeId + "_" + classeName;
        this.classeList.add(classe);
    }

    @Override
    public String toString() {
        return "DepartmentPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teacherList=" + teacherList +
                ", classeList=" + classeList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<String> teacherList) {
        this.teacherList = teacherList;
    }

    public List<String> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<String> classeList) {
        this.classeList = classeList;
    }

    public DepartmentPojo() {
    }

    public DepartmentPojo(String id, String name, List<String> teacherList, List<String> classeList) {
        this.id = id;
        this.name = name;
        this.teacherList = teacherList;
        this.classeList = classeList;
    }
}