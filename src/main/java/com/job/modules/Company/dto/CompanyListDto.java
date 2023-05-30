package com.job.modules.Company.dto;

import com.job.entities.Company;
import lombok.Data;

@Data
public class CompanyListDto  extends Company {
    /**
     * 分页参数
     */
    private Integer current ;
    private  Integer pageSize ;
}
