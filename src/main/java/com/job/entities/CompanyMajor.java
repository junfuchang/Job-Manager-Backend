package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class CompanyMajor {
    @TableId(value = "id")
    private Integer id;

    @TableField(value = "company_id")
    private Integer companyId;

    @TableField(value = "major_id")
    private Integer majorId;
}
