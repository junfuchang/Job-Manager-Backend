package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "Companies")
public class Company {
    @TableId(value = "company_id")
    private Integer companyId;

    @TableField(value = "unique_code")
    private String uniqueCode;

    private String name;

    private String introduce;

    private String address;

    private String contact;

    @TableField(value = "other_info")
    private String otherInfo;

    @TableField(value = "source_school")
    private Boolean sourceSchool;

    private Boolean truthful;

    @TableField(value = "create_time")
    private Date createTime;

    @TableLogic(value = "0" ,delval = "1")
    private String deleted;

}
