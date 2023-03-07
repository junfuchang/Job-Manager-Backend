package com.job.modules.Login.dto;

import lombok.Data;

@Data
public class CompanyRegister {
    /**
     * 账户
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 公司类型
     */
    private String type;
    /**
     * 社会信用代码
     */
    private Integer code;
    /**
     * 联系方式（手机号）
     */
    private String contact;
    /**
     * 地址
     */
    private String address;
    /**
     * 网站
     */
    private String website;
    /**
     * 备注
     */
    private String remark;
    /**
     * 备注
     */
    private String pic;
    /**
     * 角色
     */
    private Integer roleId;
}
