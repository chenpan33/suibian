package com.cskaoyan.mall.service;

import com.cskaoyan.mall.dao.AdminDao;
import com.cskaoyan.mall.model.Admin;
import com.cskaoyan.mall.model.bo.AdminLoginBo;
import com.cskaoyan.mall.model.vo.AllAdminsVO;
import com.cskaoyan.mall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panda
 * @description:实现具体的从数据路查询登录是否通过的相关信息
 * @date 2021/4/18 13:17
 */
public class AdminServiceImpl implements AdminService{

    //进行是否登录成功的判断
    @Override
    public int login(AdminLoginBo loginBo) {
        //在数据库中进行查询---->Dao文件就是进行数据库查询的mapper接口
        //loginBo session--->adminDao  admin   count判断admin结果的返回码
        //admin是创建的管理员对象 adminDao是连接将admin对象到数据库中进行查询的过程
        //1.建立与数据库之间的连接
        SqlSession session = MybatisUtils.getSession();
        AdminDao adminDao = session.getMapper(AdminDao.class);//创建admin进入数据库操作的入口
        //2.创建接受进来的对象admin
        Admin admin = new Admin();
        admin.setUsername(loginBo.getEmail());
        admin.setPassword(loginBo.getPwd());

        //3.count代表输入的admin结果是怎样的
        // todo: 在adminDao的mapper.xml文件中设置结果 200 404 500
        try {
            int count=adminDao.login(admin);
            if(count==0){
                //count==0代表没有该账号
                return 404;
            }else if(count==1){
                //count==1代表有这个账号
                return 200;
            }
        }catch (Exception e){
            //tips:管理session
        }finally {
            session.commit();
            session.close();
        }
        //其他异常返回500
        return 500;
    }
    //将新建的管理员账号添加到管理员书列表中
    //todo:adminDao的mapper.xml 将管理员账号添加到列表
    @Override
    public List<AllAdminsVO> allAdmins() {
        //1. session
        SqlSession session = MybatisUtils.getSession();
        AdminDao adminDao = session.getMapper(AdminDao.class);
        //2. 连接显示所有allAdmin
        //2.1数据库里面adminList
        List<Admin> adminList = adminDao.allAdmins();
        //2.2显示到输出界面的adminsVOS
        List<AllAdminsVO> adminsVOS=new ArrayList<>();
        //2.3传输过程
        for (Admin admin : adminList) {
            //--传输工具admin allAdminsVO
            AllAdminsVO adminsVO = new AllAdminsVO(admin.getId(), admin.getUsername(), admin.getNickname(), admin.getPassword());
            adminsVOS.add(adminsVO);
        }
        return adminsVOS;
    }
}
