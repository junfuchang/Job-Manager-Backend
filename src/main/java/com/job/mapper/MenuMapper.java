package com.job.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.job.entities.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.job.modules.Login.vo.MenuItemVo;
import com.job.modules.Menu.vo.SelectMenuListVo;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
* @author cjf
* @description 针对表【menu】的数据库操作Mapper
* @createDate 2023-03-01 13:02:40
* @Entity com.job.entities.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 这里两个sql用来返回嵌套的菜单数据，用于动态菜单
     */
    List<MenuItemVo> getSonMenuSql (@Param("parentId") Integer parentId);
    List<MenuItemVo> getTopMenuList (@Param("roleId") Integer roleId);

    /**
     * 用于返回包含角色信息的菜单信息，用在菜单管理
     */
    IPage<SelectMenuListVo> selectTopMenuList(IPage<SelectMenuListVo> page);
    ArrayList<Integer> getMenuRole(@Param("menuId") Integer menuId);
}




