package xyz.zixiu.aplp.Pojo.Curriculum;


import java.util.ArrayList;
import java.util.List;

/**
 * @see #curriculumId   课程Id
 * @see #curriculumName 课程名字
 * @see #describeText   描述文字
 * @see #coverPhotoUrl  课程封面图片路径
 * @see #parts          章节列表
 * @see #setPart(Part)  加入章节
 */
public class Curriculum {
    private String curriculumId;
    private String curriculumName;
    private String describeText;
    private String coverPhotoUrl;

    private List<Part> parts =new ArrayList<>();

    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getDescribeText() {
        return describeText;
    }

    public void setDescribeText(String describeText) {
        this.describeText = describeText;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "curriculumId='" + curriculumId + '\'' +
                ", curriculumName='" + curriculumName + '\'' +
                ", describeText='" + describeText + '\'' +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", parts=" + parts +
                '}';
    }

    public Curriculum() {
    }

    public Curriculum(String curriculumId, String curriculumName, String describeText, String coverPhotoUrl) {
        this.curriculumId = curriculumId;
        this.curriculumName = curriculumName;
        this.describeText = describeText;
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public Curriculum(String curriculumId, String curriculumName, String describeText, String coverPhotoUrl, List<Part> parts) {
        this.curriculumId = curriculumId;
        this.curriculumName = curriculumName;
        this.describeText = describeText;
        this.coverPhotoUrl = coverPhotoUrl;
        this.parts = parts;
    }

    public void setPart(Part part){
        this.parts.add(part);
    }

    public void getCurriculumPojo(CurriculumPojo curriculumPojo){
        this.curriculumId=curriculumPojo.getCurriculumId();
        this.curriculumName=curriculumPojo.getCurriculumName();
        this.describeText=curriculumPojo.getDescribeText();
        this.coverPhotoUrl=curriculumPojo.getCoverPhotoUrl();
    }

}
