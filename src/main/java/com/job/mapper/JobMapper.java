package com.job.mapper;

import com.job.entities.Job;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cjf
* @description 针对表【job】的数据库操作Mapper
* @createDate 2023-02-26 23:04:30
* @Entity com.job.entities.Job
*/
@Mapper
public interface JobMapper extends BaseMapper<Job> {

}




