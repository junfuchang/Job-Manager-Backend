package com.job.mapper;

import com.job.entities.College;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.job.modules.College.vo.CollegeVisualVo;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Array;
import java.util.List;

/**
* @author cjf
* @description 针对表【college(学院表)】的数据库操作Mapper
* @createDate 2023-02-26 23:04:24
* @Entity com.job.entities.College
*/
@Mapper
public interface CollegeMapper extends BaseMapper<College> {
     List<CollegeVisualVo> selectRateData();
}




