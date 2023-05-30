package com.job.entities;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 学院表
 * @TableName college
 */
@TableName(value ="college")
@Data
public class College implements Serializable {
    /**
     * 学院ID
     */
    @TableId(type = IdType.AUTO)
    private Integer collegeId;

    /**
     * 学院名称
     */
    private String name;

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
        College other = (College) that;
        return (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collegeId=").append(collegeId);
        sb.append(", name=").append(name);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}