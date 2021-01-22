package xyz.zixiu.demo.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.demo.bean.bean_test;
import xyz.zixiu.demo.dao.bean_test_Mapper;
import xyz.zixiu.demo.service.bean_test_service;

import javax.annotation.Resource;

@Service("bean_test_service") //标记注入
@Transactional //加入事务管理
public class bean_test_service_Impl implements bean_test_service {

    //注入Mapper对象
    @Resource
    private bean_test_Mapper Mapper;

    @Override
    public void save_bean_test(bean_test bean) {
        Mapper.save_bean_test(bean);
    }
}
