package xyz.zixiu.aplp.Service.User.Interface;

import org.springframework.stereotype.Repository;
import xyz.zixiu.aplp.Bean.User.AdminBean;
import xyz.zixiu.aplp.Bean.User.SignBean;

@Repository
public interface AdminService {

    public Boolean register(SignBean bean);

    public AdminBean login(SignBean sign);


}