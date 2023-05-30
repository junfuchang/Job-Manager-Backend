package com.job.common.domain.Login;

import com.job.common.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("Permission")
public class RolePermissionCheck {
    /**
     *
     * @param ROLE "ADMIN STUDENT"，"STUDENT"之类的字符串，标识接口能够被哪些角色访问
     * @return
     */
    public Boolean access(String ROLE){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List authorities = (List)authentication.getAuthorities();
        Integer userRoleCode = Integer.parseInt(((SimpleGrantedAuthority) authorities.get(0)).getAuthority());  // 用户拥有的权限CODE

        /**
         * accessRoel : 接口能够被哪些角色访问
         * userRoleCode : 当前访问用户的角色CODE - (之所以用CODE标识当前用户权限，因为数据库中查询出来的字段就是数字)
         * 将
         */
        String[] roleList = ROLE.split(" ");
        for (String accessRole: roleList
             ) {
            if(Role.judge(accessRole,userRoleCode)){
                return true;
            }
        }
        return false;
    }
}
