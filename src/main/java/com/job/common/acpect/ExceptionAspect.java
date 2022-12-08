package com.job.common.acpect;

import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.common.exception.SystemException;
import com.job.common.domain.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAspect {
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        return new Result(e.getCode(),null,e.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        return new Result(e.getCode(),null,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        return new Result(Code.UNKNOWN_ERR,null,e.getMessage());
    }
}
