package com.panchen.dto;

import lombok.Data;

import java.util.List;

/**
 * @author panda
 * @description:ballarmy对象
 * @date 2021/4/1 19:46
 */
@Data
public class BallArmy {
    private Integer id;
    private String name;
    List<Player> players;
}
