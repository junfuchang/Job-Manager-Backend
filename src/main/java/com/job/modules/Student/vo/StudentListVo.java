package com.job.modules.Student.vo;

import com.job.entities.Student;
import lombok.Data;

@Data
public class StudentListVo extends Student {
    private String majorName;
    private String username;
    private Integer amountId;
    private Integer majorId;
    private Integer collegeId;
}
