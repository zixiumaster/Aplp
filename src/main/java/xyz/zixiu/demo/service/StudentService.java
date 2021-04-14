package xyz.zixiu.demo.service;

import org.springframework.stereotype.Repository;
import xyz.zixiu.demo.Bean.Student;

@Repository
public interface StudentService {
    public void saveStudent(Student bean);


}
