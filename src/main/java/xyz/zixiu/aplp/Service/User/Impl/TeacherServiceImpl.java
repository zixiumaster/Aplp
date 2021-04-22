package xyz.zixiu.aplp.Service.User.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Bean.User.TeacherBean;
import xyz.zixiu.aplp.Dao.User.TeacherMapper;
import xyz.zixiu.aplp.Service.User.Interface.TeacherService;

import javax.annotation.Resource;

@Service("TeacherService") //标记注入
@Transactional //加入事务管理
public class TeacherServiceImpl implements TeacherService {

    //注入Mapper对象
    @Resource
    private TeacherMapper mapper;

    @Override
    public Boolean register(SignBean sign) {
        try{
            sign.basisID();
            System.out.println(sign.toString());
            mapper.saveTeacher(sign);
            return true;
        }catch (Exception e){
            System.err.println("\n\n"+e+"\n\n");
            return false;
        }
    }

    @Override
    public Boolean login(SignBean sign) {
            TeacherBean log=mapper.selectTeacherBySign(sign);
            if (log == null){
                System.out.println("\n\nTeacher Login no\n\n");
                return false;
            }else{
                System.out.println("\n\nTeacher Login yes\n\n");
                return true;
            }
    }


}