package com.job.modules.Login.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuItemVo {
    /**
     * 菜单id
     */
    private Integer menuId;

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
    private String pathRoute;

    /**
     * 对应组件的路径
     */
    private String pathName;

    /**
     * 菜单对应的class名称,主要用于设置菜单的ICON
     */
    private String menuImgClass;

    /**
     * 父级菜单的menuId, 没有父级时，值设置为0
     */
    private Integer pId;

    /**
     * 菜单的状态，0 有效，1无效
     */
    private String menuState;

    /**
     * 是否包含子组件中
     */
    private Boolean isContainChildren;

    /**
     * 子菜单列表，必须是数组类型
     */
    private List<MenuItemVo> menuChilds;

}
