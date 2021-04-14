package xyz.zixiu.demo.service.system.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.demo.dao.system.SystemMapper;
import xyz.zixiu.demo.service.system.SystemService;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@Service("SystemService") //标记注入
@Transactional //加入事务管理
public class  SystemServiceImpl implements SystemService {

    //注入Mapper对象
    @Resource
    private SystemMapper mapper;

    @Override
    public boolean CheckSchool() {
            if(mapper.CheckSchool()==1){
                System.out.println("aplp_School数据库存在");
                return true;
            }else{
                System.out.println("aplp_School数据库不存在");
                return false;
            }
    }

    @Override
    public boolean CreateSchool(){
        try {
            mapper.CreateSchool();
            System.out.println("aplp_School数据库创建成功");
            return true;
        }catch (Exception e){
            System.out.println("aplp_School数据库创建失败");
            return false;
        }

    }

    @Override
    public boolean DropSchool(){
        try {
            mapper.DropSchool();
            System.out.println("aplp_School数据库删除成功");
            return true;
        }catch (Exception e){
            System.out.println("aplp_School数据库删除失败");
            return false;
        }
    }

    @Override
    public boolean CreateTable(){
        try {
           // mapper.CreateTable();
            System.out.println("aplp_School数据库数据表创建成功");
            return true;
        }catch (Exception e){
            System.out.println("aplp_School数据库数据表创建失败");
            return false;
        }
    }

}
