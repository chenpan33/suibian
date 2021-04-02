package com.panchen.dto;

import lombok.Data;

/**
 * @author panda
 * @description:与user实现一对一关系,id,sign
 * @date 2021/4/1 19:46
 */
@Data
public class UserDetail {
    private Integer id;
    private Integer uid;
    private Integer age;
    private String sign;
}
