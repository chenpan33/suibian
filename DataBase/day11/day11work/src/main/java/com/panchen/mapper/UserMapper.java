package com.panchen.mapper;

import com.panchen.dto.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author panda
 * @description:连接user表
 * @date 2021/4/2 19:24
 */
public interface UserMapper {
//分次查询
    User selectUserWithDetailById(@Param("id") Integer id);

}
