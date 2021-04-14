package xyz.zixiu.demo.service.system;

import org.springframework.stereotype.Repository;
import xyz.zixiu.demo.bean.bean_test;

@Repository
public interface SystemService {
    public boolean CheckSchool();

    public boolean  CreateSchool();

    public boolean DropSchool();

    public boolean CreateTable();
}
