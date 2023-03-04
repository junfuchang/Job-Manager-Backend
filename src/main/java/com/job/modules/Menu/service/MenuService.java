package com.job.modules.Menu.service;

import com.job.common.domain.Result;
import com.job.entities.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.job.modules.Login.vo.MenuItemVo;
import com.job.modules.Menu.dto.UpdateMenuDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author cjf
* @description 针对表【menu】的数据库操作Service
* @createDate 2023-03-01 13:02:40
*/

@Transactional
public interface MenuService extends IService<Menu> {
    List<MenuItemVo> getSonMenu(Integer parentId);
    Result selectMenuList(Integer parentId);

    Result updateMenu(UpdateMenuDto updateMenuDto);
}
