package com.job.modules.Job.vo;

import com.job.entities.Job;
import lombok.Data;

import java.util.Date;

@Data
public class JobListVo extends Job {
    // 公司名称
    private String name;
    private String companyType;
    private String website;
    private String remark;
    private String pic;
}
