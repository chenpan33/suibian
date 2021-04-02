package mapper;

import dto.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author panda
 * @description:批量输入的接口
 * @date 2021/4/1 19:19
 */
public interface UserMapper {
    int insertUsers1(List<User> users);
    int insertUsers2(@Param("users") List<User> users);
    int updateSelectiveUser3(@Param("user")User user);
}
