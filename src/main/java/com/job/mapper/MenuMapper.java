package com.job.mapper;

import com.job.entities.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cjf
* @description 针对表【menu】的数据库操作Mapper
* @createDate 2023-03-01 13:02:40
* @Entity com.job.entities.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}




