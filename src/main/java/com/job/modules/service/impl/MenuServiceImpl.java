package com.job.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.Menu;
import com.job.modules.service.MenuService;
import com.job.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2023-03-01 13:02:40
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




