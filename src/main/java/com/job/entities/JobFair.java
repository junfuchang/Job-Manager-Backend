package com.job.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class JobFair {
   @TableId(value = "job_fair_id")
   private Integer jobFairId;

   private String name;

   private Date time;

   private String address;

   private String remark;

   private Boolean count;

   @TableField(value = "person_num")
   private Integer personNum;

//   https://www.bilibili.com/video/BV1Fi4y1S7ix?p=117&vd_source=5ff99f2a554bb47ade80e6b6ecddb05b
//   @Version
   private Integer version;
}
