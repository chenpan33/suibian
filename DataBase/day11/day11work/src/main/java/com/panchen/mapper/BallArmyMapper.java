package com.panchen.mapper;

import com.panchen.dto.BallArmy;
import com.panchen.dto.Player;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author panda
 * @description:与player实现多对多关系
 * @date 2021/4/2 19:34
 */
public interface BallArmyMapper {
    //分次查询
    BallArmy selectBallArmyWithPlayerByName(@Param("name") String name);

    List<Player> selectPlayersByBallArmyId(Integer armyId);
}
