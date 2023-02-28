package com.job.mapper;

import com.job.entities.JobResume;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cjf
* @description 针对表【job_resume(岗位-简历 关联表)】的数据库操作Mapper
* @createDate 2023-02-26 23:04:32
* @Entity com.job.entities.JobResume
*/
@Mapper
public interface JobResumeMapper extends BaseMapper<JobResume> {

}




