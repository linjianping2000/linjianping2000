package com.liang.apblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liangjin
 * @version V1.0
 * @package com.liang.cwen.config
 * @date 2021/6/5 20:45
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    private final String[] METHODS = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};

    @Value("${blog.cors.allowed-origins}")
    private String[] ORIGINS;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins(ORIGINS)
                .allowCredentials(true)
                .allowedMethods(METHODS)
                .maxAge(3600);
    }
}
