package xyz.zixiu.aplp.Service.School;

public class UrlConstants {

    public static final String IP = "127.0.0.1";

    public static final String PART = "38806";

    public static final String ROOT = "http://" + IP + ":" + PART + "/";

    public static final String ROOT_SCHOOL_STRUCTURE = ROOT + "SchoolStructureService/";

    public static final String SCHOOL_STRUCTURE_GETSCHOOL = ROOT_SCHOOL_STRUCTURE + "getSchool";

    public static final String SCHOOL_STRUCTURE_SETUNIT = ROOT_SCHOOL_STRUCTURE + "setUnit";

    public static final String SCHOOL_STRUCTURE_DELUNIT = ROOT_SCHOOL_STRUCTURE + "delUnit";

    public static final String SCHOOL_STRUCTURE_UPDUNIT = ROOT_SCHOOL_STRUCTURE + "updUnit";

    public static final String SCHOOL_CURRICULUM_ADD = ROOT_SCHOOL_STRUCTURE + "AddCurriculum";

    public static final String SCHOOL_CURRICULUM_SELECT_ONE=ROOT_SCHOOL_STRUCTURE+"getCurriculum";

}
