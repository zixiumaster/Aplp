package xyz.zixiu.aplp.Pojo.Curriculum;

import java.util.ArrayList;
import java.util.List;

public class CurriculumListPojo {


    private List<Curriculum> curriculumList=new ArrayList<>();


    public List<Curriculum> getCurriculumList() {
        return curriculumList;
    }

    public void setCurriculumList(List<Curriculum> curriculumList) {
        this.curriculumList = curriculumList;
    }

    @Override
    public String toString() {
        return "CurriculumListPojo{" +
                "curriculumList=" + curriculumList +
                '}';
    }

    public CurriculumListPojo() {
    }

    public CurriculumListPojo(List<Curriculum> curriculumList) {
        this.curriculumList = curriculumList;
    }

    public void setCurriculum(Curriculum curriculum){
        curriculumList.add(curriculum);
    }

}
