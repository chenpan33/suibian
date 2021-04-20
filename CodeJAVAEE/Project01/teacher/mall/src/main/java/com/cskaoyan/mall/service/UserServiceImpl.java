package com.cskaoyan.mall.service;

import com.cskaoyan.mall.dao.UserDao;
import com.cskaoyan.mall.model.Admin;
import com.cskaoyan.mall.model.User;
import com.cskaoyan.mall.model.vo.AllUsersVO;
import com.cskaoyan.mall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panda
 * @description:
 * @date 2021/4/20 10:41
 */
public class UserServiceImpl implements UserService{
    @Override
    public List<AllUsersVO> allUser() {
        SqlSession session = MybatisUtils.getSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.allUser();
        ArrayList<AllUsersVO> allUsersVOS = new ArrayList<>();
        for (User user : users) {
            AllUsersVO allUsersVO = new AllUsersVO(user.getId(), user.getEmail(), user.getNickname(), user.getPassword(), user.getRecipient(), user.getAddress(), user.getPhone());
            allUsersVOS.add(allUsersVO);
        }
        session.commit();
        session.close();
        return allUsersVOS;
    }

    @Override
    public void deleteUser(int id) {
        SqlSession session = MybatisUtils.getSession();
        UserDao userDao = session.getMapper(UserDao.class);
        userDao.deleteUser(id);
        session.commit();
        session.close();
    }

    @Override
    public List<AllUsersVO> searchUser(String nickname) {
        SqlSession session = MybatisUtils.getSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.searchUser(nickname);
        ArrayList<AllUsersVO> allUsersVOS = new ArrayList<>();
        for (User user : users) {
            AllUsersVO allUsersVO = new AllUsersVO(user.getId(), user.getEmail(), user.getNickname(), user.getPassword(), user.getRecipient(), user.getAddress(), user.getPhone());
            allUsersVOS.add(allUsersVO);
        }
        session.commit();
        session.close();
        return allUsersVOS;

    }
}
