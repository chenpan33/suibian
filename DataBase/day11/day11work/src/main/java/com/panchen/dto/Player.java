package com.panchen.dto;

import lombok.Data;

/**
 * @author panda
 * @description:player对象与BallArmy实现多对多关系
 * @date 2021/4/1 19:46
 */
@Data
public class Player {
    private Integer id;
    private String name;
    private Integer armyId;
}
