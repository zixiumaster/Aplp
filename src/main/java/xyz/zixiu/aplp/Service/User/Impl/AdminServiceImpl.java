package xyz.zixiu.aplp.Service.User.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.aplp.Bean.User.AdminBean;
import xyz.zixiu.aplp.Bean.User.SignBean;
import xyz.zixiu.aplp.Dao.User.AdminMapper;
import xyz.zixiu.aplp.Service.User.Interface.AdminService;

import javax.annotation.Resource;

@Service("AdminService") //标记注入
@Transactional //加入事务管理
public class AdminServiceImpl implements AdminService {

    //注入Mapper对象
    @Resource
    private AdminMapper mapper;

    @Override
    public Boolean register(SignBean sign) {
        try{
            sign.basisID();
            System.out.println(sign.toString());
            mapper.saveAdmin(sign);
            return true;
        }catch (Exception e){
            System.err.println("\n\n"+e+"\n\n");
            return false;
        }
    }

    @Override
    public AdminBean login(SignBean sign) {
        AdminBean log=mapper.selectAdminBySign(sign);
            if (log == null){
                System.out.println("\n\nAdmin Login no\n\n");
                return null;
            }else{
                System.out.println("\n\nAdmin Login yes\n\n");
                return log;
            }
    }


}