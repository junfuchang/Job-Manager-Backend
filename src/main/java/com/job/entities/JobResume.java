package com.job.entities;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 岗位-简历 关联表
 * @TableName job_resume
 */
@TableName(value ="job_resume")
@Data
public class JobResume implements Serializable {
    /**
     * 岗位-简历表
     */
    @TableId(type = IdType.AUTO)
    private Integer jobResumeId;

    /**
     * 外键：岗位ID
     */
    private Integer jobId;

    /**
     * 外键：简历ID
     */
    private Integer resumerId;

    /**
     * 简历投递时间
     */
    private Date date;

    /**
     * 删除标识
     */
    @TableLogic(value = "0" ,delval = "1")
    private Integer deleteFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        JobResume other = (JobResume) that;
        return (this.getJobResumeId() == null ? other.getJobResumeId() == null : this.getJobResumeId().equals(other.getJobResumeId()))
            && (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getResumerId() == null ? other.getResumerId() == null : this.getResumerId().equals(other.getResumerId()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJobResumeId() == null) ? 0 : getJobResumeId().hashCode());
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getResumerId() == null) ? 0 : getResumerId().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jobResumeId=").append(jobResumeId);
        sb.append(", jobId=").append(jobId);
        sb.append(", resumerId=").append(resumerId);
        sb.append(", date=").append(date);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}