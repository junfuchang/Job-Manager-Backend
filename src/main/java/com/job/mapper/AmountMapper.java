package com.job.mapper;

import com.job.entities.Amount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author cjf
* @description 针对表【amount】的数据库操作Mapper
* @createDate 2023-02-26 23:04:21
* @Entity com.job.entities.Amount
*/
@Mapper
public interface AmountMapper extends BaseMapper<Amount> {


}




