package com.job.modules.Menu.controller;

import com.job.common.domain.Result;
import com.job.entities.Menu;
import com.job.modules.Menu.dto.UpdateMenuDto;
import com.job.modules.Menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping("/selectMenuList")
    @PostAuthorize("@Permission.access('ADMIN')")
    public Result selectSonMenuList(@RequestBody Menu menu){
        return menuService.selectMenuList(menu.getMenuId());
    }

    @PostMapping("/updateMenu")
    @PostAuthorize("@Permission.access('ADMIN')")
    public Result updateMenu(@RequestBody UpdateMenuDto updateMenuDto){
        return menuService.updateMenu(updateMenuDto);
    }
}
