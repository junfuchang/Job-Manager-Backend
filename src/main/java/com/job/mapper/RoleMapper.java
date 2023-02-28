package com.job.mapper;

import com.job.entities.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cjf
* @description 针对表【role】的数据库操作Mapper
* @createDate 2023-02-26 23:04:40
* @Entity com.job.entities.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}




