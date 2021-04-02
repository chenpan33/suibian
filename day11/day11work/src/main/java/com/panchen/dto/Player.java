package dto;

import lombok.Data;

/**
 * @author panda
 * @description:与BallArmy实现多对多关系
 * @date 2021/4/1 19:46
 */
@Data
public class Player {
    private int id;
    private String name;
    private int armyId;
}
