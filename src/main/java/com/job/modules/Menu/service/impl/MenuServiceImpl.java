package com.job.modules.Menu.service.impl;

import ch.qos.logback.core.util.COWArrayList;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.MyPage;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.Amount;
import com.job.entities.Menu;
import com.job.entities.RoleMenu;
import com.job.mapper.MenuMapper;
import com.job.mapper.RoleMenuMapper;
import com.job.modules.Login.vo.MenuItemVo;
import com.job.modules.Menu.dto.UpdateMenuDto;
import com.job.modules.Menu.service.MenuService;
import com.job.modules.Menu.vo.SelectMenuListVo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author cjf
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2023-03-01 13:02:40
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 递归返回菜单项
     */
    @Override
    public List<MenuItemVo> getSonMenu(Integer parentId) {
        List<MenuItemVo> menuList = menuMapper.getSonMenuSql(parentId);
        return menuList;
    }

    /**
     * 菜单列表查询
     * 菜单业务要求不允许增删，没几条数据，就不进行分页了
     */
    @Override
    public Result selectMenuList(Integer parentId) {
        if(parentId == null){
            parentId =0;
        }
        if(parentId == 0 || parentId ==null){
            Page<SelectMenuListVo> page1 = new Page<>(1,100);
            IPage<SelectMenuListVo> selectMenuListVoIPage = menuMapper.selectTopMenuList(page1);
            List<SelectMenuListVo> records = selectMenuListVoIPage.getRecords();
            for (SelectMenuListVo item :records
                 ) {
                item.setRoleIds(menuMapper.getMenuRole(item.getMenuId()));
            }
            selectMenuListVoIPage.setRecords(records);
            return new Result(selectMenuListVoIPage);
        }

        Page<Menu> page2 = new Page<>(1,100);
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getParentId,parentId);
        return new Result(menuMapper.selectPage(page2,queryWrapper));
    }

    @Override
    public Result updateMenu(UpdateMenuDto updateMenuDto) {
        if(updateMenuDto.getMenuId() == null){
            throw  new BusinessException(Code.BUSINESS_ERR,"修改菜单需要传入菜单ID");
        }

        // 对菜单属性的修改
        Menu menu = menuMapper.selectById(updateMenuDto.getMenuId());
        if(updateMenuDto.getMenuName() != null){
            menu.setMenuName(updateMenuDto.getMenuName());
        }
        if(updateMenuDto.getMenuOrder() != null){
            menu.setMenuOrder(updateMenuDto.getMenuOrder());
        }
        if(updateMenuDto.getMenuImgClass() != null){
            menu.setMenuImgClass(updateMenuDto.getMenuImgClass());
        }
        menuMapper.updateById(menu);

        // 对菜单角色的处理
        ArrayList<Integer> roleIds = updateMenuDto.getRoleIds();
        // 遍历三种角色
        for (int i = 0; i < 3; i++) {
            LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(RoleMenu::getMenuId,updateMenuDto.getMenuId());
            queryWrapper.eq(RoleMenu::getRoleId,i);
            RoleMenu one = roleMenuMapper.selectOne(queryWrapper);
            // 如果表中不存在，返回值中存在，就插入
            if(one == null && roleIds.contains(i) ){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(i);
                roleMenu.setMenuId(updateMenuDto.getMenuId());
                roleMenuMapper.insert(roleMenu);
            }
            // 如果表中存在，返回值中不存在，就删除  // 其他情况都是要么全存在要么全不存在，就不用任何操作
            else if(one != null && !roleIds.contains(i)){
                roleMenuMapper.delete(queryWrapper);
            }
        }

        return  new Result(true);
    }
}




