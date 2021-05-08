package xyz.zixiu.aplp.Service.User.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.aplp.Bean.UserBean.ClientBean;
import xyz.zixiu.aplp.Bean.UserBean.SignBean;
import xyz.zixiu.aplp.Dao.User.AdminMapper;
import xyz.zixiu.aplp.Dao.User.StudentMapper;
import xyz.zixiu.aplp.Dao.User.TeacherMapper;
import xyz.zixiu.aplp.Entity.*;
import xyz.zixiu.aplp.Service.User.Interface.UserInformationService;

import javax.annotation.Resource;

@Service("UserInformationService") //标记注入
@Transactional //加入事务管理
public class UserInformationServiceImpl implements UserInformationService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public ClientBean signIn(SignBean signBean) {
        String role = signBean.getRole();
        if (role.equals("Administrator")) {
            return signInAdministrator(signBean);
        } else if (role.equals("Teacher")) {
            return signInTeacher(signBean);
        } else if (role.equals("Student")) {
            return signInStudent(signBean);
        } else {
            return null;
        }
    }

    @Override
    public Boolean signUpUser(SignBean signBean) {
        SignEntity signEntity = new SignEntity(signBean.getBasis(), signBean.getId(), signBean.getPassword());
        String role = signBean.getRole();
        try {
            if (role.equals("Administrator")) {
                System.out.println(signEntity.toString());
                System.out.println("Don't register administrator here !");
                return false;
            } else if (role.equals("Teacher")) {
                System.out.println(signEntity.toString());
                teacherMapper.signUpTeacher(signEntity);
                System.out.println("Teacher Sign Up is OK !");
                return true;
            } else if (role.equals("Student")) {
                System.out.println(signEntity.toString());
                studentMapper.signUpStudent(signEntity);
                System.out.println("Student Sign Up is OK");

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean signUpAdministrator(SignBean verificationSignBean, SignBean newSignBean) {
        try {
            if (verificationSignBean.getRole().equals("Administrator") && this.signInAdministrator(verificationSignBean) != null) {
                SignEntity newSignEntity = new SignEntity(newSignBean.getBasis(), newSignBean.getId(), newSignBean.getPassword());
                String newrole = newSignBean.getRole();
                if (newrole.equals("Administrator")) {
                    adminMapper.signUpAdministrator(newSignEntity);
                    System.out.println("Administrator Sign Up is OK !");
                    System.out.println(newSignEntity.toString());
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteUser(SignBean signBean) {
        SignEntity signEntity = new SignEntity(signBean.getBasis(), signBean.getId(), signBean.getPassword());
        String role = signBean.getRole();
        try {
            if (role.equals("Administrator")) {
                adminMapper.deleteAdministrator(signEntity);
                ;
                System.out.println("Administrator delete is OK");
                System.out.println(signEntity.toString());
                return true;
            } else if (role.equals("Teacher")) {
                teacherMapper.deleteTeacher(signEntity);
                System.out.println("Teacher delete is OK");
                System.out.println(signEntity.toString());
                return true;
            } else if (role.equals("Student")) {
                studentMapper.deleteStudent(signEntity);
                System.out.println("Student delete is OK");
                System.out.println(signEntity.toString());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updeteUser(UpdateAdministratorEntity updateAdministratorEntity) {
        try {
            adminMapper.updateAdministrator(updateAdministratorEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updeteUser(UpdateTeacherEntity updateTeacherEntity) {
        try {
            teacherMapper.updateTeacher(updateTeacherEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateUser(UpdateStudentEntity updateStudentEntity) {
        try {
            studentMapper.updateStudent(updateStudentEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ClientBean signInAdministrator(SignBean signBean) {
        try {
            SignEntity signEntity = new SignEntity(signBean.getBasis(), signBean.getId(), signBean.getPassword());
            String role = signBean.getRole();
            if (role.equals("Administrator")) {
                return new ClientBean(signBean, adminMapper.signInAdministrator(signEntity));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ClientBean signInStudent(SignBean signBean) {
        try {
            SignEntity signEntity = new SignEntity(signBean.getBasis(), signBean.getId(), signBean.getPassword());
            String role = signBean.getRole();
            if (role.equals("Student")) {
                return new ClientBean(signBean, studentMapper.signInStudent(signEntity));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ClientBean signInTeacher(SignBean signBean) {
        try {
            SignEntity signEntity = new SignEntity(signBean.getBasis(), signBean.getId(), signBean.getPassword());
            String role = signBean.getRole();
            if (role.equals("Teacher")) {
                return new ClientBean(signBean, teacherMapper.signInTeacher(signEntity));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

}