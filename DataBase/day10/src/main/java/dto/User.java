package dto;

import lombok.Data;

/**
 * @author panda
 * @description:User类对应数据库中配置数据user类有id,name,age
 * @date 2021/4/1 9:28
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
}
