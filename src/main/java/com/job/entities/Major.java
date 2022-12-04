package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "Majors")
public class Major {
    @TableId(value = "major_id")
    private Integer majorId;

    @TableField(value = "college_id")
    private Integer collegeId;

    private String major;
}
