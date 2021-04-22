package xyz.zixiu.aplp.Service.User.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Bean.User.StudentBean;
import xyz.zixiu.aplp.Dao.User.StudentMapper;
import xyz.zixiu.aplp.Service.User.Interface.StudentService;

import javax.annotation.Resource;

@Service("StudentService") //标记注入
@Transactional //加入事务管理
public class StudentServiceImpl implements StudentService {

    //注入Mapper对象
    @Resource
    private StudentMapper mapper;

    @Override
    public Boolean register(SignBean sign) {
        try{
            sign.basisID();
            System.out.println(sign.toString());
            mapper.saveStudent(sign);
            return true;
        }catch (Exception e){
            System.err.println("\n\n"+e+"\n\n");
            return false;
        }
    }

    @Override
    public Boolean login(SignBean sign) {
            StudentBean log=mapper.selectStudentBySign(sign);
            if (log == null){
                System.out.println("\n\nStudent Login no\n\n");
                return false;
            }else{
                System.out.println("\n\nStudent Login yes\n\n");
                return true;
            }
    }


}