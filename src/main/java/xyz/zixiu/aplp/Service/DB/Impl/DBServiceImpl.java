package xyz.zixiu.aplp.Service.DB.Impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.aplp.Dao.DB.DBMapper;
import xyz.zixiu.aplp.Service.DB.Interface.DBService;

import javax.annotation.Resource;

@Service("DBService")
@Transactional
public class DBServiceImpl implements DBService {

    @Resource
    private DBMapper dbMapper;

    @Override
    public Boolean rebuild(){
        return false;
    }
    @Override
    public Boolean build(){
        if(this.chack()){
            System.out.println("\n\naplp数据库已经存在\n\n");
        }else{
            System.out.println("\n\naplp数据库不存在，现将创建之\n\n");
            dbMapper.CreateAplp();
            System.out.println("\n\naplp数据库创建成功\n\n");
        }

        return false;
    }

    @Override
    public Boolean chack() {
        if(dbMapper.CheckAplp()==1){
            System.out.println("\n\naplp数据库存在\n\n");
            return true;
        }else{
            System.out.println("\n\naplp数据库不存在\n\n");
            return false;
        }
    }
}
