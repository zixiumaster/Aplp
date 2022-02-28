package xyz.zixiu.aplp.Service.Curriculum;

public class UrlConstants {

    public static final String IP = "127.0.0.1";

    public static final String PART = "38807";

    public static final String ROOT = "http://" + IP + ":" + PART + "/";

    public static final String ROOT_CURRICULUM=ROOT+"CurriculumService/";

    public static final String CURRICULUM_ADD=ROOT_CURRICULUM+"addCurriculum";

    public static final String CURRICULUM_LIST_GET=ROOT_CURRICULUM+"getCurriculumList";

    public static final String CURRICULUM_PART_ADD=ROOT_CURRICULUM+"addPart";

    public static final String CURRICULUM_PART_FILE_ADD=ROOT_CURRICULUM+"addPartFile";

}
