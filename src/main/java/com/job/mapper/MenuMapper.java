package com.job.mapper;

import com.job.entities.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.job.modules.Login.vo.MenuItemVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author cjf
* @description 针对表【menu】的数据库操作Mapper
* @createDate 2023-03-01 13:02:40
* @Entity com.job.entities.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<MenuItemVo> getSonMenuSql (@Param("parentId") Integer parentId);
    List<MenuItemVo> getTopMenuList (@Param("roleId") Integer roleId);
}




