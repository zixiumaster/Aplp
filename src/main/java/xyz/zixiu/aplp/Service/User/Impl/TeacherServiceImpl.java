package xyz.zixiu.aplp.Service.User.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.aplp.Bean.User.Sign;
import xyz.zixiu.aplp.Bean.User.Student;
import xyz.zixiu.aplp.Bean.User.Teacher;
import xyz.zixiu.aplp.Dao.User.StudentMapper;
import xyz.zixiu.aplp.Dao.User.TeacherMapper;
import xyz.zixiu.aplp.Service.User.StudentService;
import xyz.zixiu.aplp.Service.User.TeacherService;

import javax.annotation.Resource;

@Service("TeacherService") //标记注入
@Transactional //加入事务管理
public class TeacherServiceImpl implements TeacherService {

    //注入Mapper对象
    @Resource
    private TeacherMapper mapper;

    @Override
    public void register(Teacher bean) {
            mapper.saveTeacher(bean);
    }

    @Override
    public Boolean login(Sign sign) {
            Teacher log=mapper.selectTeacherBySign(sign);
            if (log == null){
                System.out.println("\n\nuser does not exist or The password is incorrect\nTeacher Login no\n\n");
                return false;
            }else{
                System.out.println(log.toString());
                System.out.println("\n\nTeacher Login yes\n\n");
                return true;
            }
    }


}