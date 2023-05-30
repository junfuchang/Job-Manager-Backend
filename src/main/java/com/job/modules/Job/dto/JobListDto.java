package com.job.modules.Job.dto;

import com.job.entities.Job;
import lombok.Data;

@Data
public class JobListDto extends Job {
    private String companyName;
    /**
     * 分页参数
     */
    private Integer current ;
    private  Integer pageSize ;

    private  Integer studentId ;

    // 岗位是否已过时
    private Integer isOpenAndTimely;

}
