package com.job.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.common.utils.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        // 如果为空，则直接放行（因为后面的拦截器也会对其拦截）
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }
        // token校验失败或者过期则抛出异常
        HashMap tokenInfo;
        try{
            // 返回的是token信息封装后的json形式
            String parseJWT = JwtUtils.parseJWT(token).getSubject(); // 获取token中的json信息，解析失败则验证未通过
            if(JwtUtils.isExpiration(token)){
                throw new Exception("token已过期，请重新登陆。");
            }
            tokenInfo = new ObjectMapper().readValue(parseJWT, HashMap.class); // json转对象
            // 获取角色信息，并生成供后续鉴权的格式
            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority((String) tokenInfo.get("role")));
            // 将信息存入权限验证环境，供后续拦截器使用
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(tokenInfo,null,authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }catch (Exception e){
//            throw new BusinessException(Code.BUSINESS_ERR,"token非法或者已过期，请重新登陆。");
        }
        filterChain.doFilter(request,response);
    }
}
