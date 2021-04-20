package com.cskaoyan.mall.service;

import com.cskaoyan.mall.model.bo.*;
import com.cskaoyan.mall.model.vo.AllAdminsVO;
import com.cskaoyan.mall.model.vo.AllUsersVO;

import java.util.List;

public interface UserService {

    List<AllUsersVO> allUser();
    void deleteUser(int id);
    List<AllUsersVO> searchUser(String nickname);
}
