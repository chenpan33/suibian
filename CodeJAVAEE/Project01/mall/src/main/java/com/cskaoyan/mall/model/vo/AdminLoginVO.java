package com.cskaoyan.mall.model.vo;

/**
 * @author panda
 * @description:展示管理员登录界面信息
 * @date 2021/4/18 13:11
 */
public class AdminLoginVO {
    private String token;
    private String name;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
