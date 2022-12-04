package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "Jobs")
public class Job {
    @TableId(value = "id")
    private Integer id;

    @TableField(value="company_id")
    private Integer companyId;

    private String name;

    @TableField(value="release_time")
    private Date releaseTime;

    private String salary;

    private String description;

    private String requirement;

    private String contact;

    private String remark;
}
