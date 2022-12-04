package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class JoinUser {
    @TableId(value = "major_id")
    private Integer id;

    @TableField(value = "job_fair_id")
    private Integer jobFairId;

    @TableField(value = "user_id")
    private Integer userId;

    private Boolean registered;

    private Boolean attended;
}
