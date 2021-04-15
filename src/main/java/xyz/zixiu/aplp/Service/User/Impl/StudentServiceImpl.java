package xyz.zixiu.aplp.Service.User.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.aplp.Bean.User.Sign;
import xyz.zixiu.aplp.Bean.User.Student;
import xyz.zixiu.aplp.Dao.User.StudentMapper;
import xyz.zixiu.aplp.Service.User.StudentService;

import javax.annotation.Resource;

@Service("StudentService") //标记注入
@Transactional //加入事务管理
public class StudentServiceImpl implements StudentService {

    //注入Mapper对象
    @Resource
    private StudentMapper mapper;

    @Override
    public void register(Student bean) {
            mapper.saveStudent(bean);
    }

    @Override
    public Boolean login(Sign sign) {
            Student log=mapper.selectStudentBySign(sign);
            if (log == null){
                System.out.println("\n\nuser does not exist or The password is incorrect\nStudent Login no\n\n");
                return false;
            }else{
                System.out.println(log.toString());
                System.out.println("\n\nStudent Login yes\n\n");
                return true;
            }
    }


}