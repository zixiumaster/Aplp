package xyz.zixiu.aplp.Bean.Curriculum;

public class selCurriculumSign {

    private String role;

    private String department;

    private String id;

    @Override
    public String toString() {
        return "selCurriculumSign{" +
                "role='" + role + '\'' +
                ", department='" + department + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public selCurriculumSign() {
    }

    public selCurriculumSign(String role, String department, String id) {
        this.role = role;
        this.department = department;
        this.id = id;
    }

}