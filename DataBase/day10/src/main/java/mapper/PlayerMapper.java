package mapper;

import dto.Player;

/**
 * @author panda
 * @description:
 * @date 2021/4/1 19:52
 */
public interface PlayerMapper {
    Player  selectPlayer(String name);
}
