package com.job.common.config;

import com.job.common.acpect.ExceptionAspect;
import com.job.common.domain.Login.AccessDeniedHandlerImpl;
import com.job.common.domain.Login.AuthenticationEntryPointImpl;
import com.job.common.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring security 配置
 * 5.7版本之后使用 @EnableWebSecurity 注解标识配置类
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 开启权限控制
public class WebSecurityConfig {
    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;
    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;

    /**
     * SecurityFilterChain  SecurityFilter拦截链
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 基于 token，不需要 csrf
                .csrf().disable()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 设置认证失败、鉴权失败时的返回
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler).and()
                // 下面开始设置权限
                .authorizeRequests(authorize -> authorize
                        // 允许匿名访问
                        .antMatchers("/login","/login/**").permitAll()
                        .antMatchers("/major","/major/**").permitAll()
                        .antMatchers("/file","/file/**").permitAll()
                        .antMatchers("/v3/**", "/swagger-resources/**", "/swagger-ui/**", "/webjars/**").permitAll()
                        // 其他地址的访问需验证权限
                        .anyRequest().authenticated()
                )
                // 添加 JWT 过滤器，JWT 过滤器在用户名密码认证过滤器之前
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                // 允许跨域
                .cors().and()
                .build();
    }

    /**
     * jwt 校验过滤器，从 http 头部 Authorization 字段读取 token 并校验
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 配置用户登陆加解密工具
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
