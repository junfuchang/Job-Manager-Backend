package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "Colleges")
public class College {
    @TableId(value = "college_id")
    private Integer collegeId;

    private String college;
}
