package com.job.modules.Login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.Menu;
import com.job.modules.Login.service.MenuService;
import com.job.mapper.MenuMapper;
import com.job.modules.Login.vo.MenuItemVo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
* @author cjf
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2023-03-01 13:02:40
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuItemVo> getSonMenu(Integer parentId) {
        List<MenuItemVo> menuList = menuMapper.getSonMenuSql(parentId);
        return menuList;
    }

}




