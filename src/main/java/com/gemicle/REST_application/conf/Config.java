package com.gemicle.REST_application.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gemicle.REST_application.filter.MultipartFilter;
import com.gemicle.REST_application.model.HouseImpl;
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

    @Bean
    public ObjectMapper createOojectWrapper(){
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        module.addDeserializer(HouseImpl.class, new HouseDeserializer()); // register custom Deserializer

        module.addSerializer(HouseImpl.class, new HouseSerializer()); // register custom Serializer

        mapper.registerModule(module);

        return mapper;
    }
}
