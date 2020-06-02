package com.cyf.mystorebackstage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("goods");
        registry.addViewController("/goods").setViewName("goods");
        registry.addViewController("/category").setViewName("category");
        registry.addViewController("/user").setViewName("user");
    }
}
