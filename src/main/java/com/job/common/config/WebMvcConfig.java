package com.job.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    /**
     * 跨域配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 允许跨域访问的域名
                .allowedOriginPatterns("*")
                // 是否允许Cookie
                .allowCredentials(true)
                // 允许的请求方法
                .allowedMethods("GET","POST")
                // 允许的请求头属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }
}
