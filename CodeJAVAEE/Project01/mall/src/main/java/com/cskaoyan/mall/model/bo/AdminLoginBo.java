package com.cskaoyan.mall.model.bo;

/**
 * @author panda
 * @description:记录登录接收的变量
 * @date 2021/4/18 10:34
 */
public class AdminLoginBo {
    private String email;
    private String pwd;


    //get set

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
