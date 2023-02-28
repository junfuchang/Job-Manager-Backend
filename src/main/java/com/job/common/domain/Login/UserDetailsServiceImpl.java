package com.job.common.domain.Login;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.Amount;
import com.job.mapper.AmountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AmountMapper amountMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Amount> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Amount::getUsername, username);
        Amount amount = amountMapper.selectOne(lqw);
        if (Objects.isNull(amount)) {
            throw new BusinessException(Code.BUSINESS_ERR, "用户名错误，请重新输入！");
        }
        String role = "0";
        if(!String.valueOf(amount.getRoleId()).equals("")){
            role = amount.getRoleId().toString();
        }
        // 需要返回UserDetails类型的对象
        return new UserDetailsImpl(amount,role);
    }
}
