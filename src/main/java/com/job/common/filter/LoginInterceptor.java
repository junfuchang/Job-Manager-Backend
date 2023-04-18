package com.job.common.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 弃用：token验证交给JwtAuthenticationTokenFilter，以便与spring security结合
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("LoginInterceptor");
//        String token = request.getHeader("token");
//        // 如果为空，则直接放行（因为后面的拦截器也会对其拦截）
//        if(!StringUtils.hasText(token)){
////            throw new BusinessException(Code.BUSINESS_ERR,"token不存在，请重新登陆。");
//            return true;
//        }
//        // token校验失败或者过期则抛出异常
//        User user;
//        try{
//            // 返回的是user对像的json形式
//            String parseJWT = JwtUtils.parseJWT(token).getSubject();
//            if(JwtUtils.isExpiration(token)){
//                throw new Exception("token已过期，请重新登陆。");
//            }
//            user = new ObjectMapper().readValue(parseJWT, User.class);
//            // TODO 需要提供权限信息
//            // 将用户信息存入权限验证环境，供后续拦截器使用
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,null,null);
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        }catch (Exception e){
//            throw new BusinessException(Code.BUSINESS_ERR,"token非法或者已过期，请重新登陆。");
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
