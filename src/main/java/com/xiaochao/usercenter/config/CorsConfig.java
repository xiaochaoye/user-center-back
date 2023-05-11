package com.xiaochao.usercenter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 超
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路由
        registry.addMapping("/**")
//                .allowedOrigins("*")
            //设置允许跨域请求的域名
                .allowedOriginPatterns("*")
            //设置允许的方法
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
            //是否允许证书
                .allowCredentials(true)
            //跨域允许时间
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
