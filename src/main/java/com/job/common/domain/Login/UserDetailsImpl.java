package com.job.common.domain.Login;

import com.job.entities.Amount;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private Amount amount;

    private String role;

    /**
     * 该参数仅用于权限校验，无需构造方法传入
     */
    private List<SimpleGrantedAuthority> authorities;

    public UserDetailsImpl(Amount amount, String role) {
        this.amount = amount;
        this.role = role;
    }

    @Override
    public Collection getAuthorities() {
        if(Objects.nonNull(authorities)){
            return authorities;
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        authorities = Arrays.asList(authority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return amount.getPassword();
    }

    @Override
    public String getUsername() {
        return amount.getUsername();
    }

    /**
     * 下面四个方法表示是否有对应的凭证，选择全部放行（返回值设置为true）
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }


}
