package com.cskaoyan.mapper;

import com.cskaoyan.dto.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User selectUserWithDetailById(@Param("id") Integer id);
    User selectUserWithDetailById2(@Param("id") Integer id);

}
