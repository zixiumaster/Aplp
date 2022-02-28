package xyz.zixiu.aplp.Pojo.Curriculum;

public class CurriculumPojo {

    private String curriculumId;

    private String curriculumName;

    private String describeText;

    private String coverPhotoUrl;

    @Override
    public String toString() {
        return "CurriculumPojo{" +
                "curriculumId='" + curriculumId + '\'' +
                ", curriculumName='" + curriculumName + '\'' +
                ", describeText='" + describeText + '\'' +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                '}';
    }

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

    public CurriculumPojo() {
    }

    public CurriculumPojo(String curriculumId, String curriculumName, String describeText, String coverPhotoUrl) {
        this.curriculumId = curriculumId;
        this.curriculumName = curriculumName;
        this.describeText = describeText;
        this.coverPhotoUrl = coverPhotoUrl;
    }

}
