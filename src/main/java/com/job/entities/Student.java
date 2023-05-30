package com.job.entities;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    /**
     * 学生学号ID
     */
    @TableId(type = IdType.AUTO)
    private Integer studentId;

    /**
     * 账户ID
     */
    private Integer amountId;

    /**
     * 专业ID
     */
    private Integer majorId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 简历
     */
    private String resume;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 是否毕业：未毕业0，毕业1
     */
    private Integer graduateFlag;

    /**
     * 就业方向：升学0，就业1，待业2
     */
    private Integer direction;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 毕业时间
     */
    private Date date;

    /**
     * 学历：无0，学士1，硕士2，博士3
     */
    private Integer degree;

    /**
     * 薪资
     */
    private Integer salary;

    /**
     * 行业
     */
    private String industry;

    /**
     * 岗位
     */
    private String post;

    /**
     * 备注
     */
    private String remark;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 毕业城市
     */
    private String city;

    /**
     * 删除标识
     */
    @TableLogic(value = "0" ,delval = "1")
    private Integer deleteFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}