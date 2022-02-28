package xyz.zixiu.aplp.Pojo.School;

import java.util.List;

public class SchoolPojo {

    List<DepartmentPojo> school;

    @Override
    public String toString() {
        return "SchoolPojo{" +
                "school=" + school +
                '}';
    }

    public List<DepartmentPojo> getSchool() {
        return school;
    }

    public void setSchool(List<DepartmentPojo> school) {
        this.school = school;
    }

    public SchoolPojo() {

    }

    public SchoolPojo(List<DepartmentPojo> school) {
        this.school = school;
    }
}
