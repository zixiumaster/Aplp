package xyz.zixiu.aplp.Pojo.Curriculum;


import java.util.ArrayList;
import java.util.List;

public class Part {
    private String partId;
    private String themeText;
    private String describeText;
    private List<String> fileUrlList = new ArrayList<>();

    @Override
    public String toString() {
        return "Part{" +
                "partId='" + partId + '\'' +
                ", themeText='" + themeText + '\'' +
                ", describeText='" + describeText + '\'' +
                ", fileUrlList=" + fileUrlList +
                '}';
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getThemeText() {
        return themeText;
    }

    public void setThemeText(String themeText) {
        this.themeText = themeText;
    }

    public String getDescribeText() {
        return describeText;
    }

    public void setDescribeText(String describeText) {
        this.describeText = describeText;
    }

    public List<String> getFileUrlList() {
        return fileUrlList;
    }

    public void setFileUrlList(List<String> fileUrlList) {
        this.fileUrlList = fileUrlList;
    }

    public Part() {
    }

    public Part(String partId, String themeText, String describeText, List<String> fileUrlList) {
        this.partId = partId;
        this.themeText = themeText;
        this.describeText = describeText;
        this.fileUrlList = fileUrlList;
    }

    public void addfileUrl(String fileUr){
        this.fileUrlList.add(fileUr);
    }

}
