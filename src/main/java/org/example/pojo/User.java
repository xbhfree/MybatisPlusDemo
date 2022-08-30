package org.example.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Integer flag;

    @Version
    private Integer version;
}
