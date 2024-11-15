package com.cdd.intercepter;

import com.sun.istack.internal.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootConfiguration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/book/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/dog/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/user/check");

    }

    public void setLoginInterceptor(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }
}
