package com.cskaoyan.mall.dao;

import com.cskaoyan.mall.model.Admin;
import com.cskaoyan.mall.model.User;

import java.util.List;

public interface UserDao {

    List<User> allUser();
    void deleteUser(int id);
    List<User> searchUser(String nickname);
}
