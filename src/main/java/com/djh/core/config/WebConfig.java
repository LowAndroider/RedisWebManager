package com.djh.core.config;

import com.djh.core.interceptor.RequestInfoInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInfoInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
    }
}
