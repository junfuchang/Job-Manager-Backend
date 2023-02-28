package com.job.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.Role;
import com.job.modules.service.RoleService;
import com.job.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【role】的数据库操作Service实现
* @createDate 2023-02-26 23:04:40
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




