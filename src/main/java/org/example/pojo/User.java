package org.example.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * value指定主键的字段，type设置主键生成策略：1.ASSIGN_UUID雪花算法；2.AUTO自动递增。
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Long id;

    /**
     * 指定属性对应字段名
     */
    @TableField("name")
    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Integer flag;

    @Version
    private Integer version;
}
