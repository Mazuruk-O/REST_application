package com.gemicle.REST_application.conf;

import com.gemicle.REST_application.filter.MultipartFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class Config {

    @Bean
    public FilterRegistrationBean<MultipartFilter> loggingFilter(){
        FilterRegistrationBean<MultipartFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new MultipartFilter());
        registrationBean.addUrlPatterns("/acceptImageAndDataHouse/*");

        return registrationBean;
    }
}
