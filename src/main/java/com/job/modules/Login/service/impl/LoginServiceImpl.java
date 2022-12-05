package com.job.modules.Login.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(User user) {
        // 利用AuthenticationManager进行用户认证（下面👇这一行就是 UserDetailsServiceImpl 的返回，返回一个UserDetails对象，再将其给authenticationManager来验证是否通过）
        UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(passwordAuthenticationToken);
        if (Objects.isNull(authenticate)) {   // 如果为空表示验证未通过
            throw new BusinessException(Code.BUSINESS_ERR, "登陆失败，认证未通过...");
        }
        // 如果通过认证，这jwt生成token并返回
        UserDetailsImpl principal = (UserDetailsImpl) authenticate.getPrincipal(); // 含有用户信息，用户角色等的认证信息
        String jwt;
        try {
            // 向token中存入哪些信息(UserDetailsImpl类型的信息)
            HashMap<String,String> tokenInfo = new HashMap<>();
            tokenInfo.put("userId",principal.getUser().getUserId().toString());
            tokenInfo.put("role",principal.getUser().getRole().toString());
            // 将tokenInfo转成json字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String tokenJson = objectMapper.writeValueAsString(tokenInfo);
            // 将json信息生成jwt
            jwt = JwtUtils.createJWT(tokenJson);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, "生成TOKEN失败，请稍后再试");
        }
        return jwt;
    }
}
