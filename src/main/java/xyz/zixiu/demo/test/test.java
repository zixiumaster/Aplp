package xyz.zixiu.demo.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xyz.zixiu.demo.bean.bean_test;
import xyz.zixiu.demo.dao.bean_test_Mapper;

import java.io.InputStream;

public class test {
    @Test
    public void test() throws Exception{

        System.out.println("test_02");

        //1.创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //加载sqlMapConfig.xml文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");

        //2.创建SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);

        //3.打开SqlSession
        SqlSession sqlSession = factory.openSession();

        //4.获取Mapper接口的对象
        bean_test_Mapper link = sqlSession.getMapper(bean_test_Mapper.class);

        //5.操作
        bean_test bean= new bean_test();
        bean.setId(123);
        bean.setName("test");
        bean.setPwd("test");

        link.save_bean_test(bean);

        //6.提交事务
        sqlSession.commit();

        //7.关闭资源
        sqlSession.close();


    }
}
