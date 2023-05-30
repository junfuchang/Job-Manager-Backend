package com.job.common.exception;

import com.job.common.enums.Code;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private Integer code = Code.BUSINESS_ERR;

    public BusinessException( Integer code ,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code,String message, Throwable cause ) {
        super(message, cause);
        this.code = code;
    }
}
