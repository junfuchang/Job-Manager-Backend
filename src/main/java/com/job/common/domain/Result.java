package com.job.common.domain;

import com.job.common.enums.Code;
import lombok.Data;

@Data
public class Result {
    private Integer code = Code.SUCCESS;
    private Object data = null;
    private String message = null;

    public Result(){
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
