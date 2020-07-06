package com.springcloud.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class mutipartFileParams {

    /**
     * 配置文件上传大小
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("E:/");
        //  单个数据大小 10M
        factory.setMaxFileSize("610240KB");
        /// 总上传数据大小 10M
        factory.setMaxRequestSize("610240KB");
        return factory.createMultipartConfig();
    }
}
