package com.job.common.domain.Login;

import com.job.common.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component("role")
public class RolePermissionCheck {
    public Boolean isAllow(String min_role){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List authorities = (List)authentication.getAuthorities();
        Integer userRole = Integer.parseInt(((SimpleGrantedAuthority) authorities.get(0)).getAuthority());  // 用户拥有的权限
        if(userRole>= Role.getCode(min_role)){
            return true;
        }
        return false;
    }
}
