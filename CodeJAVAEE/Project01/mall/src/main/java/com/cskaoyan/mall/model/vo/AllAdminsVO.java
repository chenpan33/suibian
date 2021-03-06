package com.cskaoyan.mall.model.vo;

/**
 * @author panda
 * @description:展示管理员的所有信息
 * @date 2021/4/18 10:43
 */
public class AllAdminsVO {
    private Integer id;
    private String email;
    private String nickname;
    private String pwd;


    //构造函数
    public AllAdminsVO(Integer id, String email, String nickname, String pwd) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.pwd = pwd;
    }

    public AllAdminsVO() {
    }


    //get set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
