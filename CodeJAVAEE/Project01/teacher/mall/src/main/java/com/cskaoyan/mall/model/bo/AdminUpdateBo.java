package com.cskaoyan.mall.model.bo;

/**
 * @author panda
 * @description:修改管理员资料
 * email: "1105935892@qq.com"
 * id: 151
 * nickname: "aaasss"
 * pwd: "HKJhkjhkjhjk&*((234"
 * @date 2021/4/19 21:57
 */
public class AdminUpdateBo {

    private String email;

    private Integer id;

    private String pwd;

    private String nickname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
