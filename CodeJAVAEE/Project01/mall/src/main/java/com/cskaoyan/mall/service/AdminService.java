package com.cskaoyan.mall.service;

import com.cskaoyan.mall.model.bo.AdminLoginBo;
import com.cskaoyan.mall.model.vo.AllAdminsVO;

import java.util.List;

/**
 * @author panda
 * @description:用接口确定要实现的功能,具体操作逻辑使用下面的继承接口的类来实现
 * @date 2021/4/18 10:33
 */
public interface AdminService {
    //方法一"登录", 通过接收的文件loginBo返回int返回码, 根据返回码确定返回结果
    int login(AdminLoginBo loginBo);
    //方法二"获取所有管理员"
    List<AllAdminsVO> allAdmins();

}
