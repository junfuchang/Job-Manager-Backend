package com.job.modules.Login.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuItemVo {
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 父级菜单的menuId, 没有父级时，值设置为0
     */
    private Integer parentId;
    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单的路径，注如果子菜单要显示在父菜单中，那路径一定要有父级的路径
     */
    private String menuUrl;

    /**
     * 菜单路径名称，暂时没用
     */
    private String pathName;

    /**
     * 组件路径
     */
    private String componentPath;

    /**
     * 菜单对应的class名称,主要用于设置菜单的ICON
     */
    private String menuImgClass;

    /**
     * 菜单的状态，0 有效，1无效
     */
    private Integer menuState;

    /**
     * 是否包含子组件中
     */
    private Boolean isContainChildren;

    /**
     * 子菜单列表，必须是数组类型
     */
    private List<MenuItemVo> menuChilds  = new ArrayList<>();

}
