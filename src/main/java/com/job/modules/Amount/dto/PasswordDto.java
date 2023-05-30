package com.job.modules.Amount.dto;

import lombok.Data;

@Data
public class PasswordDto {
//    账户Id
    private Integer amountId;
//    旧密码
    private String prePassword;
//    新密码
    private String password;
}
