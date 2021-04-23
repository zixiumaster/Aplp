package xyz.zixiu.aplp.Dao.User;

import xyz.zixiu.aplp.Bean.User.AdminBean;
import xyz.zixiu.aplp.Bean.User.SignBean;

public interface AdminMapper {

    public void saveAdmin(SignBean bean);

    public AdminBean selectAdminBySign(SignBean sign);

}