package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class EmploymentInfo {
    @TableId(value = "id")
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;

    private Boolean employed;

    @TableField(value = "employed_time")
    private Date employedTime;

    @TableField(value = "unique_code")
    private String uniqueCode;

    @TableField(value = "company_name")
    private String companyName;

    private String remark;
}
