package com.jv6.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jv6.interceptor.GlobalIntercepter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	GlobalIntercepter globall;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	// TODO Auto-generated method stub
    	registry.addInterceptor(globall).addPathPatterns("/**")
    	.excludePathPatterns("/rest/**", "/admin/**", "/assets/**");
    }
}