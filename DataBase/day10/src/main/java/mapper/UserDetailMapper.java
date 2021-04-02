package mapper;

import dto.User;

public interface UserDetailMapper {

    User selectUserDetail(String username);
}
