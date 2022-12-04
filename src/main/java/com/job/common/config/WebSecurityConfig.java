package com.job.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.net.Authenticator;

/**
 * spring security 配置
 * 5.7版本之后使用 @EnableWebSecurity 注解标识配置类
 */
@EnableWebSecurity
public class WebSecurityConfig {


    // jwt 校验过滤器，从 http 头部 Authorization 字段读取 token 并校验
//    @Bean
//    public JwtAuthFilter authFilter() throws Exception {
//        return new JwtAuthFilter();
//    }

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

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 基于 token，不需要 csrf
                .csrf().disable()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 设置 jwtAuthError 处理认证失败、鉴权失败
//                .exceptionHandling().authenticationEntryPoint(jwtAuthError).accessDeniedHandler(jwtAuthError).and()
                // 下面开始设置权限
                .authorizeRequests(authorize -> authorize
                        // 请求放开
                        .antMatchers("/login").permitAll()
//                        .antMatchers("/**").permitAll()
                        // 其他地址的访问均需验证权限
                        .anyRequest().authenticated()
                )
                // 添加 JWT 过滤器，JWT 过滤器在用户名密码认证过滤器之前
//                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class)
                // 认证用户时用户信息加载配置，注入springAuthUserService
//                .userDetailsService(xxxAuthUserService)
                .build();
    }

}
