package xyz.zixiu.demo.dao.Impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import xyz.zixiu.demo.bean.bean_test;
import xyz.zixiu.demo.dao.bean_test_Mapper;

public class bean_test_Mapper_Impl extends SqlSessionDaoSupport implements bean_test_Mapper {

    @Override
    public void save_bean_test(bean_test bean) {
        SqlSession sqlSession =this.getSqlSession();
        sqlSession.insert("save_bean_test",bean);
        //这里不需要事务提交
    }
}
