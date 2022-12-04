package com.job.modules.Login.service.impl;

import com.job.common.domain.Login.UserDetailsImpl;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.common.exception.SystemException;
import com.job.common.utils.JwtUtils;
import com.job.entities.User;
import com.job.modules.Login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(User user) {
//        利用AuthenticationManager进行用户认证
        UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(passwordAuthenticationToken);
        if (Objects.isNull(authenticate)) {   // 如果为空表示验证未通过
            throw new BusinessException(Code.BUSINESS_ERR, "登陆失败，认证未通过...");
        }
//        如果通过认证，这jwt生成token并返回
        UserDetailsImpl principal = (UserDetailsImpl) authenticate.getPrincipal();
        User principalUser = principal.getUser();
        String jwt;
        try {
            jwt = JwtUtils.createJWT(String.valueOf(principalUser.getUserId()));
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, "生成TOKEN失败，请稍后再试");
        }
        return jwt;
    }
}
