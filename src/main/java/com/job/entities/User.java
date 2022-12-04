package com.job.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "Users")
public class User {
    @TableId(value = "user_id")
    private Integer userId;

    @TableField(value = "major_id")
    private Integer majorId;

    private String username;

    private String password;

    private Integer role;

    @TableField(value = "admission_Time")
    private Date admissionTime;

    @TableField(value = "create_time")
    private Date createTime;

    @TableLogic(value = "0" ,delval = "1")
    private String deleted;

}

