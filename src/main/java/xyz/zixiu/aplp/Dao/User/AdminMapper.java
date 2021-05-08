package xyz.zixiu.aplp.Dao.User;

import xyz.zixiu.aplp.Entity.ReadAdministratorEntity;
import xyz.zixiu.aplp.Entity.SignEntity;
import xyz.zixiu.aplp.Entity.UpdateAdministratorEntity;

public interface AdminMapper {

    public void signUpAdministrator(SignEntity signEntity);

    public ReadAdministratorEntity signInAdministrator(SignEntity signEntity);

    public void updateAdministrator(UpdateAdministratorEntity updateAdministratorEntity);

    public void deleteAdministrator(SignEntity signEntity);

}