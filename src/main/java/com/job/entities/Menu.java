package com.job.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @TableName menu
 */
@TableName(value ="menu")
@Data
@Mapper
public class Menu implements Serializable {
    /**
     * 菜单id
     */
    @TableId(type = IdType.AUTO)
    private Integer menuId;

    /**
     * 父菜单的id
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单路由（子菜单的话需要包含父菜单路径）
     */
    private String menuUrl;

    /**
     * 菜单路由名称（用于配置路由名称）
     */
    private String pathName;

    /**
     * 前端组件
     */
    private String componentPath;

    /**
     * 菜单ICON
     */
    private String menuImgClass;

    /**
     * 是否启用菜单项
     */
    private Integer menuState;

    /**
     * 是否包含子菜单
     */
    private Integer isContainChildren;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Menu other = (Menu) that;
        return (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuUrl() == null ? other.getMenuUrl() == null : this.getMenuUrl().equals(other.getMenuUrl()))
            && (this.getPathName() == null ? other.getPathName() == null : this.getPathName().equals(other.getPathName()))
            && (this.getComponentPath() == null ? other.getComponentPath() == null : this.getComponentPath().equals(other.getComponentPath()))
            && (this.getMenuImgClass() == null ? other.getMenuImgClass() == null : this.getMenuImgClass().equals(other.getMenuImgClass()))
            && (this.getMenuState() == null ? other.getMenuState() == null : this.getMenuState().equals(other.getMenuState()))
            && (this.getIsContainChildren() == null ? other.getIsContainChildren() == null : this.getIsContainChildren().equals(other.getIsContainChildren()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuUrl() == null) ? 0 : getMenuUrl().hashCode());
        result = prime * result + ((getPathName() == null) ? 0 : getPathName().hashCode());
        result = prime * result + ((getComponentPath() == null) ? 0 : getComponentPath().hashCode());
        result = prime * result + ((getMenuImgClass() == null) ? 0 : getMenuImgClass().hashCode());
        result = prime * result + ((getMenuState() == null) ? 0 : getMenuState().hashCode());
        result = prime * result + ((getIsContainChildren() == null) ? 0 : getIsContainChildren().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuId=").append(menuId);
        sb.append(", pId=").append(parentId);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", pathName=").append(pathName);
        sb.append(", componentPath=").append(componentPath);
        sb.append(", menuImgClass=").append(menuImgClass);
        sb.append(", menustate=").append(menuState);
        sb.append(", isContainChildren=").append(isContainChildren);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}