package com.job.entities;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("用户")
@TableName(value = "Users")
public class User {
    @ApiModelProperty("用户ID")
    @TableId(value = "user_id")
    private Integer userId;

    @ApiModelProperty("专业编号")
    @TableField(value = "major_id")
    private Integer majorId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("学号")
    @TableField(value = "student_num")
    private String studentNum;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("角色")
    private Integer role;

    @ApiModelProperty("入学时间")
    @TableField(value = "admission_Time")
    private Date admissionTime;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty("是否删除")
    @TableLogic(value = "0" ,delval = "1")
    private String deleted;

}

