package com.job.common.domain.Login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.common.domain.Result;
import com.job.common.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result result = new Result(HttpStatus.UNAUTHORIZED.value(),null,"用户认证未通过，请重新登陆。");
        String responseJson = new ObjectMapper().writeValueAsString(result);
        ResponseUtil.write(response,responseJson);
    }
}
