package com.job.modules.JobStudent.dto;

import lombok.Data;

@Data
public class JobStudentDto {
    private Integer jobStudentId;
    private Integer jobId;
    private Integer studentId;

    private Integer feedback;
    private String jobName;
    private String companyName;
    private Integer companyId;

    /**
     * 分页参数
     */
    private Integer current ;
    private  Integer pageSize ;
}
