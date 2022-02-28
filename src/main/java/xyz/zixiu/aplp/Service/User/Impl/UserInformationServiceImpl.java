package xyz.zixiu.aplp.Service.User.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zixiu.aplp.Bean.UserBean.ClientBean;
import xyz.zixiu.aplp.Bean.UserBean.FromPersonBean;
import xyz.zixiu.aplp.Bean.UserBean.FromSchoolBean;
import xyz.zixiu.aplp.Bean.UserBean.SignBean;
import xyz.zixiu.aplp.Dao.User.AdminMapper;
import xyz.zixiu.aplp.Dao.User.StudentMapper;
import xyz.zixiu.aplp.Dao.User.TeacherMapper;
import xyz.zixiu.aplp.Entity.*;
import xyz.zixiu.aplp.Pojo.School.UnitPojo;
import xyz.zixiu.aplp.Pojo.School.UpdUnitPojo;
import xyz.zixiu.aplp.Service.School.StructureService;
import xyz.zixiu.aplp.Service.User.Interface.UserInformationService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("UserInformationService") //标记注入
//@Transactional //加入事务管理
public class UserInformationServiceImpl implements UserInformationService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private TeacherMapper teacherMapper;

    private StructureService structureService =new StructureService();

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
 //       try {
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
//        } catch (Exception e) {
//            return false;
//        }
    }

    @Override
    public Boolean updeteUser(FromPersonBean bean) {




        System.out.println(bean.toString());
        //提取签名类signEntity,用于查询用户原数据
        SignEntity signEntity= bean.getSignEntity();


        //判断用户身份
        String role = bean.getSignrole();
        if (role.equals("Administrator")) {

            //查询用户原数据
            ReadAdministratorEntity readAdministratorEntity=adminMapper.signInAdministrator(signEntity);

            //创建用户更新数据类
            UpdateAdministratorEntity updateAdministratorEntity=new UpdateAdministratorEntity();

            //写入原数据
            try {
                updateAdministratorEntity.setUpdateAdministratorEntity(readAdministratorEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //新数据覆盖原数据
            updateAdministratorEntity.setFromPersonBean(bean);

            if (updeteUser(updateAdministratorEntity)){
                return true;
            }else {
                return false;
            }
        } else if (role.equals("Teacher")) {

            //查询用户原数据
            ReadTeacherEntity readTeacherEntity=teacherMapper.signInTeacher(signEntity);

            System.out.println(readTeacherEntity);

            //创建用户更新数据类
            UpdateTeacherEntity updateTeacherEntity=new UpdateTeacherEntity();

            //写入原数据
            try {
                updateTeacherEntity.setUpdateTeacherEntity(readTeacherEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //新数据覆盖原数据
            updateTeacherEntity.setFromPersonBean(bean);

            //更新数据
            if (updeteUser(updateTeacherEntity)){
                return true;
            }else {
                return false;
            }

        } else if (role.equals("Student")) {
            //查询用户原数据
            ReadStudentEntity readStudentEntity=studentMapper.signInStudent(signEntity);

            System.out.println(readStudentEntity.toString());

            //创建用户更新数据类
            UpdateStudentEntity updateStudentEntity=new UpdateStudentEntity();

            //写入原数据
            try {
                updateStudentEntity.setUpdateStudentEntity(readStudentEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(updateStudentEntity.toString());

            //新数据覆盖原数据
            updateStudentEntity.setFromPersonBean(bean);


            //更新数据
            if (updateUser(updateStudentEntity)){
                return true;
            }else {
                return false;
            }
        } else {
            return null;
        }
    }

    @Override
    public Boolean updeteUser(FromSchoolBean bean) {

        System.out.println(bean.toString());
        //提取签名类signEntity,用于查询用户原数据
        SignEntity signEntity= bean.getSignEntity();


        //判断用户身份
        String role = bean.getSignrole();
        if (role.equals("Teacher")) {

            //查询用户原数据
            ReadTeacherEntity readTeacherEntity=teacherMapper.signInTeacher(signEntity);

            //创建用户更新数据类
            UpdateTeacherEntity updateTeacherEntity=new UpdateTeacherEntity();

            //写入原数据
            try {
                updateTeacherEntity.setUpdateTeacherEntity(readTeacherEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //新数据覆盖原数据
            updateTeacherEntity.setFromSchoolBean(bean);

            //更新数据
            if (updeteUser(updateTeacherEntity)){
                structureService.delUnit(new UnitPojo(role,readTeacherEntity.getDepartment(),readTeacherEntity.getId(),""));
                String ctrlId=bean.getSignId();
                structureService.setUnit(new UnitPojo(role,bean.getDepartment(),bean.getSignId(),null));
                return true;
            }else {
                return false;
            }

        } else if (role.equals("Student")) {
            //查询用户原数据
            ReadStudentEntity readStudentEntity=studentMapper.signInStudent(signEntity);

            System.out.println(readStudentEntity.toString());

            //创建用户更新数据类
            UpdateStudentEntity updateStudentEntity=new UpdateStudentEntity();

            //写入原数据
            try {
                updateStudentEntity.setUpdateStudentEntity(readStudentEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(updateStudentEntity.toString());

            //新数据覆盖原数据
            updateStudentEntity.setFromSchoolBean(bean);


            //更新数据
            if (updateUser(updateStudentEntity)){
                return true;
            }else {
                return false;
            }
        } else {
            return null;
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
    public Boolean signUpAdministrator(SignBean newSignBean) {

        String newrole = newSignBean.getRole();

        SignEntity newSignEntity = new SignEntity(newSignBean.getBasis(), newSignBean.getId(), newSignBean.getPassword());

        if (newrole.equals("Administrator")) {
            adminMapper.signUpAdministrator(newSignEntity);
            System.out.println("Administrator Sign Up is OK !");
            System.out.println(newSignEntity.toString());
            return true;
        } else {
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
            studentMapper.updateStudent(updateStudentEntity);
            return true;
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

    @Override
    public List<String> getTeacherList(String departmentId) {
        List<ReadTeacherEntity> teacherEntityList=teacherMapper.selectTeacherByDepartmentId(departmentId);
        System.out.println("1.--------------------------------------------------");
        System.out.println(teacherEntityList);

        List<String> teacherList=new ArrayList<>();
        for (ReadTeacherEntity tea:teacherEntityList) {

            teacherList.add(tea.getId()+"_"+tea.getName());

        }
        System.out.println(teacherList);
        System.out.println("1.--------------------------------------------------");
        return teacherList;
    }



}
