package com.job.common.domain.Login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.common.domain.Result;
import com.job.common.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result result = new Result(HttpStatus.FORBIDDEN.value(),null,"用户权限不足。");
        String responseJson = new ObjectMapper().writeValueAsString(result);
        ResponseUtil.write(response,responseJson);
    }
}
