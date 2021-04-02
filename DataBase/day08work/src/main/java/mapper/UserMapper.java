package mapper;

import dto.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author panda
 * @description:mybatis测试,增加,查询
 * @date 2021/3/30 18:19
 */
public interface UserMapper {

    User selectUser(Integer id);
    User selectUser2(@Param("id") Integer id);
    Integer insertUser1(User user);
    Integer insertUser2(@Param("user2") User user);
    Integer insertUser3(String username,
                        String password,
                        int age,
                        String gender);
    Integer insertUser4(@Param("user4nName")String username,
                        @Param("user4Psd")String password,
                        @Param("user4Age")int age,
                        @Param("user4Gender")String gender);
}

