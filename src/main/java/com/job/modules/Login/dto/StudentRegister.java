package com.job.modules.Login.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentRegister {
    /**
     * 账户
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private Integer studentId;
    /**
     * 专业ID
     */
    private Integer  majorId;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 联系方式（手机号）
     */
    private String  contact;
    /**
     * 地址
     */
    private String address;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 角色
     */
    private Integer roleId;

}
