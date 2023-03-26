package com.job.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.job.entities.Job;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.job.modules.Job.vo.JobListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
* @author cjf
* @description 针对表【job】的数据库操作Mapper
* @createDate 2023-02-26 23:04:30
* @Entity com.job.entities.Job
*/
@Mapper
public interface JobMapper extends BaseMapper<Job> {
    Page<JobListVo> selectJobList(Page<JobListVo> page, @Param("map") HashMap map);
}




