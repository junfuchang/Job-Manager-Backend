package com.job.mapper;

import com.job.entities.Resume;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cjf
* @description 针对表【resume】的数据库操作Mapper
* @createDate 2023-02-26 23:04:37
* @Entity com.job.entities.Resume
*/
@Mapper
public interface ResumeMapper extends BaseMapper<Resume> {

}




