package com.cskaoyan.mall.model.vo;

/**
 * @author panda
 * @description:user返回的json中的data数据
 * @date 2021/4/20 10:51
 */
public class AllUsersVO {
    private Integer id;
    private String email;
    private String nickname;
    private String pwd;
    private String recipient;
    private String address;
    private String phone;

    public AllUsersVO(Integer id, String email, String nickname, String pwd, String recipient, String address, String phone) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.pwd = pwd;
        this.recipient = recipient;
        this.address = address;
        this.phone = phone;
    }

    public AllUsersVO() {
    }

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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}