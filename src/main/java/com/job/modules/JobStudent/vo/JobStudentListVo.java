package com.job.modules.JobStudent.vo;

import com.job.entities.JobStudent;
import lombok.Data;

import java.util.Date;

@Data
public class JobStudentListVo extends JobStudent {
    private Integer studentId;
    private String name;
    private Integer gender;
    private Date birthday;
    private String avatar;
    private String contact;
    private String resume;
    private String major;
}
