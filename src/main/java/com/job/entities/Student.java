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
     * 简历ID
     */
    private Integer resumeId;

    /**
     * 姓名
     */
    private String name;

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
        Student other = (Student) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getAmountId() == null ? other.getAmountId() == null : this.getAmountId().equals(other.getAmountId()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getGraduateFlag() == null ? other.getGraduateFlag() == null : this.getGraduateFlag().equals(other.getGraduateFlag()))
            && (this.getDirection() == null ? other.getDirection() == null : this.getDirection().equals(other.getDirection()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getDegree() == null ? other.getDegree() == null : this.getDegree().equals(other.getDegree()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getPost() == null ? other.getPost() == null : this.getPost().equals(other.getPost()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getAmountId() == null) ? 0 : getAmountId().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getGraduateFlag() == null) ? 0 : getGraduateFlag().hashCode());
        result = prime * result + ((getDirection() == null) ? 0 : getDirection().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getDegree() == null) ? 0 : getDegree().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getPost() == null) ? 0 : getPost().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", amountId=").append(amountId);
        sb.append(", majorId=").append(majorId);
        sb.append(", resumerId=").append(resumeId);
        sb.append(", gender=").append(gender);
        sb.append(", contact=").append(contact);
        sb.append(", address=").append(address);
        sb.append(", graduateFlag=").append(graduateFlag);
        sb.append(", direction=").append(direction);
        sb.append(", avatar=").append(avatar);
        sb.append(", date=").append(date);
        sb.append(", degree=").append(degree);
        sb.append(", salary=").append(salary);
        sb.append(", industry=").append(industry);
        sb.append(", post=").append(post);
        sb.append(", remark=").append(remark);
        sb.append(", birthday=").append(birthday);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}