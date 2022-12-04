package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class JoinCompany {
    @TableId(value = "id")
    private Integer id;

    @TableField(value = "job_fair_id")
    private Integer jobFairId;

    @TableField(value = "company_id")
    private Integer companyId;
}
