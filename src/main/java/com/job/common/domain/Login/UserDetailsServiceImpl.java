package com.job.common.domain.Login;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.User;
import com.job.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, username);
        User user = userMapper.selectOne(lqw);
        if (Objects.isNull(user)) {
            throw new BusinessException(Code.BUSINESS_ERR, "用户名错误，请重新输入！");
        }


        // 查询用户信息

        // 需要返回UserDetails类型的对象
        return new UserDetailsImpl(user);
    }
}
