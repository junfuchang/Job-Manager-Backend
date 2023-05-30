package com.job.modules.Amount.dto;

import com.job.entities.Amount;
import lombok.Data;

@Data
public class AmountListDto extends Amount {
    /**
     * 分页参数
     */
    private Integer current ;
    private  Integer pageSize ;

}
