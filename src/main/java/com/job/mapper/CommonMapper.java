package com.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.job.modules.Common.Vo.CommonVo;
import com.job.modules.Common.Vo.SalaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonMapper extends BaseMapper {
    List<CommonVo> selectAllDirection();
    List<CommonVo> selectAllDegree();

    SalaryVo selectAllSalary();

    Number selectOverviewMap(@Param("locationCode")  String locationCode);

}
