package com.job.modules.Student.dto;

import com.job.entities.Student;
import lombok.Data;

@Data
public class StudentListDto extends Student {
    /**
     * 分页参数
     */
    private Integer current ;
    private  Integer pageSize ;



}
