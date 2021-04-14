package xyz.zixiu.demo.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.demo.Bean.Student;
import xyz.zixiu.demo.dao.StudentMapper;
import xyz.zixiu.demo.service.StudentService;
import javax.annotation.Resource;

@Service("bean_test_service") //标记注入
@Transactional //加入事务管理
public class StudentServiceImpl implements StudentService {

    //注入Mapper对象
    @Resource
    private StudentMapper Mapper;

    @Override
    public void saveStudent(Student bean) {
        Mapper.saveStudent(bean);
    }

}
