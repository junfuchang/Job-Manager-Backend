package com.job.common.exception;

import com.job.common.enums.Code;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemException extends RuntimeException{
    private Integer code = Code.SYSTEM_ERR;

    public SystemException( Integer code ,String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code,String message, Throwable cause ) {
        super(message, cause);
        this.code = code;
    }
}
