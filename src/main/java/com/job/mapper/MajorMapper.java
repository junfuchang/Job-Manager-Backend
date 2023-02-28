package com.job.mapper;

import com.job.entities.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.job.modules.Major.vo.SqlItemVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author cjf
* @description 针对表【major(专业表)】的数据库操作Mapper
* @createDate 2023-02-26 23:04:35
* @Entity com.job.entities.Major
*/
@Mapper
public interface MajorMapper extends BaseMapper<Major> {

    List<SqlItemVo> getAllMajors();

}




