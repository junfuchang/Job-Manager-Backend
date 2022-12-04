package com.job.common.exception;

import com.job.common.enums.Code;

public class BusinessException extends RuntimeException {
    private Integer code = Code.BUSINESS_ERR;

    public BusinessException() {
    }

    public BusinessException(Integer code) {
        this.code = code;
    }

    public BusinessException( Integer code ,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code,String message, Throwable cause ) {
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
