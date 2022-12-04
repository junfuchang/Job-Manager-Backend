package com.job.common.exception;

import com.job.common.enums.Code;

public class SystemException extends RuntimeException{
    private Integer code = Code.SYSTEM_ERR;

    public SystemException() {
    }

    public SystemException(Integer code) {
        this.code = code;
    }

    public SystemException( Integer code ,String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code,String message, Throwable cause ) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
